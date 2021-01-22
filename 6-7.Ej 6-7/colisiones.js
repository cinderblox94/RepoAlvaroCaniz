function main(){
    
    var bloque = document.querySelector(".block");

    function mover(orientacion, direccion){
       var numpx = parseInt(document.getElementById("mov").value);
       var valor = parseInt(getComputedStyle(bloque).getPropertyValue(orientacion));
       console.log(numpx);
       console.log(valor);
       bloque.style.setProperty(orientacion, ((valor + (numpx*direccion) + "px")));
        console.log(parseInt(getComputedStyle(bloque).getPropertyValue(orientacion)));
    }
   function izquierda(){
       var numpx = document.getElementById("mov").value;
        var valor = bloque.style.left;
        console.log(valor);
     bloque.style.left = (valor - numpx)+"px";
     }

    document.getElementById("right").addEventListener("click",() => mover("left",1));
    document.getElementById("left").addEventListener("click",() => mover("left",-1));
    document.getElementById("top").addEventListener("click",() => mover("top",-1));
    document.getElementById("bottom").addEventListener("click",() => mover("top",1));
}

document.addEventListener("DOMContentLoaded", main);