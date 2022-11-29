package com.example.ef_g12.Daos;

import com.example.ef_g12.Beans.EscaneoB;
import com.example.ef_g12.Beans.LaserB;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class LaserDao {

    public ArrayList<LaserB> obtenerListaTrabajos() {
        ArrayList<LaserB> listaLaser = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Escaneo");) {

            while (rs.next()) {
                LaserB laser = new LaserB();
                laser.setIdCorte(rs.getInt(1));
                laser.setGrosor(rs.getString(2));
                laser.setMaterial(rs.getString(3));
                laser.setDimensiones(rs.getInt(4));
                laser.setCosto(rs.getFloat(5));
                laser.setTiempo(rs.getFloat(6));



                listaLaser.add(laser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaLaser;

    }

    public void crearLaser(String idCorte, int grosor, String material, String dimensiones) {

        String sql = "INSERT INTO jobs (idCorte,grosor,material,dimensiones) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idCorte);
            pstmt.setInt(2, grosor);
            pstmt.setString(3, material);
            pstmt.setString(4, dimensiones);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
