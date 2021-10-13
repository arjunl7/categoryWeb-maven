<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String isAuth = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
					if(cookie.getName().equals("auth")) {
						 isAuth = cookie.getValue();
					}
			}
		}
		
		if(isAuth.equals("true")) {
			response.sendRedirect("user.html");
		} else {
			response.sendRedirect("indexjsp.jsp");
		}
	%>
	<h1>Home Page</h1>
</body>
</html>