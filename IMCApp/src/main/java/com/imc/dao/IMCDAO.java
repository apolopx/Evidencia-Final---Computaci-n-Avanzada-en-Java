package com.imc.dao;

import com.imc.model.RegistroIMC;
import com.imc.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IMCDAO {

    public boolean guardarIMC(RegistroIMC r) {

        boolean guardado = false;

        try {

            Connection conn = ConexionDB.getConnection();

            String sql = "INSERT INTO registros_imc (peso, imc, clasificacion, fecha, id_usuario) VALUES (?, ?, ?, SYSDATE, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, r.getPeso());
            ps.setDouble(2, r.getImc());
            ps.setString(3, r.getClasificacion());
            ps.setInt(4, r.getIdUsuario());

            ps.executeUpdate();

            guardado = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return guardado;
    }

    public List<RegistroIMC> obtenerHistorial(int idUsuario) {

        List<RegistroIMC> lista = new ArrayList<>();

        try {

            Connection conn = ConexionDB.getConnection();

            String sql = "SELECT peso, imc, clasificacion, fecha, id_usuario FROM registros_imc WHERE id_usuario=? ORDER BY fecha DESC";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                RegistroIMC r = new RegistroIMC();

                r.setPeso(rs.getDouble("peso"));
                r.setImc(rs.getDouble("imc"));
                r.setClasificacion(rs.getString("clasificacion"));
                r.setFecha(rs.getDate("fecha"));
                r.setIdUsuario(rs.getInt("id_usuario"));

                lista.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
