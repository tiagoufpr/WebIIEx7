<%-- 
    Document   : atendimentosVisualizar
    Created on : 30/10/2018, 00:06:52
    Author     : Itay
--%>

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
            
        <%    
            Atendimento atendimento = (Atendimento) request.getAttribute("visualizar");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID </th>");
            out.println("<th>Data e hora</th>");
            out.println("<th>Descrição</th>");
            out.println("<th>ID produto</th>");
            out.println("<th>ID tipo atendimento</th>");
            out.println("<th>ID usuario</th>");
            out.println("<th>ID cliente</th>");
            out.println("<th>Resolvido</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>" + atendimento.getIdAtendimento()+ "</td>");  
            out.println("<td>" + atendimento.getDtHrAtendimento()+ "</td>"); 
            out.println("<td>" + atendimento.getDscAtendimento() + "</td>");
            out.println("<td>" + atendimento.getIdProduto() + "</td>");
            out.println("<td>" + atendimento.getIdTipoAtendimento() + "</td>");
            out.println("<td>" + atendimento.getIdUsuario() + "</td>");
            out.println("<td>" + atendimento.getIdCliente() + "</td>");
            out.println("<td>" + atendimento.getResAtendimento() + "</td>");
            out.println("</tr>");

            out.println("</table>");
        %>
        <br>
        <a href="AtendimentoServlet">Voltar</a>
    </body>
</html>