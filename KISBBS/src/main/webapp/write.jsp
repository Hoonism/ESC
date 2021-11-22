<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name='viewport' content='width=device-width'>
<link rel='stylesheet' href='css/bootstrap.css'>
<title>KIS BBS</title>
</head>
<body>
	<%
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>
	<nav class='navbar navbar-default'>
		<div class='navbar-header'>
			<button type='button' class='navbar-toggle collapsed' 
				data-toggle='collapse' data-target='#bs-example-navbar-collapse-1'
				aria-expanded='false'>
				<span class='icon-bar'></span>
				<span class='icon-bar'></span>
				<span class='icon-bar'></span>
			</button>
			<a class='navbar-brand' href='main.jsp'>KIS BBS</a>
		</div>
		<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>
			<ul class='nav navbar-nav'>
				<li><a href='main.jsp'>main</a></li>
				<li class='active'><a href='main.jsp'>dashboard</a></li>
			</ul>
			<%
				if (userID == null) {
			%>
			<ul class='nav navbar-nav navbar-right'>
				<li class='dropdown'>
					<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>
						connect<span class='caret'></span>
					</a>
					<ul class='dropdown-menu'>
						<li><a href='login.jsp'>login</a></li>
						<li><a href='join.jsp'>sign up</a></li>
					</ul>
				</li>
			</ul>
			<%
				} else {
			%>
			<ul class='nav navbar-nav navbar-right'>
				<li class='dropdown'>
					<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>
						preferences<span class='caret'></span>
					</a>
					<ul class='dropdown-menu'>
						<li><a href='logoutAction.jsp'>logout</a></li>
					</ul>
				</li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>
	<div class='container'>
		<div class='row'>
			<form method='post' action='writeAction.jsp'>
				<table class='table table-striped' style='text-align: center; border: 1px solid #dddddd'>
					<thead>
						<tr>
							<th colspan='2' style='background-color: #eeeeee; text-align: center;'>Dashboard Post</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type='text' class='form-control' placeholder='post title' name='title' maxlength='100'></td>
						</tr>
						<tr>
							<td><textarea class='form-control' placeholder='post content' name='content' maxlength='8192' style='height: 350px;'></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type='submit' class='btn btn-primary pull-right' value='submit'>
			</form>
		</div>
	</div>
	<script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
	<script src='js/bootstrap.js'></script>
</body>
</html>