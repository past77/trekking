<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>

<body>
<%@include file="/jsp/main.jsp" %>
<%@include file="header.jsp" %>

<form class="register" method="POST" action="/login" autocomplete="on">
    <span class="text-primary"><i class="forminput" aria-hidden="true"></i><fmt:message key="login.page"/> </span>
        <input name="userName" placeholder='<fmt:message key="registration.name"/>' type="text">
    <br>
    <span class="text-primary"><i class="forminput" aria-hidden="true"></i><fmt:message key="login.password"/> </span>
       <input name="password" placeholder='<fmt:message key="login.password"/>' type="password">
    <br>
    <div >
    <input class="submit-button" type="submit" value=<fmt:message key="login.login"/>
    </div>
</form>
<%@include file="footer.jsp" %>
</body>
</html>
