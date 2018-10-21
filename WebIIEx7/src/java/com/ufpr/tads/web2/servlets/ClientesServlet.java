/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.dao.ClienteDAO;
import com.ufpr.tads.web2.facade.CidadesFacade;
import com.ufpr.tads.web2.facade.ClientesFacade;
import com.ufpr.tads.web2.facade.EstadosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Itay
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            LoginBean loginBean = (LoginBean) session.getAttribute("login");
           
            if(loginBean != null) {
                int id;
                Cliente cliente;
                List<Cliente> clientes;
                RequestDispatcher rd;
                String action = request.getParameter("action");                

                if (action != null) {
                    switch (action) {
                        case "show":
                            id = Integer.parseInt(request.getParameter("id"));
                            cliente = ClientesFacade.buscar(id);
                            request.setAttribute("visualizar", cliente);
                            rd = getServletContext().getRequestDispatcher("/clientesVisualizar.jsp");
                            rd.forward(request, response);
                            break;
                        case "formUpdate":
                            id = Integer.parseInt(request.getParameter("id"));
                            cliente = ClientesFacade.buscar(id);
                            request.setAttribute("alterar", cliente);
                            List<Cidade> cidades = CidadesFacade.buscarTodos();
                            request.setAttribute("listacidades", cidades);
                            List<Estado> estados = EstadosFacade.buscarTodos();
                            request.setAttribute("listaestados", estados);
                            rd = getServletContext().getRequestDispatcher("/clientesAlterar.jsp");
                            rd.forward(request, response);
                            break;
                        case "remove":
                            id = Integer.parseInt(request.getParameter("id"));
                            ClientesFacade.excluir(id);
                            //rd = getServletContext().getRequestDispatcher("/ClientesServlet");
                            //rd.forward(request, response);
                            response.sendRedirect(request.getContextPath() + "/ClientesServlet");
                            break;
                        case "update":
                            cliente = new Cliente();
                            id = Integer.parseInt(request.getParameter("id"));
                            cliente.setIdCliente(id);
                            cliente.setCpfCliente(request.getParameter("cpf"));
                            cliente.setNomeCliente(request.getParameter("nome"));
                            cliente.setEmailCliente(request.getParameter("email"));
                            String dataString = request.getParameter("data");

                            try {
                                SimpleDateFormat simnpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date data = simnpleDataFormat.parse(dataString);
                                cliente.setDataCliente(data);
                            }catch (ParseException e) {
                                System.out.println("Erro Parse: " + e);
                            }
                            
                            cliente.setCepCliente(request.getParameter("cep"));
                            cliente.setRuaCliente(request.getParameter("rua"));
                            int numero = Integer.parseInt(request.getParameter("nr"));
                            cliente.setNrCliente(numero);
                            cliente.setCidadeCliente(Integer.parseInt(request.getParameter("cidade")));
                            cliente.setEstadoCliente(Integer.parseInt(request.getParameter("uf")));
                            ClientesFacade.alterar(cliente);
                            response.sendRedirect(request.getContextPath() + "/ClientesServlet");
                            break;
                        case "formNew":
                            List<Cidade> cidades2 = CidadesFacade.buscarTodos();
                            request.setAttribute("listacidades", cidades2);
                            List<Estado> estados2 = EstadosFacade.buscarTodos();
                            request.setAttribute("listaestados", estados2);
                            
                            rd = getServletContext().getRequestDispatcher("/clientesNovo.jsp");
                            rd.forward(request, response);
                            break;
                        case "new":
                            cliente = new Cliente();
                            cliente.setNomeCliente(request.getParameter("nome"));
                            cliente.setCpfCliente(request.getParameter("cpf"));
                            cliente.setEmailCliente(request.getParameter("email"));
                            String dataS = request.getParameter("data");

                            try {
                                SimpleDateFormat simnpleDataFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Date data = simnpleDataFormat.parse(dataS);
                                cliente.setDataCliente(data);
                            }catch (ParseException e) {
                                System.out.println("Erro Parse: " + e);
                            }
                            
                            cliente.setCepCliente(request.getParameter("cep"));
                            cliente.setRuaCliente(request.getParameter("rua"));
                            int nr = Integer.parseInt(request.getParameter("numero"));
                            cliente.setNrCliente(nr);
                            cliente.setCidadeCliente(Integer.parseInt(request.getParameter("cidade")));
                            cliente.setEstadoCliente(Integer.parseInt(request.getParameter("uf")));
                            ClientesFacade.inserir(cliente);
                            response.sendRedirect(request.getContextPath() + "/ClientesServlet");
                            break;
                        case "formCliente":
                            id = Integer.parseInt(request.getParameter("id"));
                            cliente = ClientesFacade.buscar(id);
                            request.setAttribute("alterar", cliente);
                            List<Cidade> cidades3 = CidadesFacade.buscarTodos();
                            request.setAttribute("listacidades", cidades3);
                            List<Estado> estados3 = EstadosFacade.buscarTodos();
                            request.setAttribute("listaestados", estados3);
                            rd = getServletContext().getRequestDispatcher("/clientesForm.jsp");
                            rd.forward(request, response);
                            break;
                        default:
                            clientes = ClientesFacade.buscarTodos();
                            request.setAttribute("listar", clientes);
                            rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");
                            rd.forward(request, response);
                    }
                } else {
                    clientes = ClientesFacade.buscarTodos();
                    request.setAttribute("listar", clientes);
                    rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");
                    rd.forward(request, response);
                }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
