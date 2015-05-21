<%--
  Created by IntelliJ IDEA.
  User: Marc
  Date: 21.05.2015
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="counter1" class="com.vornetran.marc.beans.Counter" scope="application"></jsp:useBean>
<jsp:useBean id="counter2" class="com.vornetran.marc.beans.Counter" scope="application"></jsp:useBean>
${counter1.setOther(counter2)}
${counter1.increaseBoth()}
<html>
    <head>
        <title>Deadlock 1</title>
    </head>
    <body>
        <h1>${counter1.counter}</h1>
        <h1>${counter2.counter}</h1>
    </body>
</html>
