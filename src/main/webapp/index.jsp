<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="/jsp/head.jsp" %>
</head>
<body>
<%@include file="/jsp/header.jsp" %>
<%@include file="/jsp/main.jsp" %>
<div class="row ">
    <p class="welcome-title"><fmt:message key="greetings"/></p>
</div>
<%@include file="/jsp/footer.jsp" %>

</body>
</html>