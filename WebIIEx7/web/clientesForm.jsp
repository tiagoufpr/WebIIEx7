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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" >

        function getCidades(){
            var estadoId = $("#estado").val();
            var url = "AJAXServlet";
            $.ajax({
                url : url, // URL da sua Servlet
                data : {
                estadoId : estadoId
                }, // Parâmetro passado para a Servlet
                dataType : 'json',
                success : function(data) {
                // Se sucesso, limpa e preenche a combo de cidade
                // alert(JSON.stringify(data));
                $("#cidadeAJAX").empty();
                $.each(data, function(i, obj) {
                $("#cidadeAJAX").append('<option value=' + obj.idCidade + '>' + obj.nomeCidade + '</option>');
                });


                },
                error : function(request, textStatus, errorThrown) {
                alert(request.status + ', Error: ' + request.statusText);
                            alert ("Erro AJAX");
                }
            });
        }
        </script>

    </head>
    <body>
        <jsp:useBean id="login" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>

        <c:if test="${empty sessionScope.login}">
            <jsp:forward page="/index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
          
        
        
        
      
        <c:if test="${alterar != null}">
            <h1>Dados do cliente</h1>

            <form action="ClientesServlet?action=update" method="POST">
                Nome: <input type="text" name="nome" value=${alterar.nomeCliente}>  <br/>
                Id: <input type="text" name="id" value=${alterar.idCliente}> <br/>
                CPF: <input type="text" name="cpf" value=${alterar.cpfCliente}> <br/>
                Email: <input type="text" name="email" value=${alterar.emailCliente}> <br/>
                Data: <input type="date" name="data" value=${alterar.dataCliente}> <br/>
                Rua: <input type="text" name="rua" value=${alterar.ruaCliente}> <br/>
                Número: <input type="text" name="numero" value=${alterar.nrCliente}> <br/>
                CEP: <input type="text" name="cep" value=${alterar.cepCliente}> <br/>

                
                Estado:
                <select name="uf" >
                    <option value="">Selecione</option>
                        <c:forEach items="${listaestados}" var="estado">  
                            <option value="${estado.idEstado}">${estado.nomeEstado}</option>
                        </c:forEach>
                </select>
                
                <br/>
                
                Cidade:
                <select name="cidade">
                    <option value="">Selecione</option>
                        <c:forEach items="${listacidades}" var="cidade">  
                            <option value="${cidade.idCidade}">${cidade.nomeCidade}</option>
                        </c:forEach>
                </select>

                
                </br></br>

                <input type="submit" value="Alterar"> <input type="submit" value="Cancelar" formaction="ClientesServlet">
            </form>
        </c:if>
            
            
        <c:if test="${alterar == null}">

            <h1>Novo do cliente</h1>

            <form action="ClientesServlet?action=new" method="POST">
                Nome: <input type="text" name="nome" > <br/>
                CPF: <input type="text" name="cpf" ><br/>
                Email: <input type="text" name="email" ><br/>
                Data: <input type="text" name="data" ><br/>
                Rua: <input type="text" name="rua" ><br/>
                Número: <input type="text" name="numero" ><br/>
                CEP: <input type="text" name="cep" ><br/>


              
       
                
             
                
                
                Estado:
                <select name="uf" id ="estado" onChange="getCidades();">
                    <option value="">Selecione</option>
                        <c:forEach items="${listaestados}" var="estado">  
                            <option value="${estado.idEstado}">${estado.nomeEstado}</option>
                        </c:forEach>
                </select>
                <br/>
                

                Cidade AJAX:
                <select name="cidadeAJAX" id="cidadeAJAX">
                    <option value="">Selecione</option>
                </select>
                <br/>
                
                

                <br/><br/>

                <input type="submit" value="Salvar"> <input type="submit" value="Cancelar" formaction="ClientesServlet">
            </form>
        </c:if>
        
        </br></br> <a href="#void" onclick="getCidades();" style="color: darkblue">Carregar Cidade</a>
    </body>
</html>
