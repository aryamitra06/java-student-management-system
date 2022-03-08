<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit Student Details | Student Management App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card col-md-6">
			<div class="card-body">
					<form action="update" method="post">
				<caption>
					<h3 class="text-center">Edit Student</h3>
				</caption>
				
					<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
					
					<label class="form-label">Name</label>
					<input type="text" class="form-control mb-2" name="name" value="<c:out value='${student.name}' />" required="required">

					<label class="form-label">Roll</label>
					<input type="text" class="form-control mb-2" value="<c:out value='${student.roll}' />" name="roll">

					<label class="form-label">Section</label>
					<input type="text" class="form-control mb-2" value="<c:out value='${student.section}' />" name="section">

				<button type="submit" class="btn btn-success w-100 mt-3">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>