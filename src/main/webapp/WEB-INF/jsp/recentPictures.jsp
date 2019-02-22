<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Recent NASA pictures of the day</title>
<style>
.video-container {
	position: relative;
	padding-bottom: 56.25%;
	padding-top: 30px;
	height: 0;
	overflow: hidden;
}

.video-container iframe {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>
</head>

<body>
	<section>
		<div class="jumbotron bg-secondary text-white">
			<div class="container">
				<h1>Recent NASA pictures of the day</h1>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${recentPictures}" var="recentPictures">
				<div class="col-sm-6 col-md-4 col-lg-3">
					<div class="thumbnail">
						<div class="caption">
							<h3>${recentPictures.title}</h3>
							<c:set var="media_type" value="${recentPictures.media_type}" />
							<c:choose>
								<c:when test="${media_type=='image'}">
									<img src="${recentPictures.url}" style="width: 100%; height: auto;" />
								</c:when>
								<c:when test="${media_type=='video'}">
									<div class="video-container">
										<iframe width="420" height="315" src="${recentPictures.url}" allowfullscreen > </iframe>
									</div>								
								</c:when>
							</c:choose>
							<p>${recentPictures.explanation}</p>
							<p><a href="<spring:url value="/date?date=${recentPictures.date}" />" class="btn btn-default">Details </a></p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>