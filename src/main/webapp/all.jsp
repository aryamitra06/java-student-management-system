<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>All Students | Student Management App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
		 <a class="navbar-brand">Student Management App</a>
		</div>
		</nav>
	</header>
	<br>

		<div class="container mt-3">
			<div class="d-flex justify-content-between">
			<h4>All Students</h4>
			<a href="<%=request.getContextPath()%>/new" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Register</a>
			</div>
			<table class="table table-hover mt-3">
				<thead class="table-dark">
					<tr>
						<th>Name</th>
						<th>Roll</th>
						<th>Section</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${listStudent}">
						<tr>
							<td><c:out value="${student.name}" /></td>
							<td><c:out value="${student.roll}" /></td>
							<td><c:out value="${student.section}" /></td>
							<td><a href="edit?id=<c:out value='${student.id}' />"><button type="button" class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i> Edit</button></a>
								<a href="delete?id=<c:out value='${student.id}' />"><button type="button" class="btn btn-danger"><i class="fa-solid fa-trash"></i> Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
</body>
</html>