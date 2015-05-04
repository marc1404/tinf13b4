<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 30.04.2015
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="address" class="com.vornetran.marc.beans.Address" scope="request"></jsp:useBean>
<jsp:setProperty name="address" property="id" />
${address.read()}
<t:layout>
    <jsp:attribute name="title">${address.addressForm} ${address.christianName} ${address.name}</jsp:attribute>
    <jsp:body>
        <div class="container">
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
                    <strong>Geburtstag:</strong> ${address.birthday}
                </div>
            </div>
            <hr/>
            <a href="javascript:history.back()" class="btn btn-default">Zurück</a>
            <a href="" class="btn btn-primary">Bearbeiten</a>
            <button type="button" class="btn btn-danger">Löschen</button>
    </jsp:body>
</t:layout>
