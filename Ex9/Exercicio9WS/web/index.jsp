<%-- 
    Document   : portal
    Created on : 12/11/2018, 18:20:38
    Author     : Itay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal</title>
        <style>
            td, th{
                border: 1px solid black;
            }            
        </style>
    </head>
    <style>
        .w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
        .w3-half img:hover{opacity:1}
    </style>
    <body>        
        <nav class="w3-sidebar w3-black w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
          <div class="w3-container">
            <h3 class="w3-padding-64"><b>Menu</b></h3>
          </div>
          <div class="w3-bar-block">
            <a href="AtendimentoServlet" class="w3-bar-item w3-button w3-hover-white">Atendimentos</a>
            <a href="ProdutoServlet" class="w3-bar-item w3-button w3-hover-white">Produtos</a>
          </div>
        </nav>
    </body>
</html>
