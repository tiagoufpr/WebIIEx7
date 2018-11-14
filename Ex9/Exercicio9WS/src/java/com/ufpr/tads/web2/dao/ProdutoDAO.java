/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import com.ufpr.tads.web2.bean.Produto;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import static org.apache.coyote.http11.Constants.a;

/**
 *
 * @author Itay
 */
public class ProdutoDAO {
    private Connection con;

    public ProdutoDAO() throws SQLException, ClassNotFoundException {
    }

    public List<Produto> selectProdutos() throws SQLException {
        List<Produto> resultados = new ArrayList<>();
        
        Client client = ClientBuilder.newClient();
        String uriWS = "http://localhost:8080/WEBIIEx7/webresources";
        
        Response resp = client.target(uriWS)
            .path("ProdutoService/buscarTodos")
            .request(MediaType.APPLICATION_JSON)
            .get();

        resultados = resp.readEntity(new GenericType<List<Produto>>(){});
        
        return resultados;
    }
    
    public void insertProduto() {
        
    }
        
    public void alterarProduto() {
        
    }
    
    public Produto selectProdutoEspecifico(int id) {
        Client client = ClientBuilder.newClient();
        String uriWS = "http://localhost:8080/WEBIIEx7/webresources";
        Response resp = client.target(uriWS)
            .path("ProdutoService/buscarEspecifico")
            .request(MediaType.APPLICATION_JSON)
            .get();
        
        Produto produto = resp.readEntity(Produto.class);
       
       return produto;
    }
    
    public void removeProduto(int id) {
        Client client = ClientBuilder.newClient();
        String uriWS = "http://localhost:8080/WEBIIEx7/webresources";
        client.target(uriWS)
            .path("ProdutoService/removerProdutoEspecifico")
            .request(MediaType.APPLICATION_JSON)
            .delete();        
   }
    
    public void alterarProduto(int id, String nome) {
        Produto produto = new Produto();
        produto.setIdProduto(id);
        produto.setNomeProduto(nome);
                
        Client client = ClientBuilder.newClient();
        String uriWS = "http://localhost:8080/WEBIIEx7/webresources";
        client.target(uriWS)
            .path("ProdutoService/atualizarProduto")
            .request(MediaType.APPLICATION_JSON)
            .put(Entity.json(produto), Produto.class);
   }

    public void insertProduto(Produto p) {
        Produto produto = new Produto();
        produto.setNomeProduto(p.getNomeProduto());

        Client client = ClientBuilder.newClient();
        String uriWS = "http://localhost:8080/WEBIIEx7/webresources";
        client.target(uriWS)
                .path("ProdutoService/criarProduto")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(produto), Produto.class);
    }
    
}
