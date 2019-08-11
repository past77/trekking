
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<head>
    <%@include file="head.jsp" %>
</head>

<body>
<%@include file="main.jsp" %>
<table>
 <caption>History of food that have been eaten</caption>
    <thead>
    <tr>
    <th scope="col">
        <fmt:message key="client.name"/>
    </th>
    <th>
        <fmt:message key="food.food.name"/>
    </th>
    <th>
        <fmt:message key="food.date"/>
    </th>
    <th>
        <fmt:message key="amount"/>
    </th>
    </tr>
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
<div class="inlined">
<list >
    <c:forEach items="${links}" var="link_num">
        <a href='${requestScope[' javax.servlet.forward.request_uri']}?page=
        <c:out value="${link_num}"/>
        '>
        <li class="pagin" >
            <c:out value="${link_num}"/>
        </li>
        </a>
    </c:forEach>
</list>
</div>
<%@include file="footer.jsp" %>
