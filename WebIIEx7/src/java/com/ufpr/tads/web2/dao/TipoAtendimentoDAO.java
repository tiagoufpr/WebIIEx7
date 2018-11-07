/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.beans.TipoAtendimento;
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
public class TipoAtendimentoDAO {
    private Connection con;

    public TipoAtendimentoDAO() throws SQLException, ClassNotFoundException {
        this.con = ConnectionFactory.getConnection();
    }

    public List<TipoAtendimento> selectTipoAtendimento() throws SQLException {
        List<TipoAtendimento> resultados = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_tipo_atendimento";
        PreparedStatement st = con.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
            TipoAtendimento tipoAtendimento = new TipoAtendimento();

            tipoAtendimento.setIdTipoAtendimento(rs.getInt("id_tipo_atendimento"));
            tipoAtendimento.setNomeTipoAtendimento(rs.getString("nome_tipo_atendimento"));
                 
            resultados.add(tipoAtendimento);
        }
        
        return resultados;
    }    
}
