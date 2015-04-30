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
          <a href="/Address.jsp?id=${address.id}" class="list-group-item">
            <address>
              <strong>${address.christianName} ${address.name}</strong><br>
              795 Folsom Ave, Suite 600<br>
              San Francisco, CA 94107<br>
              <abbr title="Phone">P:</abbr> (123) 456-7890
            </address>
          </a>
        </c:forEach>
      </div>
    </div>
  </jsp:body>
</t:layout>
