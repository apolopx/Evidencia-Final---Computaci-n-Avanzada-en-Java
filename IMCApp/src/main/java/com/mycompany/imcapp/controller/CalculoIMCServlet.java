package com.mycompany.imcapp.controller;

import com.imc.dao.IMCDAO;
import com.imc.model.RegistroIMC;
import com.imc.util.ConexionDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CalculoIMCServlet")
public class CalculoIMCServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("usuario");

            double peso = Double.parseDouble(request.getParameter("peso"));

            Connection conn = ConexionDB.getConnection();

            String sql = "SELECT id_usuario, estatura FROM usuarios WHERE username=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            double estatura = 0;
            int idUsuario = 0;

            if (rs.next()) {
                estatura = rs.getDouble("estatura");
                idUsuario = rs.getInt("id_usuario");
            }

            double imc = peso / (estatura * estatura);

            String clasificacion;

            if (imc < 18.5) {
                clasificacion = "Bajo peso";
            } else if (imc < 25) {
                clasificacion = "Peso normal";
            } else if (imc < 30) {
                clasificacion = "Sobrepeso";
            } else {
                clasificacion = "Obesidad";
            }

            RegistroIMC registro = new RegistroIMC();

            registro.setPeso(peso);
            registro.setImc(imc);
            registro.setClasificacion(clasificacion);
            registro.setIdUsuario(idUsuario);

            IMCDAO dao = new IMCDAO();
            boolean guardado = dao.guardarIMC(registro);

            if (guardado) {
                out.println("<h3>Registro guardado en base de datos</h3>");
            } else {
                out.println("<h3>No se pudo guardar el registro</h3>");
            }

            out.println("<h2>Tu IMC es: " + imc + "</h2>");
            out.println("<h2>Clasificación: " + clasificacion + "</h2>");

        } catch (Exception e) {

            out.println("<h2>Error:</h2>");
            out.println(e.getMessage());

        }

    }

}

