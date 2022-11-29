package com.example.ef_g12.Daos;

import com.example.ef_g12.Beans.EscaneoB;
import com.example.ef_g12.Beans.ImpresionB;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class ImpresionDao {

    public ArrayList<ImpresionB> obtenerListaTrabajos() {
        ArrayList<ImpresionB> listaImpresiones = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Escaneo");) {

            while (rs.next()) {
                EscaneoB impresion = new EscaneoB();
                impresion.setIdEscaneo(rs.getInt(1));
                impresion.setLargo(rs.getInt(2));
                impresion.setAncho(rs.getInt(3));
                impresion.setAltura(rs.getInt(4));
                impresion.setCosto(rs.getFloat(5));
                impresion.setTiempo(rs.getFloat(6));



                listaImpresiones.add(impresion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaImpresiones;

    }

    public void crearEscaneo(String idImpresion, int densidad, int grosor, int altura, String material, String autoservicio) {

        String sql = "INSERT INTO IMPRESIONES (idEscaneo,largo,ancho,altura) VALUES (?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idImpresion);
            pstmt.setInt(2, densidad);
            pstmt.setInt(3,grosor );
            pstmt.setInt(4, altura);
            pstmt.setString(5, material);
            pstmt.setString(6, autoservicio);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
