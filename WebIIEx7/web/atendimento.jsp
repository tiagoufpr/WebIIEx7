<%-- 
    Document   : atendimento
    Created on : 04/11/2018, 21:01:51
    Author     : Itay
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="com.ufpr.tads.web2.beans.Atendimento"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td, th{
                border: 1px solid black;
            }            
        </style>
    </head>
    <body>
        <jsp:useBean id="login" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>

        <c:if test="${empty sessionScope.login}">
            <jsp:forward page="/index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
     
        <p id="demo"></p>
        
        <nav class="w3-sidebar w3-black w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
          <div class="w3-container">
            <h3 class="w3-padding-64"><b>Menu</b></h3>
          </div>
          <div class="w3-bar-block">
            <a href="ClientesServlet" class="w3-bar-item w3-button w3-hover-white">Cadastro de Clientes</a>
            <a href="AtendimentoServlet" class="w3-bar-item w3-button w3-hover-white">Cadastro de novos atendimentos</a>
            <a href="LogoutServlet" class="w3-bar-item w3-button w3-hover-white">Sair</a>
          </div>
        </nav>

        <div class="w3-right" style="padding-right: 250px;">
            <p>
                <c:out value="${login.nomeUsuario}"/>
            </p>
            <br/>
            <div>
                <table>
                    <tr>
                        <th>Id Produto</th>
                        <th>Produto</th>
                    </tr>

                    <jsp:useBean id="produtoDao" class="com.ufpr.tads.web2.dao.ProdutoDAO" scope="page"/>
                    <c:forEach items="${produtoDao.selectProdutos()}" var="produto">
                        <tr>
                            <td> ${produto.idProduto} </td> 
                            <td> ${produto.nomeProduto} </td> 
                        </tr>
                    </c:forEach>
                </table>
                <br/>
                <table>
                    <tr>
                        <th>Id Produto</th>
                        <th>Produto</th>
                    </tr>

                    <jsp:useBean id="tipoAtendimentoDao" class="com.ufpr.tads.web2.dao.TipoAtendimentoDAO" scope="page"/>
                    <c:forEach items="${tipoAtendimentoDao.selectTipoAtendimento()}" var="tipoAtendimento">
                        <tr>
                            <td> ${tipoAtendimento.idTipoAtendimento} </td> 
                            <td> ${tipoAtendimento.nomeTipoAtendimento} </td> 
                        </tr>
                    </c:forEach>
                </table>
            </div>
            
             <div>
                <table>
                    
                    <!--AQUI ENTRA A TABELA DOS ATENDIMENTOS POR CLIENTE -->
                    
                </table>                 
             </div>
            
            <div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px">
                <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
              <footer class="w3-right">
                  Em caso de problemas contactar o administrador: <jsp:getProperty name="configuracao" property="email" />
              </footer>
            </div>
        </div>
    </body>
</html>