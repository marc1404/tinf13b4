<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 30.04.2015
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="addressList" class="com.vornetran.marc.beans.AddressList" scope="request"></jsp:useBean>
<t:layout>
    <jsp:attribute name="title">Address List</jsp:attribute>
  <jsp:body>
    <div class="container">
      <div class="page-header">
        <h1>Address List</h1>
      </div>
      <div class="list-group">
        <c:forEach items="${addressList.getList()}" var="address">
          <div class="row list-group-item">
            <div class="col-xs-6">
              <a href="/Address.jsp?id=${address.id}">
                <strong>${address.addressForm} ${address.christianName} ${address.name}</strong>
              </a><br>
              ${address.street} ${address.number}<br>
              ${address.postcode} ${address.city}<br>
              ${address.country}<br>
            </div>
            <div class="col-xs-6">
              <em>Email:</em> <a href="mailto:${address.email}">${address.email}</a><br>
              <em>Phone:</em> ${address.phone}<br>
              <em>Mobile:</em> ${address.mobile}<br>
              <em>Birthday:</em> ${address.birthday}<br>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </jsp:body>
</t:layout>
