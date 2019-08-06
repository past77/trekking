
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<head>
    <%@include file="head.jsp" %>
</head>

<body>
<%@include file="header.jsp" %>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Log Out">
</form>

<table>
    <thead>
    <td>
        <fmt:message key="client.name"/>
    </td>
    <td>
        <fmt:message key="food.food.name"/>
    </td>
    <td>
        <fmt:message key="food.date"/>
    </td>
    <td>
        <fmt:message key="amount"/>
    </td>
    </thead>
    <c:forEach items="${clientStat}" var="record">
        <tr>
            <td style="padding-right: 4px;">
                <c:out value="${record.name}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.nameFood}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.date}"/>
            </td>
            <td style="padding-right: 4px;">
                <c:out value="${record.amount}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<list>
    <c:forEach items="${links}" var="link_num">
        <a href='${requestScope[' javax.servlet.forward.request_uri']}?page=
        <c:out value="${link_num}"/>
        '>
        <li class="inlined">
            <c:out value="${link_num}"/>
        </li>
        </a>
    </c:forEach>
</list>

<%@include file="footer.jsp" %>