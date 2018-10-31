<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista contatos</title>
<!-- importando Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/custom.css" />

</head>
<body>
	<%@	page
		import="java.util.*,
				br.com.agenda.jdbc.dao.*,
				br.com.agenda.jdbc.modelo.*"%>
	<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">#</th>
      			<th scope="col">Nome</th>
      			<th scope="col">Email</th>
      			<th scope="col">Endereço</th>
      			<th scope="col">Data de Nascimento</th>
    		</tr>
  		</thead>	
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos) {
		%>
		<tbody>		
			<tr>
				<td><%=contato.getId()%></td>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getEmail()%></td>
				<td><%=contato.getEndereco()%></td>
				<td><%=contato.getDataNascimento().getTime()%></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
	
	
	
	
	<!-- cria o DAO	-->
	<jsp:useBean id="contatoDao" class="br.com.agenda.jdbc.dao.ContatoDao" />
	<table>
		<!-- percorre contatos montando	as linhas da tabela	-->
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
	<footer>
		<!-- importando Bootstrap JavaScript -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
			integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
			integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
			crossorigin="anonymous"></script>
	</footer>
</body>
</html>