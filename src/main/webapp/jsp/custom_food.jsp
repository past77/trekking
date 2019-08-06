<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>

<body>
<%@include file="header.jsp" %>
<h3>
    <fmt:message key="menu.custom_food"/>
</h3>

<form action="/custom_food" method="post">
    <list>
        <li><input name="food_name" required type="text">
            <fmt:message key="food.name"/>
            <label for="food_name"></label></li>
        <li><input name="food_number" required type="number">
            <fmt:message key="food.number"/>
            <label for="food_number"></label></li>
        <li><input name="food_calories" type="text">
            <fmt:message key="food.calories"/>
            <label for="food_calories"></label></li>
        <li><input name="food_proteins" type="text">
            <fmt:message key="food.proteins"/>
            <label for="food_proteins"></label></li>
        <li><input name="food_fats" type="text">
            <fmt:message key="food.fats"/>
            <label for="food_fats"></label></li>
        <li><input name="food_carbohydrates" type="text">
            <fmt:message key="food.carbohydrates"/>
            <label for="food_carbohydrates"></label></li>
    </list>
    <input type="submit" value='<fmt:message key="food.add" />'/>
</form>
       <a href="/client_page">
                    <fmt:message key="end.work"/>
                </a>
<%@include file="footer.jsp" %>
</body>
</html>