<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>R-Update</title>
	</head>
	<body>
	    <form action="/update?pkRace=${race.pkRace}" method="post">
	    	<span>Race Identifier: </span> <input type="text" value="${race.pkRace}" disabled="disabled" name="pkRace"> <br />
	        <span>Race Name: </span> <input type="text" value="${race.raceName}" name="raceName"> <br />
	    </form>	    
	</body>
</html> 