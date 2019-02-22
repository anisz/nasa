<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Log in</title>
</head>
<body>
	<section>
		<div class="jumbotron bg-secondary text-white">
			<div class="container">
				<h1>Administration</h1>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<!-- <div class="col-md-4 col-md-offset-4"> -->
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Log in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<p>Bad credentials - try again!</p>
								<br />
							</div>
						</c:if>
						<form action="<c:url value="/j_spring_security_check"></c:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="username"
										name='j_username' type="text" /> 
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="password"
										name='j_password' type="password" /> 
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
								</div>
								<input class="btn btn-default" type="submit" value="Submit" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>