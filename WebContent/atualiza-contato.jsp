<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Desenvolvimento WEB II - Agenda em Java</title>

<!-- importando Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/custom.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="container">

			<div class="card">
				<div class="card-header">Agenda</div>
				<div class="card-body">
					<h5 class="card-title">Cadastro de contato</h5>
					<form action="mvc?logica=ContatoLogica&acao=atualiza" method="POST">
						<input type="hidden" name="id" value="${contato.id}"> 
						<div class="form-group">
							<label for="nome">Nome</label> <input type="text"
								class="form-control" id="nome" name="nome"
								placeholder="Digite o nome" value="${contato.nome}">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="email" name="email"
								placeholder="Digite o email" value="${contato.email}">
						</div>
						<div class="form-group">
							<label for="endereco">Endereço</label> <input type="text"
								class="form-control" id="endereco" name="endereco"
								placeholder="Digite o endereço" value="${contato.endereco}">
						</div>
						<div class="form-group">
							<label for="dataNascimento">Data de nascimento</label> <input
								type="date" class="form-control" id="dataNascimento"
								name="dataNascimento" value="${contato.dataNascimento}">
						</div>

						<button type="submit" class="btn btn-primary">Salvar</button>
					</form>
				</div>
			</div>
		</div>
	</div>
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
