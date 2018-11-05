<%-- 
    Document   : atendimentosAlterar
    Created on : 30/10/2018, 00:17:20
    Author     : Itay
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="com.ufpr.tads.web2.beans.Atendimento"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="login" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>

        <c:if test="${empty sessionScope.login}">
            <jsp:forward page="/index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
        
        <h1>Dados do atendimento</h1>
        
        <jsp:useBean id="alterar" class="com.ufpr.tads.web2.beans.Atendimento" scope="application"/>
        
        <form action="AtendimentoServlet?action=update" method="POST">
            ID atendimento: <input type="number" name="id" value= <jsp:getProperty name="alterar" property="idAtendimento"/> required> <br/>
            Data e hora: <input type="date" name="dataHora" value= <jsp:getProperty name="alterar" property="dtHrAtendimento" /> required><br/>
            Descrição: <input type="text" name="descricao" value=<jsp:getProperty name="alterar" property="dscAtendimento"/>
                              required maxlength="250"><br/>
            ID produto: <input type="number" name="produto" value= <jsp:getProperty name="alterar" property="idProduto"/>required><br/>
            ID tipo atendimento: <input type="number" name="tipoAtendimento" value= <jsp:getProperty name="alterar" property="idTipoAtendimento"/> required><br/>
            ID usuario: <input type="number" name="usuario" value= <jsp:getProperty name="alterar" property="idUsuario"/> required><br/>
            ID cliente: <input type="number" name="cliente" value= <jsp:getProperty name="alterar" property="idCliente"/> required><br/>
            Resolvido:
            <select name="resolvido" required>
                <option value="">Selecione</option>
                    <option value="s">sim</option>
                    <option value="n">não</option>
            </select>

            <input type="submit" value="Alterar"> <input type="submit" value="Cancelar" formaction="AtendimentoServlet">
        </form>
    </body>
</html>