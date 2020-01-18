<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,tolkien.lotr.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>R-List</title>
	</head>
	<body>
		<form method="post" action="listRace">
    		<input type="submit" value="Show Race List">
		</form>
		<br />
		<table class="race_table" width=50%; border="1px" color="black">
		<!-- TAGLIB -->
		    <tr>
		   	   <td>Race Identifier: </td>
		       <td>Race Name: </td>
		       <td>Update</td>
		       <td>Delete</td>
		    </tr>
			<c:forEach items="${listRace}" var="race">
				 <tr>
					<td>${race.pkRace}</td>
			        <td>${race.raceName}</td>
			        <td><a href="/updateRace?pkRace=${race.pkRace}">Update</a></td>
			        <td><a href="/deleteRace?pkRace=${race.pkRace}">Delete</a></td>
			    </tr>
			</c:forEach>
		</table>
		<br />
		<table width=50%; border="1px" color="black">
			<tr>
				<td align="center"><a href="race.jsp">Add a new Race</a></td>
				<td align="center"><a href="character.jsp">Add a new Character</a></td>
				<td align="center"><a href="listCharacter.jsp">View Character List</a></td>
			<tr>
			<td align="center" colspan="3"><a href="index.jsp">Return to Homepage </a></td>
			<tr>
		</table>
	</body>
</html> 