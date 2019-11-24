<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author"
			content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
		<title>Gerenciador de Notícias</title>
		
		<!-- Bootstrap core CSS -->
		<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">			
		
		
		<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
		</style>
	</head>
	<body>
		<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
			<h5 class="my-0 mr-md-auto font-weight-normal">BitApp</h5>
			<nav class="my-2 my-md-0 mr-md-3">
				<a class="p-2 text-dark" href="/cadastro/lista">Cadastro</a> 
				<a class="p-2 text-dark" href="/jornalista/lista">Jornalista</a> 
				<a class="p-2 text-dark" href="/noticia/lista">Notícia</a> 
			</nav>
			<a class="btn btn-outline-primary" href="#">Sair</a>
		</div>
	
		<div class="container">
			<h1 class="display-4">Cadastros</h1>
			<a href="/cadastro/nova" class="btn btn-labeled btn-success" role="button"><i class="fas fa-plus-square"></i> Nova</a>
			<table id="example" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>Nome</th>
		                <th>CPF</th>
		                <th>E-mail</th>
		                <th>Senha</th>
		                <th>Ações</th>
		            </tr>
		        </thead>
		        <tbody>
					<c:forEach var="cadastro" items="${cadastros}">
					<tr>
						<td>
							${cadastro.idCadastro}
						</td>
						<td>
							${cadastro.nome}
						</td>
						<td>
							${cadastro.cpf}
						</td>
						<td>
							${cadastro.email}
						</td>
						<td>
							${cadastro.senha}
						</td>
						<td>
							<a href="/cadastro/edita?id=<c:out value='${cadastro.idCadastro}'/>" class="btn btn-labeled btn-warning" role="button"><span class="btn-label"><i class="fas fa-edit"></i></span> </a>
							<a href="/cadastro/remove?id=<c:out value='${cadastro.idCadastro}'/>" class="btn btn btn-labeled btn-danger" role="button"><span class="btn-label"><i class="fas fa-edit"></i></span> </a>							
						</td>
		            </tr>  
					</c:forEach>
	            </tbody>
			</table>
		</div>

	</body>
</html>