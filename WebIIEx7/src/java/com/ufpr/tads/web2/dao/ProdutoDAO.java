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

    public Produto selectProdutoEspecifico(int id) throws SQLException {
        Produto resultado = new Produto();
        
        String sql = "SELECT * FROM tb_produto WHERE id_produto = (?) LIMIT 1;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            resultado.setIdProduto(rs.getInt("id_produto"));
            resultado.setNomeProduto(rs.getString("nome_produto"));            
            
            return resultado;
        }
        return null;
    }

    public void removeProdutoEspecifico(int id) throws SQLException {        
        try{
            String sql = "DELETE FROM tb_produto WHERE id_produto = (?) LIMIT 1;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void atualizaProduto(Produto p) throws SQLException {        
        try {
            String sql = "UPDATE tb_produto SET nome_produto = ? WHERE id_produto = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, p.getNomeProduto());
            st.setInt(2, p.getIdProduto());

            st.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void criarProduto(Produto p) throws SQLException {        
        try {
            String sql = "INSERT INTO tb_produto (nome_produto)" + 
                        " VALUES ((?))";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, p.getNomeProduto());

            st.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
