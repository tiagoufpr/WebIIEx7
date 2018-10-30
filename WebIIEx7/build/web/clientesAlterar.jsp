<%-- 
    Document   : clientesAlterar
    Created on : 17/09/2018, 20:24:41
    Author     : Itay
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
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
        
        <h1>Dados do cliente</h1>
        
        <jsp:useBean id="alterar" class="com.ufpr.tads.web2.beans.Cliente" scope="application"/>
        <form action="ClientesServlet?action=update" method="POST">
            Nome: <input type="text" name="nome" value=<jsp:getProperty name="alterar" property="nomeCliente"/> > <br/>
            Id: <input type="text" name="id" value=<jsp:getProperty name="alterar" property="idCliente"/> ><br/>
            CPF: <input type="text" name="cpf" value= <jsp:getProperty name="alterar" property="cpfCliente"/> ><br/>
            Email: <input type="text" name="email" value= <jsp:getProperty name="alterar" property="emailCliente"/>><br/>
            Data: <input type="date" name="data" value= <jsp:getProperty name="alterar" property="dataCliente"/> ><br/>
            Rua: <input type="text" name="rua" value= <jsp:getProperty name="alterar" property="ruaCliente"/> ><br/>
            Número: <input type="text" name="numero" value= <jsp:getProperty name="alterar" property="nrCliente"/> ><br/>
            CEP: <input type="text" name="cep" value= <jsp:getProperty name="alterar" property="cepCliente"/> ><br/>
            
            Cidade:
            <select name="cidade" <jsp:getProperty name="alterar" property="cidadeCliente"/>>
                <option value="0">Selecione</option>
                    <c:forEach items="${listacidades}" var="cidade">  
                        <option value="${cidade.idCidade}">${cidade.nomeCidade}</option>
                    </c:forEach>
            </select>
      
            <br/>
  
            Estado:
            <select name="estado" <jsp:getProperty name="alterar" property="estadoCliente"/>>
                <option value="0">Selecione</option>
                    <c:forEach items="${listaestados}" var="estado">  
                        <option value="${estado.idEstado}">${estado.nomeEstado}</option>
                    </c:forEach>
            </select>
   
           <br/><br/>
            
            <input type="submit" value="Alterar"> <input type="submit" value="Cancelar" formaction="ClientesServlet">
        </form>
    </body>
</html>
