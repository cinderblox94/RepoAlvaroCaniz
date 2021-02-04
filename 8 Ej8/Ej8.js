   

        document.addEventListener("DOMContentLoaded", () =>{
            var myVar1, myvar2, myVar3,myVar4;
        //Cada función rellena y muestra su respectiva linea
        function prim(){
            document.getElementById("primero").innerHTML = "Primero";
        }
        function segun(){
            document.getElementById("segundo").innerHTML = "Segundo";
        }
        function terc(){
            document.getElementById("tercero").innerHTML = "Tercero";
        }
        function cuart(){
            document.getElementById("cuarto").innerHTML = "Cuarto";
        }
        function limpiar(){
            document.getElementById("primero").innerHTML = "";
            document.getElementById("segundo").innerHTML = "";
            document.getElementById("tercero").innerHTML = "";
            document.getElementById("cuarto").innerHTML = "";
        }
        function animacion(){
           
           myVar1 = setTimeout(prim, 1000);
           myVar2 = setTimeout(segun, 2000);
           myVar3 = setTimeout(terc, 3000);
           myVar4 = setTimeout(cuart, 4000);
           
            requestAnimationFrame(animacion);
        }
      
        
        var elementos = document.querySelectorAll("p");
        for(var i = 0; i< elementos.length; i++){
                elementos[i].addEventListener("click", animacion);
        }

        requestAnimationFrame(animacion);
        });
        