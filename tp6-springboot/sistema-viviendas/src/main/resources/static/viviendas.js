window.onload = () => {
    
    const form = document.getElementById("form");
    const guardarBtn = document.getElementById("btn-guardar")
    const main = document.getElementById("main");

    const modalHTML = `
    <div class="modal fade" id="modalErrores" tabindex="-1" aria-labelledby="modalErroresLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-danger text-white">
                    <h5 class="modal-title" id="modalErroresLabel">Formulario Inválido</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>
                <div class="modal-body" id="modal-body-errores"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>`;
 
    document.body.insertAdjacentHTML("beforeend", modalHTML);
 
    const modalEl = document.getElementById("modalErrores");
    const modalBodyEl = document.getElementById("modal-body-errores");
    const bsModal = new bootstrap.Modal(modalEl);

    const mostrarErrores = (errores) => {
        modalBodyEl.innerHTML = errores
            .map(e => `<p class="mb-1">• ${e}</p>`)
            .join("");
        bsModal.show();
    };

    validarForm = () => {
        let mensaje;
        let errores = [];

        const calle = document.getElementById("calle").value.trim();
        let regex = /^[A-Za-z ]{1,50}$/;
        if(!calle){
            mensaje = "Ingrese el nombre de la calle";
            errores.push(mensaje);
        } else if (!regex.test(calle)){
            mensaje = "Ingrese una calle alfabética de 50 caracteres máx.";
            errores.push(mensaje);
        }

        const numero = document.getElementById("nro").value;
        let regexNum = /^\d{1,5}$/;
        if(!numero || numero == 0){
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

        const habitantes = document.getElementById("numHabitantes").value;
        regexNum = /^\d{1,2}$/;
        if(!habitantes || habitantes == 0){
            mensaje = "Ingrese la cantidad de habitantes de la vivienda";
            errores.push(mensaje);
        } else if (!regexNum.test(habitantes)) {
            mensaje = "Ingrese una cantidad de habitantes de 2 digitos";
            errores.push(mensaje);
        }
        
        return errores;
    }

    guardarBtn.addEventListener("click", (event) => {
        event.preventDefault();

        const errores = validarForm();
 
        if (errores.length > 0) {
            mostrarErrores(errores);
        } else {
            form.submit();
        }
    })
}