package com.ufpr.tads.web2.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ufpr.tads.web2.beans.Usuario;
import Connection.UsuarioDAO;
import com.ufpr.tads.web2.beans.LoginBean;
//import static com.oracle.webservices.internal.api.message.MessageContextFactory.create;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Itay
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = new Usuario();
            
            //response from form
            String loginForm = request.getParameter("login");
            String passwordForm = request.getParameter("password");
            
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte[] messageDigest = algorithm.digest(passwordForm.getBytes("UTF-8"));
            String cripto = new String(messageDigest);
            
            usuario = dao.selectUsuarioEspecifico(loginForm, cripto);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");

            
            if((usuario != null) && (usuario.getLoginUsuario().equals(loginForm)) && (usuario.getSenhaUsuario().equals(cripto))) {
                LoginBean loginBean = new LoginBean();
                loginBean.setIdUsuario(usuario.getIdUsuario());
                loginBean.setNomeUsuario(usuario.getNomeUsuario());
                HttpSession session = request.getSession();
                session.setAttribute("login", loginBean);

                out.println("<p>Usuário " + loginForm + " logado com sucesso</p><br>");
                out.println("<a href=\"portal.jsp\">Portal Servlet</a>");
            }  else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário/Senha inválidos.");
                rd.forward(request, response);
            }
            
            out.println("</body>");
            out.println("</html>");
            
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
