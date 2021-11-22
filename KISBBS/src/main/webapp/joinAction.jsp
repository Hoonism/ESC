<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<jsp:setProperty name="user" property="grade" />
<jsp:setProperty name="user" property="email" />
<jsp:setProperty name="user" property="interestOne" />
<jsp:setProperty name="user" property="interestTwo" />
<jsp:setProperty name="user" property="interestThree" />
<jsp:setProperty name="user" property="firstName" />
<jsp:setProperty name="user" property="lastName" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World!</title>
</head>
<body>
	<%
	/*  work on checking grade too*/
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
		if (userID != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('You are already logged in')");
			script.println("history.back()");
			script.println("</script>");
		}
		if (user.getUserID() == null || user.getUserPassword() == null || user.getEmail() == null
		|| user.getInterestOne() == null || user.getInterestTwo() == null || user.getInterestThree() == null || user.getFirstName() == null
		|| user.getLastName() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('Please fill out the whole query')");
			script.println("history.back()");
			script.println("</script>");
		}
		else {
			UserDAO userDAO = new UserDAO();
			int result = userDAO.join(user);
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('ID already exists. Please use another ID')");
				script.println("history.back()");
				script.println("</script>");
			}
			else {
				session.setAttribute("userID", user.getUserID());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
			}
		}
		
	%>
</body>
</html>