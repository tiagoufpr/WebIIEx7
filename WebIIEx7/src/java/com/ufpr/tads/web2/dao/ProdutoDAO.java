/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Itay
 */
public class ProdutoDAO {
    private Connection con;

    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();
    }

    public List<Produto> selectProdutos() throws SQLException {
        List<Produto> resultados = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_produto";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            Produto produto = new Produto();

            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setNomeProduto(rs.getString("nome_produto"));
                 
            resultados.add(produto);
        }
        
        return resultados;
    }
}
