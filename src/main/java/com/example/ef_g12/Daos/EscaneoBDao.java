package com.example.ef_g12.Daos;

import com.example.ef_g12.Beans.EscaneoB;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class EscaneoBDao {

    public ArrayList<EscaneoB> obtenerListaTrabajos() {
        ArrayList<EscaneoB> listaEscaneos = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Escaneo");) {

            while (rs.next()) {
                EscaneoB escaneo = new EscaneoB();
                escaneo.setIdEscaneo(rs.getInt(1));
                escaneo.setLargo(rs.getInt(2));
                escaneo.setAncho(rs.getInt(3));
                escaneo.setAltura(rs.getInt(4));
                escaneo.setCosto(rs.getFloat(5));
                escaneo.setTiempo(rs.getFloat(6));



                listaEscaneos.add(escaneo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEscaneos;

    }

    public void crearEscaneo(String jobId, String jobTitle, int minSalary, int maxSalary) {

        String sql = "INSERT INTO jobs (idEscaneo,largo,ancho,altura) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, );
            pstmt.setString(2, );
            pstmt.setInt(3, );
            pstmt.setInt(4, );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}