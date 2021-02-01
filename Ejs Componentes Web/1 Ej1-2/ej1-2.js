document.addEventListener("DOMContentLoaded", ()=>{
class WcBlink extends HTMLElement {
    constructor(){
         super();
         //valores por defecto?9

        var elemento = document.querySelector("wc-blink");
        
        baseColor = elemento.getAttribute("baseColor");
        alternativeColor = elemento.getAttribute("alternativeColor");
        changeInterval = elemento.getAttribute("changeInterval");

        //establezco el color
        
        elemento.style.setProperty("color",baseColor);
    

        console.log(baseColor," " ,alternativeColor," ",changeInterval);
        console.log(getComputedStyle(elemento).getPropertyValue("color"));
        
        

        window.setInterval(()=>{
            
            if (getComputedStyle(elemento).getPropertyValue("color") == baseColor) {//ver en funcion del color actual
                
                //si es el base lo cambia a alternative
                    console.log(getComputedStyle(elemento).getPropertyValue("color"));
                    elemento.style.setProperty("color",alternativeColor);
            }else{
                elemento.style.setProperty("color",baseColor);
            }            
        },parseInt(changeInterval)); 
    }
    
}
customElements.define("wc-blink", WcBlink);
});
