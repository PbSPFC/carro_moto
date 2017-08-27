<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@page import="entidade.Carro"%>
<%
	List<Carro> lista = (List<Carro>)request.getAttribute("lista");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
</head>
<body>
	<div align="center">
		<h1>Administração de Carros</h1>
                <img border="1" alt="Carro" src="carro.png"/>
		<table>
			<tr>
                            <th>Nome </th><th>Marca </th><th>Ano </th><th>Potencia </th><th>Update </th><th>Delete </th>
			</tr>
		<% for(Carro carro: lista){ %>
			<tr>
				<form action="CarroController" method="post">
					<td>Nome <input type="text" name="nome" value="<%=carro.getNome() %>" /></td>
					<td>Marca <input type="text" name="marca" value="<%=carro.getMarca() %>" /></td>
                                        <td>Ano <input type="number" name="ano" value="<%=carro.getAno()%>" /></td>
                                        <td>Potencia <input type="number" name="potencia" value="<%=carro.getPotencia()%>" /></td>
					<input type="hidden" name="flag" value="update"/>
                                        <input type="hidden" name="id" value="<%=carro.getId() %>"/>
					<td><input type="submit" value="Update" /></td>
				</form>
				<form action="CarroController" method="post">
					<input type="hidden" name="id" value="<%=carro.getId() %>"/>
					<input type="hidden" name="flag" value="delete"/>
					<td><input type="submit" value="Delete" /></td>
				</form>
			</tr>
		<% } %>
		</table>
                
                
		<a href="carro.html">Voltar</a>
	</div>
</body>
</html>