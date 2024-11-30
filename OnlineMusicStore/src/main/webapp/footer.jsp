<!-- IT Number : IT22050908 -->
<!-- Name		 : Premaratne R.A.N.C. --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/footer.css" />
</head>
<body>
	<footer>
		<div class="footer-div">
			<ul>
				<li><a href="#">Terms and Conditions</a></li>
				<li><a href="#">Music</a></li>
				<li><a href="aboutUs.jsp">About Us</a></li>
				<li><a href="#">Privacy and Cookies Policy</a></li>
				<li><a href="#">Feedback</a></li>
			</ul>
		</div>
		<div class="footer-div">
			<form method="post" action="SearchSongServlet"
				onsubmit="return validateForm()">
				<div class="form-group">
					<input class="form-control" type="text"
						placeholder="Search for music" name="find" pattern="[A-Za-z\s]+"
						title="Music name should not contain numbers" id="searchInput"
						 />
					<button class="btn">Search</button>
				</div>
			</form>
		</div>
		<div class="footer-div"></div>
	</footer>

	<!-- Validate Search bar -->
	<script>
		function validateForm() {
			var searchInput = document.getElementById("searchInput").value;
			if (searchInput.trim() === "") {
				alert("Please enter a search term.");
				return false; // Prevent form submission
			}
			return true; // Allow form submission
		}
	</script>
</body>
</html>