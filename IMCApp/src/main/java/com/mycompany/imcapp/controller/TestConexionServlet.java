package com.mycompany.imcapp.controller;

import com.imc.util.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testconexion")
public class TestConexionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Connection conn = ConexionDB.getConnection();

            if (conn != null) {
                out.println("<h1>Conexion exitosa con Oracle</h1>");
            } else {
                out.println("<h1>Error de conexion</h1>");
            }

        } catch (Exception e) {
            out.println("<h1>Error:</h1>");
            out.println(e.getMessage());
        }

    }
}
