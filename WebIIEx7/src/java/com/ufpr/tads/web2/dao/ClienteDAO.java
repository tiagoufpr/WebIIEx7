/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Itay
 */
public class ClienteDAO {

    private Connection con;

    public ClienteDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();

    }

    public List<Cliente> selectClientes() throws SQLException {
        
        List<Cliente> resultados = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_cliente";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setCpfCliente(rs.getString("cpf_cliente"));
            cliente.setNomeCliente(rs.getString("nome_cliente"));
            cliente.setEmailCliente(rs.getString("email_cliente"));
            cliente.setDataCliente(rs.getDate("data_cliente"));
            cliente.setRuaCliente(rs.getString("rua_cliente"));
            cliente.setNrCliente(rs.getInt("nr_cliente"));
            cliente.setCepCliente(rs.getString("cep_cliente"));
            cliente.setCidadeCliente(rs.getInt("id_cidade"));
            cliente.setEstadoCliente(rs.getInt("id_estado"));
            
            resultados.add(cliente);
        }
        
        return resultados;
    }

    public Cliente selectClienteEspecifico(int id) throws SQLException {

        String sql = "SELECT * FROM tb_cliente WHERE id_cliente = (?) LIMIT 1;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        Cliente cliente = new Cliente();

        while (rs.next()) {
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setCpfCliente(rs.getString("cpf_cliente"));
            cliente.setNomeCliente(rs.getString("nome_cliente"));
            cliente.setEmailCliente(rs.getString("email_cliente"));
            cliente.setDataCliente(rs.getDate("data_cliente"));
            cliente.setRuaCliente(rs.getString("rua_cliente"));
            cliente.setNrCliente(rs.getInt("nr_cliente"));
            cliente.setCepCliente(rs.getString("cep_cliente"));
            cliente.setCidadeCliente(rs.getInt("id_cidade"));
            cliente.setEstadoCliente(rs.getInt("id_estado"));
            return cliente;
        }
        return null;
    }
    
    public void removeCliente(int id) throws SQLException {
        try{
            String sql = "DELETE FROM tb_cliente WHERE id_cliente = (?) LIMIT 1;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void alterarCliente(String cpf, String nome, String email, java.util.Date data, String rua, int numero, String cep, int cidade, int uf, int id) throws SQLException {
        try{
            String sql = "UPDATE tb_cliente SET cpf_cliente = ? , nome_cliente = ?, " +
                        "email_cliente = ?, data_cliente = ?, rua_cliente = ?, nr_cliente = ?, " + 
                        "cep_cliente = ?, id_cidade = ?, id_estado = ?" + 
                        " WHERE id_cliente = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, cpf);
            st.setString(2, nome);
            st.setString(3, email);
            st.setDate(4, new java.sql.Date(data.getTime()));
            st.setString(5, rua);
            st.setInt(6, numero);
            st.setString(7, cep);
            st.setInt(8, cidade);
            st.setInt(9, uf);
            st.setInt(10, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertCliente(String cpf, String nome, String email, java.util.Date data, String rua, int numero, String cep, int cidade, int uf) throws SQLException {
        
        String sql = "INSERT INTO tb_cliente (cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente," +
                    " nr_cliente, cep_cliente, id_cidade, id_estado)" + 
                    " VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?))";
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1, cpf);
        st.setString(2, nome);
        st.setString(3, email);
        st.setDate(4, new java.sql.Date(data.getTime()));
        st.setString(5, rua);
        st.setInt(6, numero);
        st.setString(7, cep);
        st.setInt(8, cidade);
        st.setInt(9, uf);
        
        st.executeUpdate();
    }
}
