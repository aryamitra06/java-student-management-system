<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Register New Student | Student Management App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card col-md-6">
			<div class="card-body">
					<form action="insert" method="post">
				<caption>
					<h3 class="text-center">Register New Student</h2>
				</caption>
				
					<label class="form-label">Name</label>
					<input type="text" class="form-control mb-2" name="name" required="required">

					<label class="form-label">Roll</label>
					<input type="number" class="form-control mb-2" name="roll">

					<label class="form-label">Section</label>
					<input type="text" class="form-control mb-2" name="section">

				<button type="submit" class="btn btn-success w-100 mt-3">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>