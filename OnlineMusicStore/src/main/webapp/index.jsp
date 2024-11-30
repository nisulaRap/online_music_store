<!-- IT Number : IT22050908 -->
<!-- Name		 : Premaratne R.A.N.C. --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<title>Music Website</title>
</head>
<body>

	<!-- Include header.jsp -->
	<jsp:include page="header.jsp" />

	<section>
		<img class="hero" alt="" src="images/hero.jpg">
	</section>

	<div class="section-title">Featured</div>

	<!-- Display image and artist name -->
	<section class="content">
		<c:forEach var="pair" items="${combinedList}">
			<div class="music-card">
				<div style="overflow: hidden;">
					<img alt="" src="${pair.imageUrl}">
				</div>
				<div class="card-content">
					<div class="card-title">${pair.showImage.title}</div>
					<div class="card-subtitle">${pair.showImage.artistName}</div>
				</div>
			</div>
		</c:forEach>
	</section>

	<!-- Include footer.jsp -->
	<jsp:include page="footer.jsp" />

</body>
</html>