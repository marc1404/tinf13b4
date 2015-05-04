<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 30.04.2015
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="layout" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="js" fragment="true" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            <jsp:invoke fragment="title"/>
        </title>
        <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.4/yeti/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/0.5.0/sweet-alert.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:doBody/>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/0.5.0/sweet-alert.min.js"></script>
        <jsp:invoke fragment="js"/>
    </body>
</html>