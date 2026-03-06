<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Historial de IMC</title>

    <script>

        function cargarHistorial() {

            fetch("api/imc/historial/1")
            .then(response => response.json())
            .then(data => {

                let tabla = document.getElementById("tablaHistorial");

                data.forEach(registro => {

                    let fila = tabla.insertRow();

                    fila.insertCell(0).innerHTML = registro.peso;
                    fila.insertCell(1).innerHTML = registro.imc;
                    fila.insertCell(2).innerHTML = registro.clasificacion;

                    let fecha = new Date(registro.fecha);
                    fila.insertCell(3).innerHTML = fecha.toLocaleDateString();

                });

            })
            .catch(error => console.log(error));
        }

        window.onload = cargarHistorial;

    </script>

</head>

<body>

<h2>Historial de IMC</h2>

<table border="1">

    <thead>
        <tr>
            <th>Peso</th>
            <th>IMC</th>
            <th>Clasificación</th>
            <th>Fecha</th>
        </tr>
    </thead>

    <tbody id="tablaHistorial">
    </tbody>

</table>

<br>

<a href="index.jsp">Volver</a>

</body>
</html>
