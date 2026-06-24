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

        const nombre = document.getElementById("nombre").value.trim();
        let regex = /^[A-Za-z1-9 ]{1,30}$/;
        if(!nombre){
            mensaje = "Ingrese el nombre del barrio";
            errores.push(mensaje);
        } else if (!regex.test(nombre)){
            mensaje = "Ingrese una barrio con nombre alfabético de 30 caracteres máx.";
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