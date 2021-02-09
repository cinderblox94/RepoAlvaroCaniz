const TIEMPODESAPARECE = 1000;
const TIEMPOSALTO = 300;
const ALTURASALTADA = 150;
const ALTURACAIDA = -150;
const TIEMPOCAIDA = 450;// el ideal parece ser 500

const TIEMPOTUBERIA =1500;

document.addEventListener("DOMContentLoaded", ()=>{
    const ANCHURATUBERIA = parseInt(getComputedStyle(document.querySelector(".tuberia")).width);
    const DISTANCIATUBERIA = parseInt(getComputedStyle(document.querySelector("#ventana")).width) + ANCHURATUBERIA;
    var jugador = document.querySelector("#jugador"); 
    var tuberias = [document.querySelector("#tAb1"),document.querySelector("#tAb2"),document.querySelector("#tAr1"),document.querySelector("#tAr2")];
    var displayContador = document.querySelector("#contador");
    var comienzo = false;
    var muerto = false;
    var contador = 0;

    function randomTub(){
        var num = parseInt(Math.round(Math.random() * 3));
        console.log((num));
        return num;
    }
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
        
        function vuelo(cantidad, tiempo){//vale para subir como para bajar
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
                    if(alturaActual > 0){   
                        caida();
                    }
                }
            };
            requestAnimationFrame(animacion); 

            //Aquí arranco el juego
            if(comienzo ==false){
                movTuberia(tuberias[0]);
                comienzo = true;
            }
        }

        function caida(){
            vuelo(ALTURACAIDA,TIEMPOCAIDA);
        }
    
        //DESARROLLO AUTOMÁTICO DEL JUEGO SIN INTERACCION----

        //tiene un despazamiento por cada tubería
        function movTuberia(){
            let tubo = tuberias[randomTub()];
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
                    //este es un  buen candidato a meter el comprobador dado que es donde actualiza cada frame 
                    // cuando entre en rango del bicho que calcule si choca en base al tipo que es
                    comprobar();
                }else{
                    tubo.style.setProperty("left","100%");
                    contador++;
                    displayContador.innerHTML = contador;
                    //no cuenta bien****************************************
                }
            };
            requestAnimationFrame(animacion);
            
        }
        var animacionTuberias = setInterval(movTuberia,1000);
        window.addEventListener("keydown",salto);
        
        function comprobar(){
            //rellenar***********************************************************
        }
        
    }


    //añadir en la función que más convenga una funcion de comprobar posición para ver si ha chocado

    //añadir pantalla de muerte y reiniciar
    
    
    
    document.getElementById("botonTutorial").addEventListener("click",()=>{
        ocultar();
        iniciar();
    });
});