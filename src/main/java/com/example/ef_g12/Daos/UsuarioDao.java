package com.example.ef_g12.Daos;

import com.example.ef_g12.Beans.UsuarioB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class UsuarioDao {

    public ArrayList<UsuarioB> listarUsuarios() {

        ArrayList<UsuarioB> listaUsuarios = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from usuarios e\n")) {

            while (rs.next()) {
                UsuarioB usuario = new UsuarioB();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setCorreo(rs.getString(4));
                usuario.setContraseña(rs.getString(5));
                usuario.setTipo(rs.getString(6));




                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaUsuarios;
    }
}
