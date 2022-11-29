package com.example.ef_g12.Daos;

import com.example.ef_g12.Beans.EscaneoB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class EscaneoBDao {

    public ArrayList<EscaneoBDao> obtenerListaTrabajos() {
        ArrayList<EscaneoBDao> listaEscaneos = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Escaneo");) {

            while (rs.next()) {
                EscaneoB escaneo = new EscaneoB();
                escaneo.setIdEscaneo(rs.getInt(1));
                escaneo.setLargo(rs.getInt(2));
                escaneo.setAncho(rs.getInt(3));
                escaneo.setAltura(rs.getInt(4));

                listaEscaneos.add(escaneo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEscaneos;

    }
}
