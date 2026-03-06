<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cálculo de IMC</title>
</head>

<body>

<h2>Calcular Índice de Masa Corporal</h2>

<form action="CalculoIMCServlet" method="post">

    Masa corporal (kg):<br>
    <input type="number" name="peso" step="0.1" min="0.1" required>
    <br><br>

    <input type="submit" value="Calcular IMC">

</form>

<br>

<a href="index.jsp">Volver</a>

</body>
</html>
