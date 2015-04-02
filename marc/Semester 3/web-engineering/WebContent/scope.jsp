<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Scope</title>
	</head>
	<body>
		<jsp:useBean id="pageCounter" class="beans.CounterBean" scope="page"/>
		<jsp:useBean id="requestCounter" class="beans.CounterBean" scope="request"/>
		<jsp:useBean id="sessionCounter" class="beans.CounterBean" scope="session"/>
		<jsp:useBean id="applicationCounter" class="beans.CounterBean" scope="application"/>
		<h1>
			<jsp:getProperty name="pageCounter" property="i"/>
		</h1>
		<h2>
			<jsp:getProperty name="requestCounter" property="i"/>
		</h2>
		<h3>
			<jsp:getProperty name="sessionCounter" property="i"/>
		</h3>
		<h4>
			<jsp:getProperty name="applicationCounter" property="i"/>
		</h4>
	</body>
</html>