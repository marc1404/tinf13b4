<!--
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Fibonacci-Zahlen</h1>
<fieldset>
Startwerte
<form>
<label>
f0
<input type="text" name="f0" class="form-control">
</label>
<br>
<label>
f1
<input type="text" name="f1" class="form-control">
</label>
<br>
<button type="submit" class="btn btn-primary">Senden</button>
</form>
</fieldset>
<c:if test="${param.f0.length() > 0 && param.f1.length() > 0}">
	<c:set var="f">${0}</c:set>
	<c:forEach begin="0" end="20" var="i">
		<c:set var="f">${f + f0}</c:set>
		<p><c:out value="${f}" /></p>
	</c:forEach>
</c:if>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>
-->