<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Administration</title>
</head>

<body>
	<section>
		<div class="jumbotron bg-secondary text-white">
	<!--  	<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-primary pull-right">
		Log out
		</a> -->
			<div class="container">
				<h1>Set the number of recent pictures to be downloaded</h1>
			</div>
		</div>
	</section>

	<div class="container">
		<h2>Set the number of recent pictures</h2>
		<form:form modelAttribute="numberOfDays">
			<form:input id="numberOfDays" path="" type="number" 
				min="2" max="36" class="form-control" name="numberOfDays"
				placeholder="12" /> 
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>
</body>
</html>