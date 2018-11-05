<%-- 
    Document   : atendimentosVisualizar
    Created on : 30/10/2018, 00:06:52
    Author     : Itay
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="com.ufpr.tads.web2.beans.Atendimento"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            td, th{
                border: 1px solid black;
                padding-right: 10px;
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
            
        <jsp:useBean id="visualizar" class="com.ufpr.tads.web2.beans.Atendimento" scope="request"/>
        <table>
            <tr>
                <th>ID </th>
                <th>Data e hora</th>
                <th>Descrição</th>
                <th>ID produto</th>
                <th>ID tipo atendimento</th>
                <th>ID usuario</th>
                <th>ID cliente</th>
                <th>Resolvido</th>
            </tr>
            <tr>
                <td> <jsp:getProperty name="visualizar" property="idAtendimento"/> </td>  
                <td> <jsp:getProperty name="visualizar" property="dtHrAtendimento"/> </td>
                <td> <jsp:getProperty name="visualizar" property="dscAtendimento"/> </td>
                <td> <jsp:getProperty name="visualizar" property="idProduto"/> </td>
                <td> <jsp:getProperty name="visualizar" property="idTipoAtendimento"/> </td>
                <td> <jsp:getProperty name="visualizar" property="idUsuario"/> </td>
                <td> <jsp:getProperty name="visualizar" property="idCliente"/> </td>
                <td> <jsp:getProperty name="visualizar" property="resAtendimento"/> </td>
            </tr>
        </table>
        <br>
        <a href="AtendimentoServlet">Voltar</a>
    </body>
</html>