<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 30.04.2015
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="address" class="com.vornetran.marc.beans.Address" scope="request"></jsp:useBean>
${address.parseId(param.id)}
${address.read()}
<t:layout>
    <jsp:attribute name="title">
        ${address.addressForm} ${address.christianName} ${address.name}
    </jsp:attribute>
    <jsp:attribute name="js">
        <script src="js/delete.js"></script>
    </jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${address.exists()}">
                <div class="page-header">
                    <h1>${address.addressForm} ${address.christianName} ${address.name}</h1>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <strong>Anschrift</strong><br>
                            ${address.street} ${address.number}<br>
                            ${address.postcode} ${address.city}<br>
                            ${address.country}
                    </div>
                    <div class="col-xs-6">
                        <strong>Email:</strong> <a href="mailto:${address.email}">${address.email}</a><br>
                        <strong>Telefon:</strong> ${address.phone}<br>
                        <strong>Mobil:</strong> ${address.mobile}<br>
                        <strong>Geburtstag:</strong> ${address.displayBirthday()}
                    </div>
                </div>
                <hr/>
                <a href="/AddressList.jsp" class="btn btn-default">Zurück</a>
                <a href="/AddressForm.jsp?id=${param.id}" class="btn btn-primary">Bearbeiten</a>
                <button type="button" class="btn btn-danger pull-right" data-id="${address.id}" data-delete data-redirect="/AddressList.jsp">Löschen</button>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-danger">
                    <h5 style="margin: 0">
                        <strong>Hoppla!</strong> Diese Adresse existiert nicht.
                        <a href="/AddressList.jsp" class="alert-link">Zurück</a>
                    </h5>
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:layout>
