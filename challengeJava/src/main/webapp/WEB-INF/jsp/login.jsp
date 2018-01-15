<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>

<head>
<title>Challenge</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <form method="post">
    <table class="table table-striped">
			<caption>Login or Register:</caption>
			<tbody>
			<tr>
				<td>
					Email : 
				</td>
				<td>
					<input type="text" name="name" /> 
				</td>
			</tr>
			<tr>
				<td>
					Password :
				</td>
				<td>
					<input type="password" name="password" />  
				</td>
			</tr>
			<tr>
				<td>
					<INPUT type= "radio" name="Choice" value="Login" checked> Login
					<INPUT type= "radio" name="Choice" value="Register"> Register
				</td>					
			</tr>
			<tr>
				<td>
					<input type="submit" name="Login"/> 
				</td>
			</tr>
			</tbody>
		</table>        
    </form>

</body>

</html>