<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>C-Update</title>
	</head>
	<body>
		<form action="/update?pkCharacter=${character.pkCharacter}" method="post">
	        <span>ID: </span> <input type="text" value="${character.pkCharacter}" disabled="disabled" name="pkCharacter"> <br />
	        <span>Character Name: </span> <input type="text" value="${character.characterName}" name="characterName"> <br />
	        <span>Race: </span> <input type="text" value="${character.fkRace}" name="fkRace"> <br />
	        <span>Is this character carrier of the ring?: </span> <input type="text" value="${character.carrier}" name="carrier"> <br />
	        <input type="submit">
	    </form>
	</body>
</html>