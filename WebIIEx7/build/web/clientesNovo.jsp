<%-- 
    Document   : clientesNovo
    Created on : 17/09/2018, 23:35:57
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
        
        <form action="ClientesServlet?action=new" method="POST">
            Nome: <input type="text" name="nome" required maxlength="100"> <br/>
            CPF: <input type="text" name="cpf" required maxlength="11" minlength="11" pattern="[0-9]{11}" title="only numbers"><br/>
            Email: <input type="text" name="email" required maxlength="100"
                        pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="xxx@xxx.xxx"><br/>
            Data: <input type="date" name="data" required><br/>
            Rua: <input type="text" name="rua" required maxlength="100"><br/>
            Número: <input type="number" name="numero" required><br/>
            CEP: <input type="text" name="cep" required maxlength="8" pattern="[0-9]{8}" title="only numbers"><br/>
      
            
            Cidade:
            <select name="cidade" required>
                <option value="">Selecione</option>
                    <c:forEach items="${listacidades}" var="cidade">  
                        <option value="${cidade.idCidade}">${cidade.nomeCidade}</option>
                    </c:forEach>
            </select>
      
            <br/>
  
            Estado:
            <select name="estado" required>
                <option value="">Selecione</option>
                    <c:forEach items="${listaestados}" var="estado">  
                        <option value="${estado.idEstado}">${estado.nomeEstado}</option>
                    </c:forEach>
            </select>
               
            <br/><br/>
            
            <input type="submit" value="Salvar"> <input type="submit" value="Cancelar" formaction="ClientesServlet">
        </form>
        <c:if test="${cpfInvalido == true}">
            <script>
                alert("Você precisa inserir um CPF válido!");
            </script>
        </c:if>
    </body>
</html>
