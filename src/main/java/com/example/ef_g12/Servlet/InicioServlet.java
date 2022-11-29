package com.example.ef_g12.Servlet;

import com.example.ef_g12.Beans.UsuarioB;
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
        DaoCliente daoCliente = new DaoCliente();

        String documento = request.getParameter("documento");
        String contrasena  = request.getParameter("contrasena");
        UsuarioB credentials = daoCliente.buscarUsuario(documento,contrasena);
        if(credentials !=null){
            HttpSession session = request.getSession();
            session.setAttribute("credentials",credentials);
            if (credentials.getTipoUsuario()==1){
                response.sendRedirect(request.getContextPath() + "/ServletAdmin");
            }else if (credentials.getTipoUsuario()==2){
                response.sendRedirect(request.getContextPath() + "/ServletUser");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "ServletLogin");
        }
    }
}
