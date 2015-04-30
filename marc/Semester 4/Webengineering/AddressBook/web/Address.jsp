<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 30.04.2015
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="address" class="com.vornetran.marc.beans.Address" scope="request"></jsp:useBean>
<jsp:setProperty name="id" property="id" />
${address.read()}
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Address</title>
    </head>
    <body>
        
    </body>
</html>
