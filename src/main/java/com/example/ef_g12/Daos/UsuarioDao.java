package com.example.ef_g12.Daos;

import com.example.ef_g12.Beans.UsuarioB;

import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class UsuarioDao extends DaoBase{

    public ArrayList<UsuarioB> listarUsuarios() {

        ArrayList<UsuarioB> listaUsuarios = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from usuarios e\n")) {

            while (rs.next()) {
                UsuarioB usuario = new UsuarioB();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));


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

    public void crearUsuario(UsuarioB usuario) {


        String sql = "INSERT INTO usuario (correo, contrasena) VALUES (?,sha2(?,256))";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getCorreo());
            pstmt.setString(2, usuario.getContraseña());



            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
