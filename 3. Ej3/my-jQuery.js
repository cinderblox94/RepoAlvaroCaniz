function fadeOut(elemento, tiempo){
    elemento.style.opacity = 1;

    var restante = null;
    
    function fade(timestamp){//timestamp es el tiempo transcurrido
        if(!restante){//si el no hay tiempo restante, es igual al momento actual;
            restante = timestamp;
        }
        let opacidad = 1 -((timestamp - restante)/tiempo);// la parte proporcional sobre 1 en la que estamos
        elemento.style.opacity = opacidad;

        if(opacidad > 0){
            requestAnimationFrame(fade);
        }else{
            elemento.style.opacity = 0;//para evitar decimales se fuerza el valor 0
            
        }
        
    
    };
    requestAnimationFrame(fade);//desde aquí llamo a fade y dentro de allí se irá retrollamanndo
}

function fadeIn(elemento, tiempo){
    elemento.style.opacity = 0;
    var restante = null;
    
    function fade(timestamp){//timestamp es el tiempo transcurrido
        if(!restante){//si el no hay tiempo restante, es igual al momento actual;
            restante = timestamp;
        }
        let opacidad = (timestamp - restante)/tiempo;// la parte proporcional sobre 1 en la que estamos
        elemento.style.opacity = opacidad;

        if(opacidad < 1){
            requestAnimationFrame(fade);
        }else{
            elemento.style.opacity = 1;//para evitar decimales se fuerza el valor 1
            
        }
        
    
    };
    requestAnimationFrame(fade);//desde aquí llamo a fade y dentro de allí se irá retrollamanndo
}