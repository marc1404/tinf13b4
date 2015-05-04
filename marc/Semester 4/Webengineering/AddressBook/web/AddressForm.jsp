<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 30.04.2015
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="address" class="com.vornetran.marc.beans.Address" scope="request"></jsp:useBean>
${address.parseId(param.id)}
${address.read()}
<t:layout>
  <jsp:attribute name="title">Adresse bearbeiten</jsp:attribute>
  <jsp:attribute name="js">
    <script src="js/delete.js"></script>
  </jsp:attribute>
  <jsp:body>
    <div class="page-header">
      <h1>Adresse bearbeiten</h1>
    </div>
    <c:if test="${param.error != null}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${param.error}
        </div>
    </c:if>
    <form method="POST" action="/save" accept-charset="utf-8">
        <c:if test="${param.id != null}">
            <input name="id" type="hidden" value="${param.id}"
        </c:if>
        <h2>Name</h2>
        <div class="row">
            <div class="col-xs-4">
                <label for="addressForm">Anrede</label>
                <select id="addressForm" name="addressForm" class="form-control">
                    <option ${address.addressForm.equals("Frau") ? "selected" : ""} value="Frau">Frau</option>
                    <option ${address.addressForm.equals("Herr") ? "selected" : ""} value="Herr">Herr</option>
                </select>
            </div>
            <div class="col-xs-offset-8"></div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <label for="christianName">Vorname</label>
                <input id="christianName" name="christianName" type="text" class="form-control" placeholder="Vorname" value="${address.christianName}">
            </div>
            <div class="col-xs-6">
                <label for="name">Nachname</label>
                <input id="name" name="name" type="text" class="form-control" placeholder="Nachname" value="${address.name}">
            </div>
        </div>
        <h2>Anschrift</h2>
        <div class="row">
            <div class="col-xs-8">
                <label for="street">Straße</label>
                <input id="street" name="street" type="text" class="form-control" placeholder="Straße" value="${address.street}">
            </div>
            <div class="col-xs-4">
                <label for="number">Hausnummer</label>
                <input id="number" name="number" type="number" class="form-control" placeholder="Hausnummer" value="${address.number}" min="1" step="1">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4">
                <label for="postcode">Postleitzahl</label>
                <input id="postcode" name="postcode" type="text" class="form-control" placeholder="Postleitzahl" value="${address.postcode}">
            </div>
            <div class="col-xs-8">
                <label for="city">Stadt</label>
                <input id="city" name="city" type="text" class="form-control" placeholder="Stadt" value="${address.city}">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <label for="country">Land</label>
                <input id="country" name="country" type="text" class="form-control" placeholder="Land" value="${address.country}">
            </div>
        </div>
        <h2>Kontakt</h2>
        <div class="row">
            <div class="col-xs-12">
                <label for="email">Email</label>
                <input id="email" name="email" type="email" class="form-control" placeholder="Email" value="${address.email}">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6">
                <label for="phone">Telefon</label>
                <input id="phone" name="phone" type="tel" class="form-control" placeholder="Telefon" value="${address.phone}">
            </div>
            <div class="col-xs-6">
                <label for="mobile">Mobil</label>
                <input id="mobile" name="mobile" type="tel" class="form-control" placeholder="Mobil" value="${address.mobile}">
            </div>
        </div>
        <h2>Geburtstag</h2>
        <div class="row">
            <div class="col-xs-12">
                <label for="birthday">Geburtstag</label>
                <input id="birthday" name="birthday" type="date" class="form-control" placeholder="Geburtstag" value="${address.birthday}">
            </div>
        </div>
        <hr/>
        <c:choose>
            <c:when test="${param.id != null}">
                <a href="/Address.jsp?id=${param.id}" class="btn btn-warning">Abbrechen</a>
            </c:when>
            <c:otherwise>
                <a href="/AddressList.jsp" class="btn btn-warning">Abbrechen</a>
            </c:otherwise>
        </c:choose>
        <button type="submit" class="btn btn-success pull-right">Speichern</button>
    </form>
  </jsp:body>
</t:layout>
