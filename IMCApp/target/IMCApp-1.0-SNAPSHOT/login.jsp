<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
</head>

<body>

<h2>Iniciar Sesión</h2>

<form action="LoginServlet" method="post">

    Usuario:<br>
    <input type="text" name="username" required>
    <br><br>

    Contraseña:<br>
    <input type="password" name="password" required>
    <br><br>

    <input type="submit" value="Iniciar Sesión">

</form>

<br>

<a href="registro.jsp">Crear cuenta nueva</a>

</body>
</html>
