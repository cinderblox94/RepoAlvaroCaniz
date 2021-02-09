const TIEMPODESAPARECE = 1000;
const TIEMPOSALTO = 300;
const ALTURASALTADA = 100;
const ALTURACAIDA = -100;
const TIEMPOCAIDA = 600;// el ideal parece ser 500
const TIEMPOTUBERIA =1500;
const DIFICULTAD = 1000;

document.addEventListener("DOMContentLoaded", ()=>{
    const ANCHURATUBERIA = parseInt(getComputedStyle(document.querySelector(".tuberia")).width);
    const DISTANCIATUBERIA = parseInt(getComputedStyle(document.querySelector("#ventana")).width) + ANCHURATUBERIA;
    var jugador = document.querySelector("#jugador"); 
    var tuberias = [document.querySelector("#tAb1"),document.querySelector("#tAb2"),document.querySelector("#tAr1"),document.querySelector("#tAr2")];
    var orientArriba = [true, false];
    var displayContador = document.querySelector("#contador");
    var animTuberias;
    var animPajaro;
    var spawnTuberias;
    var comienzo = false;
    var muerto = false;
    var contador = 0;

    function randomTub(){
        var num = parseInt(Math.round(Math.random() * 3));
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
    function mostrar(){//parametrizar para usar con pantalla fin para reiniciar
        var tutorial = document.querySelector("#tutorial");
        tutorial.style.display = "block";
        tutorial.getElementsByClassName.opacity = 0;
        var restante = null;

        function fade(timestamp){
            if(!restante){
                restante = timestamp;
            }
            let opacidad =((timestamp - restante)/TIEMPODESAPARECE);
            tutorial.style.opacity = opacidad;
            if(opacidad < 0){
                requestAnimationFrame(fade);
            }else{
                tutorial.style.opacity = 1;
                
            }
        };
        requestAnimationFrame(fade);
    }
   
    //-------------JUEGO-------------------
    
    function iniciar(){
        function salto(){
                vuelo(ALTURASALTADA,TIEMPOSALTO);
                if(muerto){
                    cancelAnimationFrame(animPajaro);
                    cancelAnimationFrame(animTuberias);
                    clearInterval(spawnTuberias);
                    mostrar();
                }
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
           animPajaro =  requestAnimationFrame(animacion); 

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
           let indice = randomTub();
           let tubo = tuberias[indice];
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
                    if(indice>=2){//si es una tubería de arriba orientArriba[0] = true [1] = false
                        comprobar(tubo, orientArriba[0]);
                    }else{
                        comprobar(tubo, orientArriba[1]);
                    }
                    
                }else{
                    tubo.style.setProperty("left","100%");
                    contador++;
                    displayContador.innerHTML = contador;
                    
                    //no cuenta bien****************************************
                }
            };
            if(!muerto)
                animTuberias = requestAnimationFrame(animacion);
            
        }
        
        if(!muerto)
            spawnTuberias = setInterval(movTuberia,DIFICULTAD);

        window.addEventListener("keydown",salto);
        
        function comprobar(tubo, arriba){
            var tamTubo = tubo.getBoundingClientRect();
            var tamjugador = jugador.getBoundingClientRect();
            //OPTIMIZABLE***************si solo ejecuto en zona crítica solo se comprobará cuando choque verticalmente
            if(arriba){
                if(((tamTubo.bottom>=tamjugador.top)&&
                    (tamTubo.left<=tamjugador.right))//
                    ){
                        alert("arriba Tbot" + Math.round(tamTubo.bottom)+ "> Jtop" + Math.round(tamjugador.top)+ " y " +
                        "Tleft" + Math.round(tamTubo.left)+ "< Jrig" + Math.round(tamjugador.right));
                        muerto = true;

                }
            }else{//si el tubo no es de arriba
                if(((tamTubo.top<=tamjugador.bottom)&&
                    (tamTubo.left<=tamjugador.right))//
                    ){
                        alert("abajo Ttop" + Math.round(tamTubo.top)+ "< Jbottom" + Math.round(tamjugador.bottom)+ " y " +
                        "Tleft" + Math.round(tamTubo.left)+ "< Jrig" + Math.round(tamjugador.right));
                        muerto = true;
                }    
            }
           
        }

        
    }


    
    //añadir pantalla de muerte y reiniciar
    
    
    
    document.getElementById("botonTutorial").addEventListener("click",()=>{
        ocultar();
        iniciar();
    });
});