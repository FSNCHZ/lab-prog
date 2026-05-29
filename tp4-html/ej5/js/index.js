//Se usa onload porque las funciones se cargan antes que se carguen los elementos en la página, por lo que causa mensajes
window.onload = () => {
    const form = document.getElementById("form");
    const validarBtn = document.getElementById("validarBtn");
    const estadisticaBtn = document.getElementById("estadisticaBtn");
    const main = document.getElementById("main");

    //Crea un div, e inserta cada mensaje de error que recibe del array mensajes

    mostrarErrores = (errores) => {
        let divErrores = document.createElement("div");
        divErrores.innerHTML = `<h2 class="errores">Formulario Inválido</h2>`;
        errores.forEach(e => {
            divErrores.innerHTML += `<p>${e}</p>`;
        })
        //muestra el mensaje por 10 segundos
        main.append(divErrores);
        setTimeout(() => {
            divErrores.innerHTML = "";
        }, 10000);
        return false;
    }

    //Mismo funcionamiento que mostrarErrores, pero con mensaje de resolución
    
    mostrarOk = (mensaje) => {
        let divMensajes = document.createElement("div");
        divMensajes.innerHTML = `<h2 class="mensajes">Formulario Válido</h2>
                                 <p>${mensaje}</p>`;
        main.append(divMensajes);
        setTimeout(() => {
            divMensajes.innerHTML = "";
        }, 10000);
        return true;
    }

    //Validación 
    //Usa mostrarErrores() si hay errores o mostrarOk() si no hay errores y mostrar la resolución del expediente

    validarForm = () => {
        let mensaje;
        let errores = [];

        //Formato número expediente EXP-0000/25

        const numExp = document.getElementById("num-exp").value;

        //expresión regular con 4 digitos numéricos
        let regex = /^\d{4}$/;
        if(!numExp){ //Si no se ingresa un número
            mensaje = "Ingrese un número de expediente";
            errores.push(mensaje);
        } else if(!regex.test(numExp)){ //Si no coincide con la expresión regular
            mensaje = "Debe ingresar solamente los 4 números del expediente";
            errores.push(mensaje);
        }

        //Tipo de trámite

        const tipoExp = document.getElementById("tipo-exp").value;
        let mensajeTipo;
        if(tipoExp == "urgente"){
            mensajeTipo = "Resolución dentro de las 24 horas";
        } else if (tipoExp == "normal") {
            mensajeTipo = "Resolución dentro de las 48 horas";
        } else if(tipoExp == "bajo") {
            mensajeTipo = "Resolución dentro de las 96 horas";
        }

        //Días en trámite

        const diasTramite = document.getElementById("cant-dias").value;
        if(diasTramite <= 0){
            mensaje = "La cantidad de días en trámite debe ser mayor a 0";
            errores.push(mensaje);
        }

        //Estado

        const opcion = document.querySelector('input[name=estado]:checked');
        if(!opcion){
            mensaje = "Se debe seleccionar un estado del trámite";
            errores.push(mensaje);
        }

        //Responsable

        const responsable = document.getElementById("responsable").value.toUpperCase();
        regex = /[A-z]/;
        if(!regex.test(responsable)){
            mensaje = "El nombre del responsable solo debe tener carácteres alfabéticos";
        }
        
        //Si hay mensajes de error, los muestra; sino muestra el mensaje resolución
        if(errores.length > 0){
            mostrarErrores(errores);
            return false;
        } else {
            mostrarOk(mensajeTipo);
            return true;
        }
    }

    validarBtn.addEventListener("click", (event) => {
        event.preventDefault();
        validarForm();
    })

    mostrarProductividad = (productividad) => {
        let divProductividad = document.createElement("div");
        divProductividad.innerHTML = `<h2 class="divProductividad">Productividad</h2>`
        if(productividad < 2){
            divProductividad.innerHTML += `<p>Productividad baja</p>`
        } else if (productividad >= 2 && productividad <= 5){
            divProductividad.innerHTML += `<p>Productividad media</p>`
        } else if(productividad > 5){
            divProductividad.innerHTML += `<p>Productividad alta</p>`
        }
        main.append(divProductividad);
        setTimeout(() => {
            divProductividad.innerHTML = "";
        }, 10000)
    }

    estadisticaBtn.addEventListener("click", (event) => {
        event.preventDefault();

        if(!validarForm()){
            return;
        }

        const expGestionados = document.getElementById("exp-gestionados").value;
        const horasTrabajadas = document.getElementById("horas-trabajadas").value;

        let productividad = expGestionados/horasTrabajadas;
        mostrarProductividad(productividad);
    })

    //Generar JSON

    form.addEventListener("submit", (event) => {
        event.preventDefault();
        
        if(!validarForm()){
            return;
        }
        const formData = new FormData(form);
        const datos = Object.fromEntries(formData.entries());
        const datosJSON = JSON.stringify(datos, null, 2);

        let pre = document.createElement('pre');
        pre.innerHTML = `<h2>JSON generado</h2>${datosJSON}`;
        main.append(pre);
    })
}

