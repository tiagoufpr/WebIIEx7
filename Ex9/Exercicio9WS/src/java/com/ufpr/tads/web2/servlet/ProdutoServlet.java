/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlet;

import com.ufpr.tads.web2.bean.Produto;
import com.ufpr.tads.web2.facade.ProdutoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
        try {
            int id;
            Produto produto;
            List<Produto> produtos;
            RequestDispatcher rd;
            String action = request.getParameter("action");

            if (action != null) {
                switch (action) {
                    case "atender":
//                        rd = getServletContext().getRequestDispatcher("/atendimento.jsp");
//                        rd.forward(request, response);
                        break;
                    case "show":
                        id = Integer.parseInt(request.getParameter("id"));
                        produto = ProdutoFacade.buscar(id);
                        request.setAttribute("visualizar", produto);
                        rd = getServletContext().getRequestDispatcher("/produtoDetalhes.jsp");
                        rd.forward(request, response);
                        break;
                    case "formUpdate":
                        id = Integer.parseInt(request.getParameter("id"));
                        produto = ProdutoFacade.buscar(id);
                        request.setAttribute("alterar", produto);
                        rd = getServletContext().getRequestDispatcher("/produtosAlterar.jsp");
                        rd.forward(request, response);
                        break;
                    case "remove":
                        id = Integer.parseInt(request.getParameter("id"));
                        ProdutoFacade.excluir(id);
                        response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
                        break;
                    case "update":
                        produto = new Produto();
                        id = Integer.parseInt(request.getParameter("id"));
                        produto.setIdProduto(id);
                        produto.setNomeProduto(request.getParameter("nome"));

                        ProdutoFacade.alterar(produto);
                        response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
                        break;
                    case "formNew":
                        rd = getServletContext().getRequestDispatcher("/produtosNovo.jsp");
                        rd.forward(request, response);
                        break;
                    case "new":
                        produto = new Produto();
                        produto.setIdProduto(Integer.parseInt(request.getParameter("id")));
                        produto.setNomeProduto(request.getParameter("nome"));

                        ProdutoFacade.inserir(produto);
                        response.sendRedirect(request.getContextPath() + "/ProdutoServlet");
                        break;
                    case "formAtendimento":
                        id = Integer.parseInt(request.getParameter("id"));
                        try {
                            produto = ProdutoFacade.buscar(id);
                            request.setAttribute("alterar2", produto);
                            rd = getServletContext().getRequestDispatcher("/produtosForm.jsp");
                            rd.forward(request, response);
                            break;
                        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
                            System.out.println("Erro: " + e);
                        }

                    default:
                        produtos = ProdutoFacade.buscarTodos();
                        request.setAttribute("listar", produtos);
                        rd = getServletContext().getRequestDispatcher("/produtosListar.jsp");
                        rd.forward(request, response);
                }
            } else {
                produtos = ProdutoFacade.buscarTodos();
                request.setAttribute("listar", produtos);
                rd = getServletContext().getRequestDispatcher("/produtosListar.jsp");
                rd.forward(request, response);
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
