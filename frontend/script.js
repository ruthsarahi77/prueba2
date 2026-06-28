const API = "http://localhost:8080/api/eventos";

document.getElementById("formEvento").addEventListener("submit", function (e) {
    e.preventDefault();

    if (validarFormulario()) {
        crearEvento();
    }
});

function validarFormulario() {

    let valido = true;

    limpiarErrores();

    const nombre = document.getElementById("nombre").value.trim();
    const tipo = document.getElementById("tipo").value.trim();
    const fecha = document.getElementById("fecha").value;
    const capacidad = document.getElementById("capacidad").value;
    const ponenteId = document.getElementById("ponenteId").value;

    if (nombre.length < 5) {
        mostrarError("errorNombre", "Mínimo 5 caracteres");
        valido = false;
    }

    if (tipo === "") {
        mostrarError("errorTipo", "Campo obligatorio");
        valido = false;
    }

    if (!fecha) {
        mostrarError("errorFecha", "Selecciona una fecha");
        valido = false;
    }

    if (capacidad <= 0) {
        mostrarError("errorCapacidad", "Debe ser mayor a 0");
        valido = false;
    }

    if (!ponenteId) {
        mostrarError("errorPonente", "ID de ponente requerido");
        valido = false;
    }

    return valido;
}

function mostrarError(id, mensaje) {
    document.getElementById(id).innerText = mensaje;
}

function limpiarErrores() {
    document.querySelectorAll(".error").forEach(e => e.innerText = "");
}

function crearEvento() {

    const evento = {
        nombre: document.getElementById("nombre").value,
        tipo: document.getElementById("tipo").value,
        fecha: document.getElementById("fecha").value,
        capacidad: document.getElementById("capacidad").value,
        ponente: {
            id: document.getElementById("ponenteId").value
        },
        patrocinadores: []
    };

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(evento)
    })
    .then(res => res.json())
    .then(() => {
        alert("Evento creado");
        document.getElementById("formEvento").reset();
        listarEventos();
    });
}

function listarEventos() {

    fetch(API)
        .then(res => res.json())
        .then(data => {

            let html = "";

            data.forEach(evento => {

                html += `
                    <div class="evento">
                        <p><b>${evento.nombre}</b></p>
                        <p>Tipo: ${evento.tipo}</p>
                        <p>Fecha: ${evento.fecha}</p>
                        <p>Ponente: ${evento.ponente.nombre}</p>

                        <button onclick="eliminarEvento(${evento.id})">Eliminar</button>
                    </div>
                `;
            });

            document.getElementById("lista").innerHTML = html;
        });
}

function eliminarEvento(id) {

    fetch(`${API}/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Evento eliminado");
        listarEventos();
    });
}

listarEventos();