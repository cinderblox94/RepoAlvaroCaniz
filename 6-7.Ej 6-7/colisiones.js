function main(){
    const TIEMPO = 1000;
    var bloque = document.querySelector(".block");
    var cuadrado = document.querySelector(".cuadrado");

    function comprobar(){
        var tamBloque = bloque.getBoundingClientRect();
        var tamCuadrado = cuadrado.getBoundingClientRect();
        //top y left del bloque, han de ser mayor a cuadrado
        //y que las cordenadas right y left sean menores que cuadrado
        if((tamBloque.left>= tamCuadrado.left)&&
            (tamBloque.top>= tamCuadrado.top)&&
            (tamBloque.right<=tamCuadrado.right)&&
            (tamBloque.bottom<=tamCuadrado.bottom)){
                //si está dentro se pone rojo y sin texto
                document.getElementById("texto").style.display ="none";
                bloque.style.backgroundColor ="red";
            }else{//si está fuera por defecto
                document.getElementById("texto").style.display="inline";
                bloque.style.backgroundColor="greenYellow";
            }
    }

    function mover(orientacion, direccion){
        //obtengo la cantidad de px desplazados consultando el input
       var numpx = parseInt(document.getElementById("mov").value)*direccion;
       //pregunto por la propiedad orientación (left o top) actual, es decir, su posición
       var posicionActual = parseInt(getComputedStyle(bloque).getPropertyValue(orientacion));
       
       var inicio = null;
      
        function animacion(timestamp){
            let acumulado = 0;
            //si no hay tiempo inicio, es igual al momento actual
            if(!inicio){
                inicio = timestamp;
            }
            acumulado = timestamp - inicio; 

            let desplazado = ((numpx*acumulado)/TIEMPO);

            bloque.style.setProperty(orientacion,((desplazado+posicionActual)+"px"));

            if(acumulado < TIEMPO)
                 requestAnimationFrame(animacion);
            else{
                bloque.style.setProperty(orientacion, ((posicionActual + numpx+ "px")));    
                comprobar();
            }
        };
        requestAnimationFrame(animacion);
    }
  

    document.getElementById("right").addEventListener("click",() => mover("left",1));
    document.getElementById("left").addEventListener("click",() => mover("left",-1));
    document.getElementById("top").addEventListener("click",() => mover("top",-1));
    document.getElementById("bottom").addEventListener("click",() => mover("top",1));

    //--------------------------
    
    bloque.addEventListener("dragstart", (event) => {
        var posRaton = event.target.getBoundingClientRect();

        //con esto compensamos el offset entre donde detecta el ratón y donde está el objeto
        event.dataTransfer.setData("text/plain",(parseInt(posRaton.left - event.clientX) + ',' + parseInt(posRaton.top - event.clientY)));
    });

    //hacemos que el div container (el cuadrado de los margenes) acepte elementos arrastrados
    // document.querySelector("#container").addEventListener("dragover",(event)=>{
    //     event.preventDefault();
    // });
    document.querySelector("#container").addEventListener("dragover", (event) => { 
		event.preventDefault(); 
	}); 

    //hemos configurado que hace cuando se coge el elemento y donde se deja, ahora queda la acción de soltarlo
    document.querySelector("#container").addEventListener("drop",(event)=>{
       //con dataTransfer puedo obtener los datps de la posición del elemento mientras lo mantengo
       var nuevaPos = event.dataTransfer.getData("text/plain").split(",");
        
       //Como en el dataTransfer de antes hemos restado la posición del bloque que arrastrabamos
       //la volvemos a sumar para tener la posición relativa a la pagina.
        bloque.style.left = (event.clientX + parseInt(nuevaPos[0]))+"px";
        bloque.style.top = (event.clientY + parseInt(nuevaPos[1])) + "px";
        comprobar();
    })
    
}

document.addEventListener("DOMContentLoaded", main);