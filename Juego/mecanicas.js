const TIEMPODESAPARECE = 1000;
const TIEMPOSALTO = 300;
const ALTURASALTADA = 200;
const ALTURACAIDA= 30;
const TIEMPOCAIDA= 5000;

document.addEventListener("DOMContentLoaded", ()=>{
    var comienzo = false;
    var muerto = false;
    var jugador = document.querySelector("#jugador"); 

    //-----------MENU-----------------
    function ocultar(){//parametrizar para usar con pantalla fin para reiniciar
        var tutorial = document.querySelector("#tutorial");
        tutorial.getElementsByClassName.opacity = 1;
        var restante = null;

        function fade(timestamp){
            if(!restante){
                restante = timestamp;
            }
            let opacidad = 1 - ((timestamp - restante)/TIEMPODESAPARECE);
            tutorial.style.opacity = opacidad;
            if(opacidad > 0){
                requestAnimationFrame(fade);
            }else{
                tutorial.style.opacity = 0;
                tutorial.style.display = "none";
            }
        };
        requestAnimationFrame(fade);
    }

    //-------------JUEGO-------------------
    function salto(){
        vuelo(ALTURASALTADA,TIEMPOSALTO);
    }
    function vuelo(cantidad, tiempo){//ahora mismo vale para subir como para bajar
        var alturaActual = parseInt(getComputedStyle(jugador).bottom);
        console.log(alturaActual);
        var inicio = null;
        function animacion(timestamp){
            let acumulado = 0;
            if(!inicio){
                inicio = timestamp;
            }
            acumulado = timestamp - inicio;
            let desplazado = ((ALTURASALTADA*acumulado)/tiempo);
            jugador.style.setProperty("bottom", (alturaActual + desplazado + "px"));

            if(acumulado <tiempo){
                requestAnimationFrame(animacion)
            }else{
                jugador.style.setProperty("bottom",(alturaActual + cantidad+"px"));
            }
        };
        requestAnimationFrame(animacion); 
    }


    //necesito una función que todo el rato me tire para abajo que se ejecute
    //quizas un set INtervarl que se ejecute cuando no se salta , si se pulsa salta se para con clear interval, se salta y al acabar se vuelve a hacer la caida
    // while(!muerto){
    //     vuelo(ALTURACAIDA,TIEMPOCAIDA);
    // }
    //
    
document.getElementById("botonTutorial").addEventListener("click",ocultar);
window.addEventListener("keydown",salto);








});