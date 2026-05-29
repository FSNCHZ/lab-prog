//Validaciones
//Se usa onload porque las funciones se cargan antes que se carguen los elementos en la página, por lo que causa errores
window.onload = () => {
    const form = document.getElementById("form");
    
    form.addEventListener("submit", (event) => {
        event.preventDefault();
        let mensaje;
        let errores = [];

        //Formato número expediente EXP-0000/25

        const numExp = document.getElementById("num-exp").value;
        let regex = /^\d{4}$/;
        regex.test(numExp);
        if(!regex.test(numExp)){
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
            errores.push(mensaje);
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

        if(errores.length > 0) {
            mostrarMensajes(errores);
        } else {
            alert('Formulario válido');
            alert(mensajeTipo)
        }
    })

    //Se muestra el mensaje durante 10 segundos

    mostrarMensajes = (errores) => {
        const divErrores = document.getElementById("errores");
        divErrores.innerHTML = `<h2>Datos Inválidos</h2>`
        errores.forEach(e => {
            divErrores.innerHTML += `<p>${e}</p>`;
        })
        setTimeout(() => {
            divErrores.innerHTML = "";
        }, 10000)
    }

}

