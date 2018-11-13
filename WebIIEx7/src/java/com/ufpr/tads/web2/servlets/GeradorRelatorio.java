/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
/**
 *
 * @author Itay
 */
@WebServlet(name = "GeradorRelatorio", urlPatterns = {"/GeradorRelatorio"})
public class GeradorRelatorio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            Connection con = null;            
            HttpSession session = request.getSession();
            LoginBean loginBean = (LoginBean) session.getAttribute("login");
           
            if(loginBean != null) {
                int id;
                RequestDispatcher rd;
                String action = request.getParameter("action");

                // Conexão com o banco
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WEB2", "root", "");

                if (action != null) {
                    switch (action) {
                        case "todosClientes":
                            // Caminho contextualizado do relatório compilado
                            String jasper = request.getContextPath() + "/TodosOsClientes.jasper";
                            
                            // Host onde o servlet esta executando
                            String host = "http://" + request.getServerName() + ":" + request.getServerPort();

                            // URL para acesso ao relatório
                            URL jasperURL = new URL(host + jasper);

                            // Parâmetros do relatório
                            HashMap params = new HashMap();

                            // Geração do relatório
                            byte[] bytes = JasperRunManager.runReportToPdf(
                                    jasperURL.openStream(), params, con);

                            if (bytes != null) {
                                
                                // A página será mostrada em PDF
                                response.setContentType("application/pdf");

                                // Envia o PDF para o Cliente
                                OutputStream ops = response.getOutputStream();
                                ops.write(bytes);
                            }
                            break;
                            
                            case "AtendimentosResolvidos":
                            // Caminho contextualizado do relatório compilado
                            jasper = request.getContextPath() + "/AtendimentosResolvidos.jasper";

                            // Host onde o servlet esta executando
                            host = "http://" + request.getServerName() + ":" + request.getServerPort();

                            // URL para acesso ao relatório
                            jasperURL = new URL(host + jasper);

                            // Parâmetros do relatório
                            params = new HashMap();

                            // Geração do relatório
                            bytes = JasperRunManager.runReportToPdf(
                                    jasperURL.openStream(), params, con);

                            if (bytes != null) {

                                // A página será mostrada em PDF
                                response.setContentType("application/pdf");

                                // Envia o PDF para o Cliente
                                OutputStream ops = response.getOutputStream();
                                ops.write(bytes);
                            }
                            break;                        
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Driver BD não encontrado : "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de conexão ou query: "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (JRException e) {
            request.setAttribute("mensagem", "Erro no Jasper : "
                    + e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } finally {
            if (con != null) {
                try { con.close(); } catch (Exception e) { }
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
