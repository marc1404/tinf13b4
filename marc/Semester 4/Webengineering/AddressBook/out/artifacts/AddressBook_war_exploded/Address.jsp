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
    <jsp:attribute name="title">
        ${address.christianName} ${address.name}
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="page-header">
                <h1>${address.christianName} ${address.name}</h1>
            </div>
        </div>
    </jsp:body>
</t:layout>
