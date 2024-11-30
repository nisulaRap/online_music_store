<!-- IT Number : IT22050908 -->
<!-- Name		 : Premaratne R.A.N.C. --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/search.css" />
</head>
<body>

	<!-- Display image, artist name and title after searching -->
	<c:forEach var="pair" items="${showAllDetails}">
		<div class="searchName">
			<h2>${pair.musicDetail.title}</h2>
		</div>
		<section class="content">
			<div class="music-card">
				<div style="overflow: hidden;">
					<img alt="" src="${pair.imageUrl}">
				</div>
				<div class="card-content">
					<div class="card-title">${pair.musicDetail.title}</div>
					<div class="card-subtitle">${pair.musicDetail.artist}</div>
					<br>
					<audio controls class="card-subtitle2">
						<source src="${pair.audioUrl}" type="audio/mpeg">
					</audio>
				</div>
			</div>
		</section>
	</c:forEach>

	<!-- Create comment box -->
	<div class="box">
		<form method="post" action="createServlet">
			<div class="comment-box">
				<textarea class="comment-type" placeholder="What's on your mind.."
					name="comment" onfocus="this.value=''" rows="4" cols="76"></textarea>
				<br>
				<button class="btn">Post</button>
			</div>
		</form>
	</div>

	<!-- Display comment box and also edit and delete comment -->
	<div class="content">
		<table class="display-box">
			<c:forEach var="post" items="${searchpage}">
				<form action="updateServlet" method="get">
					<tr>
						<td colspan="3" class="col1"><textarea class="input-type"
								name="editcomment" rows="4" cols="79"><c:out
									value="${post.comment}" /></textarea> <input type="hidden" name="postID"
							value="${post.postID}" /></td>
					</tr>
					<tr>
						<td class="col2"><c:out value="${post.date}" /></td>
						<td colspan="2" class="col3">
							<button type="submit" class="editbtn">Edit</button>&nbsp; 
							<a class="deletebtn" href="deleteServlet?postID=${post.postID}">Delete</a>
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
</body>
</html>