<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidade.Moto"%>
<%
	Moto moto = (Moto) request.getAttribute("moto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Moto cadastrado</title>
    </head>
    <body>
        <div align="center">
            <h1><%= moto.getNome()%> foi inserido no banco de dados</h1>
            <a href="moto.html">Voltar</a><br /> 
        </div>
        
    </body>
</html>
