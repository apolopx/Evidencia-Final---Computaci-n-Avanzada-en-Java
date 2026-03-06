package com.mycompany.imcapp.controller;

import com.imc.dao.UsuarioDAO;
import com.imc.model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String genero = request.getParameter("genero");
            double estatura = Double.parseDouble(request.getParameter("estatura"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Validaciones adicionales
            if (edad < 15) {
                out.println("<h2>Error: edad mínima 15 años</h2>");
                return;
            }

            if (estatura < 1 || estatura > 2.5) {
                out.println("<h2>Error: estatura debe estar entre 1 y 2.5 metros</h2>");
                return;
            }

            Usuario u = new Usuario(nombre, edad, genero, estatura, username, password);

            UsuarioDAO dao = new UsuarioDAO();

            boolean registrado = dao.registrarUsuario(u);

            if (registrado) {
                out.println("<h2>Usuario registrado correctamente</h2>");
            } else {
                out.println("<h2>Error al registrar usuario</h2>");
            }

        } catch (Exception e) {

            out.println("<h2>Error:</h2>");
            out.println(e.getMessage());

        }

    }

}
