<%-- 
    Document   : clientesVisualizar
    Created on : 17/09/2018, 22:01:51
    Author     : Itay
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
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
            <jsp:useBean id="visualizar" class="com.ufpr.tads.web2.beans.Cliente" scope="request"/>

            <table>
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Data</th>
                    <th>Rua</th>
                    <th>Numero</th>
                    <th>CEP</th>
                    <th>Cidade</th>
                    <th>UF</th>
                </tr>
                <tr>
                    <td> <jsp:getProperty name="visualizar" property="nomeCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="cpfCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="emailCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="dataCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="ruaCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="nrCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="cepCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="cidadeCliente"/> </td>
                    <td> <jsp:getProperty name="visualizar" property="estadoCliente"/> </td>
                </tr>
            </table>
            <br>
            <a href="ClientesServlet">Voltar</a>
    </body>
</html>