function main(){
    var numpx = document.getElementById("mov").value;
    var bloque = document.querySelector(".block");

    function derecha(){
       var valor = bloque.style.left;
       console.log(valor);
     bloque.style.left = (valor + numpx);
    }
   function izquierda(){
        var valor = bloque.style.left;
        console.log(valor);
     bloque.style.left = (valor - numpx);
     }

    document.getElementById("right").addEventListener("click",derecha);
    document.getElementById("left").addEventListener("click",izquierda);
}

document.addEventListener("DOMContentLoaded", main);