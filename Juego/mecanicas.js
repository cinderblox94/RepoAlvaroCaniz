const TIEMPODESAPARECE = 1000;
const TIEMPOSALTO = 300;
const ALTURASALTADA = 200;
const ALTURACAIDA = -150;
const TIEMPOCAIDA = 1000;

const TIEMPOTUBERIA =2000;

document.addEventListener("DOMContentLoaded", ()=>{
    const ANCHURATUBERIA = parseInt(getComputedStyle(document.querySelector(".tuberia")).width)
    const DISTANCIATUBERIA = parseInt(getComputedStyle(document.querySelector("#ventana")).width) + ANCHURATUBERIA;
    var comienzo = false;
    var muerto = false;
    var jugador = document.querySelector("#jugador"); 
    var tuberia = document.querySelector(".tuberia");

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
    
    function iniciar(){

        function salto(){
            vuelo(ALTURASALTADA,TIEMPOSALTO);
           
        }
         
        function vuelo(cantidad, tiempo){//ahora mismo vale para subir como para bajar
            let alturaActual = parseInt(getComputedStyle(jugador).bottom);
            let inicio = null;

            function animacion(timestamp){
                let acumulado = 0;
                if(!inicio){
                    inicio = timestamp;
                }
                acumulado = timestamp - inicio;
                let desplazado = ((cantidad*acumulado)/tiempo);
                jugador.style.setProperty("bottom", (alturaActual + desplazado + "px"));
    
                if(acumulado <tiempo){
                    requestAnimationFrame(animacion)
                }else{
                    jugador.style.setProperty("bottom",(alturaActual + cantidad+"px"));
                    caida();
                }
            };
            requestAnimationFrame(animacion); 

            if(comienzo ==false){
                movTuberia(tuberia);
                comienzo = true;
            }
        }

        function caida(){
           vuelo(ALTURACAIDA,TIEMPOCAIDA);
           console.log(ALTURACAIDA>0);
        }
    
        //DESARROLLO AUTOMÁTICO DEL JUEGO SIN INTERACCION----

        //tiene un despazamiento por cada tubería
        function movTuberia(tubo){
            let posActual = parseInt(getComputedStyle(tubo).left);
            let inicio = null;

            function animacion(timestamp){
                let acumulado = 0;
                if(!inicio){
                    inicio = timestamp;
                }
                acumulado = timestamp - inicio;
                let desplazado = ((DISTANCIATUBERIA*acumulado)/TIEMPOTUBERIA);
                tubo.style.setProperty("left", (posActual - desplazado +"px"));

                if(acumulado < TIEMPOTUBERIA){
                    requestAnimationFrame(animacion);
                }else{
                    tubo.style.setProperty("left",(posActual - DISTANCIATUBERIA));
                }
            };
            requestAnimationFrame(animacion);
        }
        window.addEventListener("keydown",salto);
    }


    
    
    
document.getElementById("botonTutorial").addEventListener("click",()=>{
    ocultar();
    iniciar()});
});