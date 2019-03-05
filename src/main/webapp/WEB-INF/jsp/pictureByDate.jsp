<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>NASA picture of the selected date</title>
</head>

<body>
	<section>
		<div class="jumbotron text-white">
			<div class="container">
				<h1>NASA picture of the selected date</h1>
			</div>
		</div>
	</section>

	<section class="container" style="padding-bottom: 15px">
		<div class="row">
			<div class="col-sm-9 col-md-9 col-lg-9" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption video-container">
						<h2>${pictureByDate.title}</h2>
						<div>
							<c:set var="media_type" value="${pictureByDate.media_type}" />
							<c:choose>
								<c:when test="${media_type=='image'}">
									<img src="${pictureByDate.url}"
										style="width: 100%; height: auto;" />
								</c:when>
								<c:when test="${media_type=='video'}">
									<div class="video-container">
										<iframe width="820" height="550" src="${pictureByDate.url}"
											allowfullscreen> </iframe>
									</div>
								</c:when>
							</c:choose>
						</div>
						<h2>Description</h2>
						<p>${pictureByDate.explanation}</p>
					</div>
				</div>
			</div>
			<div class="col-sm-3 col-md-3 col-lg-3">
				<h2>Details</h2>
				<p></p>
				<p>
					<b>Picture date: </b>${pictureByDate.date}</p>
				<p>
					<b>Copyright: </b>${pictureByDate.copyright}</p>
				<p>
					<b>Url: </b>${pictureByDate.url}</p>
				<p>
					<b>Hdurl: </b>${pictureByDate.hdurl}</p>
			</div>
		</div>
	</section>
</body>
</html>