/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class CidadeDAO {

    private Connection con;

    public CidadeDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();

    }

    public List<Cidade> selectCidade() throws SQLException {
        
        List<Cidade> resultados = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_cidade";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            Cidade estado = new Cidade();
            estado.setId_cidade(rs.getInt("id_cidade"));
            estado.setNome_cidade(rs.getString("nome_cidade"));
           
            resultados.add(estado);
        }
        
        return resultados;
    }

    public Cidade selectCidadeEspecifica(int id) throws SQLException {

        String sql = "SELECT * FROM tb_cidade WHERE id_cidade = (?) LIMIT 1;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        Cidade cidade = new Cidade();

        while (rs.next()) {
            cidade.setId_cidade(rs.getInt("id_cidade"));
            cidade.setNome_cidade(rs.getString("nome_cidade"));
        }
        return null;
    }
    
    public void removeCidade(int id) throws SQLException {
        try{
            String sql = "DELETE FROM tb_cidade WHERE id_estado = (?) LIMIT 1;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void alterarCidade(String nome, int id) throws SQLException {
        try{
            String sql = "UPDATE tb_cidade SET nome_cidade = ? " +
                        " WHERE id_cidade = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setInt(2, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertCidade(String nome) throws SQLException {
        
        String sql = "INSERT INTO tb_cidade (nome_cidade)" + 
                    " VALUES ((?))";
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1, nome);
              
        st.executeUpdate();
    }

}
