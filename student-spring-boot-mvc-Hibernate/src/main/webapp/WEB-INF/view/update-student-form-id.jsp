<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring-Hibernate</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Update Student By Id</h2>
			<div class="panel panel-info">
				<div class="panel-body">
					<form:form action="updateStudentById" cssClass="form-horizontal"
						method="post" modelAttribute="student">

						<div class="form-group">
							<table class="table table-striped table-bordered">
								<tr>
									<td>
										<label for="name" class="col-md-3 control-label">Enter Student Id:</label>
									</td>
									<td>
										<form:input path="id" cssClass="form-control" />
									</td>
								</tr>
								<tr>
								<td/>
								<c:if test="${student.errorMessage != null}">
									<td>
										<font color="red">${student.errorMessage}<b>${student.id}</b></font>
									</td>
								</c:if>
								</tr>
							</table>
							 
							<!-- need to associate this data with Student id -->
							<form:hidden path="id" />
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Get Student Details</form:button>
							</div>
						</div>
						<div class="panel-body">
							<c:url var="goHome" value="/">
							</c:url>
							<a href="${goHome}">Go Home</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>