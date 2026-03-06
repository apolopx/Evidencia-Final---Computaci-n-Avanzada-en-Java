package com.imc.dao;

import com.imc.model.Usuario;
import com.imc.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // Registrar usuario
    public boolean registrarUsuario(Usuario u) {

        boolean registrado = false;

        try {

            Connection conn = ConexionDB.getConnection();

            String sql = "INSERT INTO usuarios (nombre, edad, genero, estatura, username, password) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getNombre());
            ps.setInt(2, u.getEdad());
            ps.setString(3, u.getGenero());
            ps.setDouble(4, u.getEstatura());
            ps.setString(5, u.getUsername());
            ps.setString(6, u.getPassword());

            ps.executeUpdate();

            registrado = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return registrado;
    }

    
    // Validar login
    public boolean validarUsuario(String username, String password) {

        boolean valido = false;

        try {

            Connection conn = ConexionDB.getConnection();

            String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                valido = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return valido;
    }

}
