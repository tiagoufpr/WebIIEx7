/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.facade.AtendimentoFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
       
        try  {
            HttpSession session = request.getSession();
            LoginBean loginBean = (LoginBean) session.getAttribute("login");
           
            if(loginBean != null) {
                int id;
                Atendimento atendimento;
                List<Atendimento> atendimentos;
                RequestDispatcher rd;
                String action = request.getParameter("action");                

                if (action != null) {
                    switch (action) {
                        case "atender":
                            rd = getServletContext().getRequestDispatcher("/atendimento.jsp");
                            rd.forward(request, response);
                            break;
                        case "show":
                            id = Integer.parseInt(request.getParameter("id"));
                            atendimento = AtendimentoFacade.buscar(id);
                            request.setAttribute("visualizar", atendimento);
                            rd = getServletContext().getRequestDispatcher("/atendimentoDetalhes.jsp");
                            rd.forward(request, response);
                            break;
                        case "formUpdate":
                            id = Integer.parseInt(request.getParameter("id"));
                            atendimento = AtendimentoFacade.buscar(id);
                            request.setAttribute("alterar", atendimento);
                            rd = getServletContext().getRequestDispatcher("/atendimentosAlterar.jsp");
                            rd.forward(request, response);
                            break;
                        case "remove":
                            id = Integer.parseInt(request.getParameter("id"));
                            AtendimentoFacade.excluir(id);
                            response.sendRedirect(request.getContextPath() + "/AtendimentoServlet");
                            break;
                        case "update":
                            atendimento = new Atendimento();
                            id = Integer.parseInt(request.getParameter("id"));
                            atendimento.setIdAtendimento(id);
                            atendimento.setDscAtendimento(request.getParameter("descricao"));
                            atendimento.setIdProduto(Integer.parseInt(request.getParameter("produto")));
                            atendimento.setIdTipoAtendimento(Integer.parseInt(request.getParameter("tipoAtendimento")));

                            String dataHoraString = request.getParameter("dataHora");
                            try {
                                SimpleDateFormat simnpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Date dataHora = simnpleDataFormat.parse(dataHoraString);
                                atendimento.setDtHrAtendimento(dataHora);
                            }catch (ParseException e) {
                                System.out.println("Erro Parse: " + e);
                            }
                            
                            atendimento.setIdUsuario(Integer.parseInt(request.getParameter("usuario")));
                            atendimento.setIdCliente(Integer.parseInt(request.getParameter("cliente")));
                            atendimento.setResAtendimento(request.getParameter("resolvido"));

                            AtendimentoFacade.alterar(atendimento);
                            response.sendRedirect(request.getContextPath() + "/AtendimentoServlet");
                            break;
                        case "formNew":                            
                            rd = getServletContext().getRequestDispatcher("/atendimentosNovo.jsp");
                            rd.forward(request, response);
                            break;
                        case "new":
                            atendimento = new Atendimento();
                            atendimento.setDscAtendimento(request.getParameter("descricao"));
                            atendimento.setIdProduto(Integer.parseInt(request.getParameter("produto")));
                            atendimento.setIdTipoAtendimento(Integer.parseInt(request.getParameter("tipoAtendimento")));

                            String dataHoraStrg = request.getParameter("dataHora");
                            try {
                                SimpleDateFormat simnpleDataFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Date dataHora = simnpleDataFormat.parse(dataHoraStrg);
                                atendimento.setDtHrAtendimento(dataHora);
                            }catch (ParseException e) {
                                System.out.println("Erro Parse: " + e);
                            }
                            
                            atendimento.setIdUsuario(Integer.parseInt(request.getParameter("usuario")));
                            atendimento.setIdCliente(Integer.parseInt(request.getParameter("cliente")));
                            atendimento.setResAtendimento(request.getParameter("resolvido"));
                            
                            AtendimentoFacade.inserir(atendimento);
                            response.sendRedirect(request.getContextPath() + "/AtendimentoServlet");
                            break;
                        case "formAtendimento":
                            id = Integer.parseInt(request.getParameter("id"));
                            try {
                                atendimento = AtendimentoFacade.buscar(id);
                                request.setAttribute("alterar2", atendimento);
                                rd = getServletContext().getRequestDispatcher("/atendimentosForm.jsp");
                                rd.forward(request, response);
                                break;
                            } catch (IOException | ClassNotFoundException | SQLException | ServletException e){
                                System.out.println("Erro: " + e);
                            }

                        default:
                            atendimentos = AtendimentoFacade.buscarTodos();
                            request.setAttribute("listar", atendimentos);
                            rd = getServletContext().getRequestDispatcher("/atendimentosListar.jsp");
                            rd.forward(request, response);
                    }
                } else {
                    atendimentos = AtendimentoFacade.buscarTodos();
                    request.setAttribute("listar", atendimentos);
                    rd = getServletContext().getRequestDispatcher("/atendimentosListar.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
