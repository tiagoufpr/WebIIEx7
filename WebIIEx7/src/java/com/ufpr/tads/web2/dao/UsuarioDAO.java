package com.ufpr.tads.web2.dao;


import Connection.ConnectionFactory;
import com.ufpr.tads.web2.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiago
 */
public class UsuarioDAO {
    
    public ArrayList<Usuario> selecionar(){
        String sql = "select * from tb_usuario";
        ArrayList<Usuario> usuarios = new ArrayList();
        Usuario usuario;

        try{
            Connection conn = new ConnectionFactory().getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("id_usuario"), rs.getString("login_usuario"), rs.getString("senha_usuario"), rs.getString("nome_usuario"));
                usuarios.add(usuario);
            }     
   
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public void inserir(Usuario usuario){
        String sql = "insert into tb_usuario (login_usuario,senha_usuario, nome_usuario) values (?,?,?)";
        
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt;
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getLoginUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());
            stmt.setString(3, usuario.getNomeUsuario());
            stmt.execute();  

            conn.close();

        } catch (SQLException e) {
            System.out.println("falha na conexão");
            e.printStackTrace();
        }
        return;
    }
}

