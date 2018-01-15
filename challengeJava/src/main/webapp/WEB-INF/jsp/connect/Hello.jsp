<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Challenge</title>
	</head>
	<body>
		<h3>Hello, ${msg}!</h3>
		
<form action="/Upload"  method="post" >		
		

<!-- <label class="btn btn-default">
	<input type="file" name="file" >
	
</label> -->

<input type="submit" value="Upload">
	


		<table class="table table-striped">
			<caption>Here are your pictures:</caption>
			<tbody>
				<c:set var="count" value="${0}"/>
				<c:forEach items="${photos}" var="photo">
					<c:if test="${count eq 0}">
						<tr>
					</c:if>
					<td>	
						<input type="checkbox" name="Choices" value="${photo.getImages().get(0).getSource()}"/>
					</td>
					<td>
						<img height="200" width="200" src="${photo.getImages().get(0).getSource()}"/> 
					</td>
					
					<c:set var="count" value="${count + 1}"/>
						
					<c:if test="${count eq 5}">
						</tr>
						<c:set var="count" value="${0}"/>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		</form>	
		
	</body>
</html>