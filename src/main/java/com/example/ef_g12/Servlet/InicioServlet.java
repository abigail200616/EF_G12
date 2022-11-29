package com.example.ef_g12.Servlet;

import com.example.ef_g12.Beans.UsuarioB;
import com.example.ef_g12.Daos.UsuarioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sun.security.krb5.Credentials;


import java.io.IOException;

@WebServlet(name = "InicioServlet", value = "/InicioServlet")
public class InicioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request,response);
        }
        else{
            switch (action){
                case "":
                    UsuarioB user = (UsuarioB) request.getSession().getAttribute("userlogged");
                    if (user != null && user.getIdUsuario() != 0 && user.getIdUsuario() != 1) {
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registroServicios.jsp");
                        requestDispatcher.forward(request, response);
                    } else {
                        HttpSession session = request.getSession();
                        session.invalidate();
                        response.sendRedirect(request.getContextPath() + "/ServletInicio");
                        //requestDispatcher = request.getRequestDispatcher("inicioDeSesion.jsp");
                        //requestDispatcher.forward(request, response);
                    }
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDao daoUsuario = new UsuarioDao();
        String action = request.getParameter("action");
        String correo = request.getParameter("correo");
        String contrasena  = request.getParameter("contrasena");
        UsuarioB usuario = daoUsuario.crearUsuario(correo, contrasena);
        if(usuario !=null){
            HttpSession session = request.getSession();
            session.setAttribute("userlogged",usuario);
        }else{
            response.sendRedirect(request.getContextPath() + "InicioServlet");
        }

    }
}
