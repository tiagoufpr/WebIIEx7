/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Itay
 */
public class AtendimentoDAO {
    
    private Connection con;

    public AtendimentoDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();
    }

    public List<Atendimento> selectAtendimentos() throws SQLException {
        List<Atendimento> resultados = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_atendimento";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            Atendimento atendimento = new Atendimento();

            atendimento.setIdAtendimento(rs.getInt("id_atendimento"));
            atendimento.setDtHrAtendimento(rs.getDate("dt_hr_atendimento"));
            atendimento.setDscAtendimento(rs.getString("dsc_atendimento"));
            atendimento.setIdProduto(rs.getInt("id_produto"));
            atendimento.setIdTipoAtendimento(rs.getInt("id_tipo_atendimento"));
            atendimento.setIdUsuario(rs.getInt("id_usuario"));
            atendimento.setIdCliente(rs.getInt("id_cliente"));
            atendimento.setResAtendimento(rs.getString("res_atendimento"));
                 
            resultados.add(atendimento);
        }
        
        return resultados;
    }

    public Atendimento selectAtendimentoEspecifico(int id) throws SQLException {

        String sql = " SELECT * FROM tb_atendimento WHERE id_atendimento = (?) LIMIT 1; ";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        Atendimento atendimento = new Atendimento();

        while (rs.next()) {
            atendimento.setIdAtendimento(rs.getInt("id_atendimento"));
            atendimento.setDtHrAtendimento(rs.getDate("dt_hr_atendimento"));
            atendimento.setDscAtendimento(rs.getString("dsc_atendimento"));
            atendimento.setIdProduto(rs.getInt("id_produto"));
            atendimento.setIdTipoAtendimento(rs.getInt("id_tipo_atendimento"));
            atendimento.setIdUsuario(rs.getInt("id_usuario"));
            atendimento.setIdCliente(rs.getInt("id_cliente"));
            atendimento.setResAtendimento(rs.getString("res_atendimento"));
            
            return atendimento;
        }
        return null;
    }
    
    public void removeAtendimento(int id) throws SQLException {
        try{
            String sql = "DELETE FROM tb_atendimento WHERE id_atendimento = (?) LIMIT 1;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void alterarAtendimento(java.util.Date dataHora, String descricao, int produto, int tipoAtendimento, int usuario, int cliente, String resolvido, int id) throws SQLException {
        try{
            String sql = "UPDATE tb_atendimento SET dt_hr_atendimento = ? , dsc_atendimento = ?, " +
                        "id_produto = ?, id_tipo_atendimento = ?, id_usuario = ?, id_cliente = ?, " + 
                        "res_atendimento = ? WHERE id_atendimento = ?";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setDate(1, new java.sql.Date(dataHora.getTime()));
            st.setString(2, descricao);
            st.setInt(3, produto);
            st.setInt(4, tipoAtendimento);
            st.setInt(5, usuario);
            st.setInt(6, cliente);
            st.setString(7, resolvido);
            st.setInt(8, id);


            st.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertAtendimento(java.util.Date dataHora, String descricao, int produto, int tipoAtendimento, int usuario, int cliente, String resolvido) throws SQLException {
        
        String sql = "INSERT INTO tb_atendimento (dt_hr_atendimento, dsc_atendimento, id_produto, " + 
                    "id_tipo_atendimento, id_usuario, id_cliente, res_atendimento)" + 
                    " VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?))";
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setDate(1, new java.sql.Date(dataHora.getTime()));
        st.setString(2, descricao);
        st.setInt(3, produto);
        st.setInt(4, tipoAtendimento);
        st.setInt(5, usuario);
        st.setInt(6, cliente);
        st.setString(7, resolvido);
        
        st.executeUpdate();
    }
}
