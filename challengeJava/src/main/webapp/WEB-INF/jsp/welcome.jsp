<html>

<head>
<title>Challenge</title>
</head>

<body>
    Welcome ${name}!! <p>${msg} </p>
    
    <!-- <a href="/list-todos">Click here</a> to manage your todo's. -->
    <br/>
    <h3>Connect to Facebook</h3>

		<form action="/connect/facebook" method="POST">
			<input type="hidden" name="scope" value="user_posts" />
			<div class="formInfo">
				<p>You aren't connected to Facebook yet. Click the button to connect this application with your Facebook account.</p>
			</div>
			<p><button type="submit">Connect to Facebook</button></p>
		</form>
</body>

</html>