<!-- IT Number : IT22050908 -->
<!-- Name		 : Premaratne R.A.N.C. --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css" />
</head>
<body>
	<header>
		<div class="logo-holder">
			<img class="logo" alt="" src="images/logo.jpg">
		</div>
		<div class="header-div">
			<div class="main-title">MUSIC WEBSITE</div>
			<div class="main-nav">
				<div class="nav-item active">
					<a href="index.jsp">Home</a>
				</div>
				<div class="nav-item">
					<a href="#">Music</a>
				</div>
				<div class="nav-item dropdown">
					<a href="#">Category</a>
					<div class="dropdown-list">
						<div class="nav-item">
							<a href="#" class="item-hov">Country</a>
						</div>
						<div class="nav-item">
							<a href="#" class="item-hov">Pop</a>
						</div>
					</div>
				</div>
				<div class="nav-item">
					<a href="#">Artists</a>
				</div>
				<div class="nav-item">
					<a href="aboutUs.jsp">About Us</a>
				</div>
				<div class="nav-item">
					<a href="#">Contact Us</a>
				</div>
				<div class="nav-item dropdown right-coner">
					<a href="#">Hi,User</a>
					<div class="dropdown-list">
						<div class="nav-item">
							<a href="#" class="item-hov">Profile</a>
						</div>
						<div class="nav-item">
							<a href="login.jsp" class="item-hov">Logout</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<!-- Drop down list in menu bar -->
	<script>
		var dropdowns = document.querySelectorAll(".dropdown-list");
		for (var i = 0; i < dropdowns.length; i++) {
			dropdowns[i].classList.add("hide");
		}

		var dropdowns = document.querySelector("header").querySelectorAll(
				".dropdown");
		for (var i = 0; i < dropdowns.length; i++) {
			dropdowns[i].addEventListener("click",function(e) {
				var links = e.currentTarget.parentNode.querySelectorAll(".dropdown-list");
				for (var i = 0; i < links.length; i++) {
					if (e.currentTarget.querySelector(".dropdown-list") != links[i])
						links[i].classList.add("hide");
					}
				e.currentTarget.querySelector(".dropdown-list").classList.toggle("hide");
			});
		}
	</script>
</body>
</html>