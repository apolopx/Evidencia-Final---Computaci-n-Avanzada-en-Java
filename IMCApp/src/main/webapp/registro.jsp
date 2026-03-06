<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
</head>

<body>

<h2>Registro de Usuario</h2>

<form action="RegistroServlet" method="post">

    Nombre completo:<br>
    <input type="text" name="nombre" required>
    <br><br>

    Edad:<br>
    <input type="number" name="edad" min="15" required>
    <br><br>

    Sexo:<br>
    <select name="genero" required>
        <option value="Masculino">Masculino</option>
        <option value="Femenino">Femenino</option>
    </select>
    <br><br>

    Estatura (metros):<br>
    <input type="number" step="0.01" name="estatura" min="1" max="2.5" required>
    <br><br>

    Nombre de usuario:<br>
    <input type="text" name="username" required>
    <br><br>

    Contraseña:<br>
    <input type="password" name="password" required>
    <br><br>

    <input type="submit" value="Registrarse">

</form>

</body>
</html>
