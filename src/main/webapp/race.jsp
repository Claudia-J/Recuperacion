<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index page</title>
	</head>
	<body>
		<form action="/race" method="post">
			<span>Race Name:</span> <input type="text" name="raceName"> <br />		
			<input type="submit">
		</form>
		<br />
		<table width=50%; border="1px" color="black">
			<tr>
				<td align="center"><a href="listRace.jsp">View Race List</a></td>
				<td align="center"><a href="listCharacter.jsp">View Character List</a></td>
				<td align="center"><a href="character.jsp">Add a new Character</a></td>
			</tr>
			<tr>
			<td align="center" colspan="3"><a href="index.jsp">Return to Homepage </a></td>
			<tr>
		</table>
	</body>
</html>