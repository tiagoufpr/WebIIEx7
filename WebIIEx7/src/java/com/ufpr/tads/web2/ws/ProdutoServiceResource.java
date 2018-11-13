/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.ws;

import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Itay
 */
@Path("ProdutoService")
public class ProdutoServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoServiceResource
     */
    public ProdutoServiceResource() {
    }

    @GET
    @Path("/buscarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProdutos() throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        
        List<Produto> produtos = dao.selectProdutos();

        GenericEntity<List<Produto>> lista = new GenericEntity<List<Produto>>(produtos) {};
        
        return Response.ok().entity(lista).build();
    }

    
    @GET
    @Path("/buscarEspecifico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduto(@PathParam("id") int numero) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        
        Produto produto = dao.selectProdutoEspecifico(numero);
        
        return Response.ok(produto).build();
    }


    @DELETE
    @Path("/removerProdutoEspecifico/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removProduto(@PathParam("id") int numero) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.removeProdutoEspecifico(numero);
    }

    @PUT
    @Path("/atualizarProduto/{produto}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putProduto(@PathParam("produto") Produto p) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.atualizaProduto(p);
    }

    @POST
    @Path("/criarProduto/{produto}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postProduto(@PathParam("produto") Produto p) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.criarProduto(p);
    }

}
