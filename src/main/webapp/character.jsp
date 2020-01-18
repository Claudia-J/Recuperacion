<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index page</title>
	</head>
	<body>
		<form action="/character" method="post">
			<span>Character Name:</span> <input type="text" name="characterName" required> <br />		
			<span>Character Race:</span> <input type="text" name="fkRace" required> <br />
			<span>Is this character carrier of the ring? :</span> 
			 		<select name="carrier" required>
			 		  <option value="false" selected>No es el portador</option>
					  <option value="true">Es el portador</option>
					</select> 
			<input type="submit">
		</form>
		<br/>
		<table width=50%; border="1px" color="black">
			<tr>
				<td align="center"><a href="listCharacter.jsp">View Character List</a></td>
				<td align="center"><a href="listRace.jsp">View Race List</a></td>
				<td align="center"><a href="race.jsp">Add a new Race</a></td>
			</tr>
			<tr>
			<td align="center" colspan="3"><a href="index.jsp">Return to Homepage </a></td>
			<tr>
		</table>

	</body>
</html>