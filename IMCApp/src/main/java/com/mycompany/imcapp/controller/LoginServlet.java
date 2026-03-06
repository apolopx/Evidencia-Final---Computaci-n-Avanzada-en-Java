package com.mycompany.imcapp.controller;

import com.imc.dao.UsuarioDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();

        boolean valido = dao.validarUsuario(username, password);

        if (valido) {

            HttpSession session = request.getSession();

            session.setAttribute("usuario", username);

            response.sendRedirect("index.jsp");

        } else {

            out.println("<html>");
            out.println("<body>");

            out.println("<h2>Usuario o contraseña incorrectos</h2>");

            out.println("<a href='login.jsp'>Intentar nuevamente</a>");

            out.println("</body>");
            out.println("</html>");

        }

    }
}