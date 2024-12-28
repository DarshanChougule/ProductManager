<%@page import="java.util.List"%>
<%@page import="crud.model.Product"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./base.jsp"%>
<title>Home Page</title>
</head>
<body>
	<div class="container mt-3">

		<div class="row">

			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">S.No</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<% for(Product p : (List<Product>) request.getAttribute("product")) { %>

						<tr>
							<th scope="row"><%=p.getId() %></th>
							<td><%=p.getName() %></td>
							<td><%=p.getDescription() %></td>
							<td class="font-weight-bold">&#8377;<%=p.getPrice() %></td>
							<td>
							<a class="m-2" href="delete/<%=p.getId()%>"><i class="fa-solid fa-trash text-danger"></i></a>
							<a href="update/<%=p.getId()%>"><i class="fa-solid fa-pen"></i></a>
							</td>
						</tr>
						<% } %>
					</tbody>
				</table>
				
				<div class="container text-center">
				<a href="add-product" class="btn btn-outline-success">Add Product</a>
				</div>

			</div>

		</div>

	</div>


</body>
</html>