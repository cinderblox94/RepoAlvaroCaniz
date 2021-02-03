function slideUp(elemento, tiempo){
     alturaOriginal = parseInt(getComputedStyle(elemento).height);

    var restante = null;
    function slide(timestamp){
        if(!restante){
            restante = timestamp;
        }
        let alturaActual = null;

        if(tiempo == 0){
            alturaActual = 0;
        }else{
            alturaActual = alturaOriginal - (((timestamp - restante)/tiempo)*alturaOriginal);
            elemento.style.height = alturaActual+"px";
        }

        if(alturaActual > 0){//si está creciendo ejecuta slide
            requestAnimationFrame(slide);
        }else{//si está con altura 0, fuerzo el formato original
            elemento.style.height = alturaOriginal + "px";
            elemento.style.display = "none";
        }
    }
    requestAnimationFrame(slide);
}

function slideDown(elemento, tiempo){
   //en este la primera sale de golpe pero despues funciona, problema con el display
    elemento.style.display = "block";
    var restante = null;
    function slide(timestamp){
        if(!restante){
            restante = timestamp;
        }
        let alturaActual = null;

        if(tiempo == 0){
            alturaActual = alturaOriginal;
        }else{
            alturaActual =((timestamp - restante)/tiempo)*alturaOriginal;
            elemento.style.height = alturaActual+"px";
        }

        if(alturaActual < alturaOriginal){//si está creciendo ejecuta slide
            requestAnimationFrame(slide);
        }else{//si está con altura , fuerzo el formato original
            elemento.style.height = alturaOriginal + "px";
           
        }
    }
    requestAnimationFrame(slide);
}