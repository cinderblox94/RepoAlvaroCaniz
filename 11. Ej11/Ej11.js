document.addEventListener("DOMContentLoaded",()=>{
    document.getElementById("avanzar").addEventListener("click",avance);
    document.getElementById("retroceder").addEventListener("click",retroceso);

    var cuadrado = [document.getElementById("c1"),document.getElementById("c2"),
                    document.getElementById("c3"),document.getElementById("c4")];

    function avance(){
        cuadrado.forEach(cuad => {
            cuad.style.left = "33rem";
        });
        cuadrado[0].style.top ="11rem";
        cuadrado[1].style.top="0rem";
        cuadrado[2].style.top="33rem";
        cuadrado[3].style.top="22rem";
    }

    function retroceso(){
        cuadrado.forEach(cuad => {
            cuad.style.left = "0rem";
        });
        cuadrado[0].style.top ="0rem";
        cuadrado[1].style.top="11rem";
        cuadrado[2].style.top="22rem";
        cuadrado[3].style.top="33rem";
    }


});