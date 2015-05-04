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
<jsp:useBean id="addressList" class="com.vornetran.marc.beans.AddressList" scope="request"/>
<jsp:setProperty name="addressList" property="search"/>
<t:layout>
  <jsp:attribute name="title">Address List</jsp:attribute>
  <jsp:attribute name="js">
    <script src="js/addressList.js"></script>
  </jsp:attribute>
  <jsp:body>
    <div class="container">
      <div class="page-header">
        <h1>Address List</h1>
      </div>
      <form method="GET">
        <div class="input-group">
          <input name="search" type="search" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
            <button type="submit" class="btn btn-primary">
              <span class="glyphicon glyphicon-search"></span>
            </button>
          </span>
        </div>
      </form>
      <hr/>
      <div class="list-group">
        <c:forEach items="${addressList.getList()}" var="address">
          <div class="row list-group-item animated">
            <div class="col-xs-4">
              <strong>${address.addressForm} ${address.christianName} ${address.name}</strong><br>
              ${address.street} ${address.number}<br>
              ${address.postcode} ${address.city}<br>
              ${address.country}<br>
            </div>
            <div class="col-xs-4">
              <em>Email:</em> <a href="mailto:${address.email}">${address.email}</a><br>
              <em>Phone:</em> ${address.phone}<br>
              <em>Mobile:</em> ${address.mobile}<br>
              <em>Birthday:</em> ${address.birthday}<br>
            </div>
            <div class="col-xs-4">
              <div class="pull-right">
                <a href="/Address.jsp?id=${address.id}" class="btn btn-default btn-xs">Details</a><br>
                <br>
                <button type="button" class="btn btn-danger btn-xs" data-id="${address.id}" data-delete>Delete</button><br>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </jsp:body>
</t:layout>
