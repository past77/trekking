<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>

<body>
<div class="custom_food">
<h3>
    <fmt:message key="menu.custom_food"/>
</h3>
<form action="/custom_food" method="post">
   <table align="center">
    <tr>
          <div class = "pr_data">
          <fmt:message key="food.name"/>
          <input name="food_name" required type="text">
            <label for="food_name"></label></div>
         <div class = "pr_data">
          <fmt:message key="food.number"/>
          <input name="food_number" required type="number">
            <label for="food_number"></label></div>
          <div class = "pr_data"><fmt:message key="food.calories"/>
          <input name="food_calories" type="text">
            <label for="food_calories"></label></div>
          <div class = "pr_data">
          <fmt:message key="food.proteins"/>
          <input name="food_proteins" type="text">
            <label for="food_proteins"></label></div>
          <div class = "pr_data">
           <fmt:message key="food.fats"/>
           <input name="food_fats" type="text">
          <label for="food_fats"></label></div>
          <div class = "pr_data">
          <fmt:message key="food.carbohydrates"/>
          <input name="food_carbohydrates" type="text">
            <label for="food_carbohydrates"></label></div>
  </table>
    <input type="submit" class="sub-btn" value='<fmt:message key="food.add" />'/>
</form>
       <a href="/">
                    <fmt:message key="end.work"/>
        </a>
</div>

<%@include file="footer.jsp" %>
</body>
</html>