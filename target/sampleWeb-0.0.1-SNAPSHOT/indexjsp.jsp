<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login jsp</title>
</head>
<body>
	<h1>Login</h1>
	<form action="loginjsp" method="post">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="checkbox" id="remember-me" name="remember">
		<label for="remember-me">Remember me</label><br>
		<label for="lang">Choose a Language</label>
		<select name="language" id="lang">
		    <option value="en_US">EN US</option>
	    	<option value="">EN IN</option>
		</select>
		<input type="submit" value="Login">
	</form>
</body>
</html>