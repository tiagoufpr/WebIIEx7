<%-- 
    Document   : atendimentosForm
    Created on : 30/10/2018, 00:56:33
    Author     : Itay
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="com.ufpr.tads.web2.beans.Atendimento"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    </head>
    <body>
        <jsp:useBean id="login" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>

        <c:if test="${empty sessionScope.login}">
            <jsp:forward page="/index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
          
        <c:if test="${alterar2 != null}">
            <h1>Alterar Dados do atendimento</h1>

            <form action="AtendimentosServlet?action=update" method="POST">                
                Data e hora: <input type="date" name="dataHora" value=${alterar2.dtHrAtendimento} required>  <br/>
                Descrição: <input type="text" name="descricao" value=${alterar2.dscAtendimento} required maxlength="250"> <br/>
                ID produto: <input type="number" name="produto" value=${alterar2.idProduto} required> <br/>
                ID tipo atendimento: <input type="number" name="tipoAtendimento" value=${alterar2.idTipoAtendimento} required> <br/>
                ID usuario: <input type="number" name="usuario" value=${alterar2.idUsuario} required> <br/>
                ID cliente: <input type="number" name="cliente" value=${alterar2.idCliente} required> <br/>
                Resolvido:
                <select name="resolvido" required>
                    <option value="">Selecione</option>
                        <option value="s">sim</option>
                        <option value="n">não</option>
                </select>

                </br></br>

                <input type="submit" value="Alterar"> <input type="submit" value="Cancelar" formaction="AtendimentoServlet">
            </form>
        </c:if>
            
            
        <c:if test="${alterar2 == null}">

            <h1>Novo do atendimento</h1>

            <form action="AtendimentoServlet?action=new" method="POST">
                Data e hora: <input type="date" name="dataHora" required>  <br/>
                Descrição: <input type="text" name="descricao" required> <br/>
                ID produto: <input type="number" name="produto" required> <br/>
                ID tipo atendimento: <input type="number" name="tipoAtendimento" required> <br/>
                ID usuario: <input type="number" name="usuario" required> <br/>
                ID cliente: <input type="number" name="cliente" required> <br/>
                Resolvido: <input type="text" name="resolvido" required> <br/>
                <br/><br/>

                <input type="submit" value="Salvar"> <input type="submit" value="Cancelar" formaction="AtendimentoServlet">
            </form>
        </c:if>
    </body>
</html>