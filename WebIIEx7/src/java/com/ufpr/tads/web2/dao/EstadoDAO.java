/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Estado;
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
public class EstadoDAO {

    private Connection con;

    public EstadoDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();

    }

    public List<Estado> selectEstados() throws SQLException {
        
        List<Estado> resultados = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_estado";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            Estado estado = new Estado();
            estado.setId_estado(rs.getInt("id_estado"));
            estado.setNome_estado(rs.getString("nome_estado"));
           
            resultados.add(estado);
        }
        
        return resultados;
    }

    public Estado selectEstadoEspecifico(int id) throws SQLException {

        String sql = "SELECT * FROM tb_estado WHERE id_estado = (?) LIMIT 1;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        Estado estado = new Estado();

        while (rs.next()) {
            estado.setId_estado(rs.getInt("id_estado"));
            estado.setNome_estado(rs.getString("nome_estado"));
        }
        return null;
    }
    
    public void removeEstado(int id) throws SQLException {
        try{
            String sql = "DELETE FROM tb_estado WHERE id_estado = (?) LIMIT 1;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void alterarEstado(String nome, int id) throws SQLException {
        try{
            String sql = "UPDATE tb_estado SET nome_estado = ? " +
                        " WHERE id_cliente = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setInt(2, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertEstado(String nome) throws SQLException {
        
        String sql = "INSERT INTO tb_estado (nome_estado)" + 
                    " VALUES ((?))";
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1, nome);
              
        st.executeUpdate();
    }

}
