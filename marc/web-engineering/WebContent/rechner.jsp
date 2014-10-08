<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
		<style>
			.results {
				overflow: auto;
				max-height: 100px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-3">
					<div class="page-header">
						<h3>Rechner</h3>
					</div>
					<jsp:useBean id="rechner" class="beans.RechnerBean" scope="application" />
					<c:if test="${param.number1 != null && param.operator != null && param.number2 != null}">
						<jsp:setProperty name="rechner" property="number1" param="number1"/>
						<jsp:setProperty name="rechner" property="operator" param="operator"/>
						<jsp:setProperty name="rechner" property="number2" param="number2"/>
						<% rechner.calculate(); %>
						<c:if test="${rechner.hasError()}">
							<div class="alert alert-danger">
								<jsp:getProperty name="rechner" property="error"/>
							</div>
						</c:if>
					</c:if>
					<form class="form-horizontal" action="rechner.jsp" method="GET">
						<div class="form-group">
							<div class="col-md-4">
								<input type="number" step="0.1" value="0" name="number1" class="form-control">
							</div>
							<div class="col-md-4">
								<select name="operator" class="form-control">
									<option>+</option>
									<option>-</option>
									<option>*</option>
									<option>/</option>
								</select>
							</div>
							<div class="col-md-4">
								<input type="number" step="0.1" value="0" name="number2" class="form-control">
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Berechnen</button>
					</form>
				</div>
				<div class="col-md-3">
					<div class="page-header">
						<h3>Ergebnis</h3>
					</div>
					<div class="results">
						<c:forEach var="result" items="${rechner.getResults()}">
						    <code>${result}</code>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	</body>
</html>