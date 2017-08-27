<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@page import="entidade.Moto"%>
<%
	List<Moto> lista = (List<Moto>)request.getAttribute("lista");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
</head>
<body>
	<div align="center">
		<h1>Administração de Motos</h1>
                <img border="1" alt="Moto" src="moto.png"/>
		<table>
			<tr>
                            <th>Nome </th><th>Marca </th><th>Ano </th><th>Potencia </th><th>Update </th><th>Delete </th>
			</tr>
		<% for(Moto moto: lista){ %>
			<tr>
				<form action="MotoController" method="post">
					<td>Nome <input type="text" name="nome" value="<%=moto.getNome() %>" /></td>
					<td>Marca <input type="text" name="marca" value="<%=moto.getMarca() %>" /></td>
                                        <td>Ano <input type="number" name="ano" value="<%=moto.getAno()%>" /></td>
                                        <td>Potencia <input type="number" name="potencia" value="<%=moto.getPotencia()%>" /></td>
					<input type="hidden" name="flag" value="update"/>
                                        <input type="hidden" name="id" value="<%=moto.getId() %>"/>
					<td><input type="submit" value="Update" /></td>
				</form>
				<form action="MotoController" method="post">
					<input type="hidden" name="id" value="<%=moto.getId() %>"/>
					<input type="hidden" name="flag" value="delete"/>
					<td><input type="submit" value="Delete" /></td>
				</form>
			</tr>
		<% } %>
		</table>
                
                
		<a href="moto.html">Voltar</a>
	</div>
</body>
</html>