window.onload = () => {
    
    const form = document.getElementById("form");
    const validarBtn = document.getElementById("validarBtn");
    const main = document.getElementById("main");

    const mostrarErrores = (errores) => {
        let listaErrores = "";
        errores.forEach(error => {
            listaErrores += `<p>${error}</p>`;
        });
        crearCard(
            "Formulario inválido",
            listaErrores,
            "card-error"
        );
        return false;
    }

    const validarForm = () => {
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

    validarBtn.addEventListener("click", (event) => {
        event.preventDefault();
        validarForm();
    })

    //El id del barrio se asigna dependiendo del barrio que sea, asi el usuario no tiene que ingresar el id

    const getIDBarrio = (barrio) => {
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

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        if(!validarForm()){
            return;
        }

        const formData = new FormData(form);
        let datos = Object.fromEntries(formData.entries());
        //retorna el id según el nombre del barrio
        let idBarrio = getIDBarrio(datos["nombre-barrio"]);

        //sobreescribe el objeto datos
        datos = {
            ...datos,
            "id-barrio": idBarrio,
        }
        const datosJSON = JSON.stringify(datos, null, 2);

        crearCard(
            "JSON generado",
            `<pre>${datosJSON}</pre>`,
            "card-json"
        );
    })

    const crearCard = (titulo, contenido, tipo = "") => {

    const cardContainer = document.createElement("div");
    cardContainer.classList.add("card-container");

    const card = document.createElement("div");
    card.classList.add("card");

    if(tipo){
        card.classList.add(tipo);
    }

    card.innerHTML = `
        <button class="cerrar-card">✖</button>
        <h2>${titulo}</h2>
        ${contenido}
    `;

    cardContainer.append(card);
    document.body.append(cardContainer);

    const cerrarBtn = card.querySelector(".cerrar-card");

    cerrarBtn.addEventListener("click", () => {
        cardContainer.remove();
    });

    // cerrar tocando fuera de la card
    cardContainer.addEventListener("click", (e) => {
        if(e.target === cardContainer){
            cardContainer.remove();
        }
    });
}
} 