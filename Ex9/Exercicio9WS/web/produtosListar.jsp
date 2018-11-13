<%-- 
    Document   : produtosListar
    Created on : 12/11/2018, 19:05:06
    Author     : Itay
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="java.util.List"%>
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
        <p id="demo"></p>
        <script>
        function jsRemover(i){
            var r=confirm("Deseja Remover?");

            if (r===true)
              window.location.href = "ProdutoServlet?action=remove&id=" +i;

            document.getElementById("demo").innerHTML=x;
        }
        </script>

        
        <nav class="w3-sidebar w3-black w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
          <div class="w3-container">
            <h3 class="w3-padding-64"><b>Menu</b></h3>
          </div>
          <div class="w3-bar-block">
            <a href="AtendimentoServlet" class="w3-bar-item w3-button w3-hover-white">Atendimentos</a>
            <a href="ProdutoServlet" class="w3-bar-item w3-button w3-hover-white">Produtos</a>
          </div>
        </nav>

        <div class="w3-right" style="padding-right: 250px;">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Detalhes</th>
                </tr>

                <c:forEach items="${listar}" var="produto">
                    <tr>
                    <td> ${produto.idProduto} </td> 
                    <td> ${produto.nomeProduto} </td> 
                    <td> <a href="ProdutoServlet?action=show&id=${produto.idProduto}"><img src="Imagens/view.jpg" height="25" width="25px"></a></td>
<!--
                    <td> <a href="AtendimentoServlet?action=formUpdate&id=${atendimento.idAtendimento}"><img src="Imagens/update.png" height="25" width="25px"></a></td>
                    <td> <a href="#void" onclick="jsRemover(${atendimento.idAtendimento});"><img src="Imagens/remove.png" height="25" width="25px"></a></td>
-->
                    </tr>
                </c:forEach>
            </table>
            
            <br>
            <a href="ProdutoServlet?action=formNew"  style="color: darkblue">Novo</a>
            </br> <a href ='ProdutoServlet?action=formProduto&id=1' style="color: darkblue">Form Produto- Existente</a>
            </br> <a href ='ProdutoServlet?action=formProduto&id=20' style="color: darkblue">Form Produto - Novo</a>

        </div>
    </body>
</html>
