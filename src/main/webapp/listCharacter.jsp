<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,tolkien.lotr.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>C-List</title>
	</head>
	<body>
		<form method="post" action="listCharacter">
	    	<input type="submit" value="Show Character List">
		</form>
		<br />
		<table class="character_table" width=50%; border="1px" color="black">
		<!-- TAGLIB -->
		    <tr>
		       <td>Character Identifier: </td>
		       <td>Character Name: </td>
		       <td>Race: </td>
		       <td>Is this character carrier of the ring? :</td>
		       <td>Update</td>
		       <td>Delete</td>
		    </tr>
			<c:forEach items="${listCharacter}" var="character">
				<tr>
					<td>${character.pkCharacter}</td>
			        <td>${character.characterName}</td>
			        <td>${character.fkRace}</td>
			        <td>${character.carrier}</td>
			        <td><a href="/updateCharacter?pkCharacter=${character.pkCharacter}">Update</a></td>
			        <td><a href="/deleteCharacter?pkCharacter=${character.pkCharacter}">Delete</a></td>
			    </tr>
			</c:forEach>
		</table>
		<br /><br />
		<table width=50%; border="1px" color="black">
			<tr>
				<td align="center"><a href="character.jsp">Add a new Character</a></td>
				<td align="center"><a href="race.jsp">Add a new Race</a></td>
				<td align="center"><a href="listRace.jsp">View Race List</a></td>
			<tr>
			<td align="center" colspan="3"><a href="index.jsp">Return to Homepage </a></td>
			<tr>
		</table>
	</body>
</html> 