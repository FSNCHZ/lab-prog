window.onload = () => {
    const form = document.querySelector(".form");
    const modalHeader = document.querySelector(".modal-header h1");
    const modalBody = document.querySelector(".modal-body");
    const viviendas = document.querySelector(".viviendas .row")

    mostrarErrores = (errores) => {
        modalHeader.innerText = "Formulario Invalido";
        errores.forEach(e => {
            modalBody.innerHTML += `<p>${e}</p>`;
        })
        return false;
    }

    validarForm = () => {
        let mensaje;
        let errores = [];

        const id = document.getElementById("id-vivienda").value;
        let regexNum = /^\d{1,5}$/;
        if(!id){
            mensaje = "Ingrese el ID de la vivienda";
            errores.push(mensaje);
        } else if(!regexNum.test(id)){
            mensaje = "Debe ingresar un ID de 5 digitos";
            errores.push(mensaje);
        }

        const calle = document.getElementById("calle").value.trim();
        let regex = /^[A-Za-z ]{1,50}$/;
        if(!calle){
            mensaje = "Ingrese el nombre de la calle";
            errores.push(mensaje);
        } else if (!regex.test(calle)){
            mensaje = "Ingrese una calle alfabética de 50 caracteres máx.";
            errores.push(mensaje);
        }

        const numero = document.getElementById("numero").value;
        if(!numero){
            mensaje = "Ingrese el número de la calle";
            errores.push(mensaje);
        } else if (!regexNum.test(numero)) {
            mensaje = "Debe ingresar un número de calle de 5 digitos";
            errores.push(mensaje);
        }

        const titular = document.getElementById("titular").value.trim();
        regex = /^[A-Za-z ]{1,40}$/;
        if(!titular){
            mensaje = "Ingrese el nombre del titular";
            errores.push(mensaje);
        } else if (!regex.test(titular)) {
            mensaje = "Ingrese un nombre alfabético de 40 caracteres máx."
            errores.push(mensaje);
        }

        const habitantes = document.getElementById("habitantes").value;
        regexNum = /^\d{1,2}$/;
        if(!habitantes){
            mensaje = "Ingrese la cantidad de habitantes de la vivienda";
            errores.push(mensaje);
        } else if (!regexNum.test(habitantes)) {
            mensaje = "Ingrese una cantidad de habitantes de 2 digitos";
            errores.push(mensaje);
        }
        

        if(errores.length > 0){
            mostrarErrores(errores);
            return false;
        } else {
            return true;
        }
    }

    getIDBarrio = (barrio) => {
        const barrios = {
            belgrano: 1,
            evita: 2,
            centro: 3,
            "dos-abril": 4,
            fatima: 5,
            docente: 6,
            procrear: 7
        }
        return barrios[barrio] || 0;
    }

    nuevaCard = (datos) => {
        let card = document.createElement('div');
        card.classList = "col-sm-12 col-md-6 col-lg-4 card";
        card.innerHTML =    `<div class="card-body">
                                <h5 class="card-title mb-4">Vivienda ${datos["id-vivienda"]}</h5>
                                <div class="card-header">
                                    Datos
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Calle: ${datos.calle}</li>
                                    <li class="list-group-item">Numero: ${datos.numero}</li>
                                    <li class="list-group-item">Titular: ${datos.titular}</li>
                                    <li class="list-group-item">N° habitantes: ${datos.habitantes}</li>
                                    <li class="list-group-item">Barrio: ${datos.barrio.toUpperCase()}</li>
                                </ul>
                            </div>`;
        return card;
    }

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        if(!validarForm()){
            return;
        }

        modalHeader.innerText = "¡Vivienda agregada correctamente!"

        const formData = new FormData(form);
        let datos = Object.fromEntries(formData.entries());
        //retorna el id según el nombre del barrio
        let idBarrio = getIDBarrio(datos["nombre-barrio"]);

        //sobreescribe el objeto datos
        datos = {
            ...datos,
            "id-barrio": idBarrio,
        }

        console.log(datos);
        

        let card = nuevaCard(datos);
        viviendas.appendChild(card);
    })

}