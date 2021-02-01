const plantilla = document.createElement('template');
/*<details>
            <summary>
                <span>&lt;NECESITA NOMBRE&gt;</span>
                <span>NECESITA DESCRIPCION</span>
            </summary>
            <span>Ninguno</span>
        </details>*/
plantilla.innerHTML=`<style>
span:first-child{
 color:blue;
}
span:nth-of-type(2) span:nth-of-type(3){
    font-style: italic;
}
#atributo{
 background-color: blue;
color: white;
}
</style>`;
customElements.define('element-details',
    class extends HTMLElement{
        constructor(){
           super();
            this._shadowRoot = this.attachShadow({mode: 'open'});
            this._shadowRoot.appendChild(plantilla.content.cloneNode(true));
        }
    })
   