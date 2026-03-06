<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("usuario") == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Menú Principal</title>
</head>

<body>

<h1>Menú Principal</h1>

<ul>

    <li><a href="calculoIMC.jsp">Calcular IMC</a></li>

    <li><a href="historial.jsp">Ver Historial</a></li>    

</ul>

</body>
</html>
