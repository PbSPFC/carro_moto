<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidade.Carro"%>
<%
	Carro carro = (Carro) request.getAttribute("carro");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Carro cadastrado</title>
    </head>
    <body>
        <div align="center">
            <h1><%= carro.getNome()%> foi inserido no banco de dados</h1>
            <a href="carro.html">Voltar</a><br /> 
        </div>
        
    </body>
</html>
