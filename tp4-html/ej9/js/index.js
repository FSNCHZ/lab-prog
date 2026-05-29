window.onload = () => {

    //Zoom a las imagenes de los articulos

    const botonesZoom = document.querySelectorAll(".zoom-btn");

    const modal = document.getElementById("modal");
    const imgModal = document.getElementById("img-modal");
    const cerrarModal = document.getElementById("cerrar-modal");

    botonesZoom.forEach(boton => {

        boton.addEventListener("click", () => {

            const figure = boton.closest(".img-card");
            const imagen = figure.querySelector(".article-img");

            imgModal.src = imagen.src;

            modal.style.display = "flex";
        });

    });

    cerrarModal.addEventListener("click", () => {
        modal.style.display = "none";
    });

    modal.addEventListener("click", (e) => {

        if(e.target === modal) {
            modal.style.display = "none";
        }

    });

    //Ocultar la barra de articulos relacionados

    const windowBtn = document.querySelector(".window-btn");
    
    windowBtn.addEventListener("click", () => {

        const artRelacionados = windowBtn.closest("div");
        const titulo = artRelacionados.querySelector("h2");
        const lista = artRelacionados.querySelector("ul");
        

        if(windowBtn.textContent == "-"){
            windowBtn.textContent = "□";
            titulo.style.display = "none";
            lista.style.display = "none";
        } else if (windowBtn.textContent == "□"){
            windowBtn.textContent = "-";
            titulo.style.display = "block";
            lista.style.display = "flex";
        }
        
    })

}