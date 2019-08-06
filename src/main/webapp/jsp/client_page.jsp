<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="/js/calcNorm.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<html>

<head>
<%@include file="head.jsp" %>
</head>

<body>
<%@include file="/jsp/main.jsp" %>
<%@include file="header.jsp" %>
<!-- Client Data -->
<div class="container" id="client-data">
    <div class="row">
        <div><img class="circular--square"
                src='<c:out value="${image}" default="/img/avatars/default.png" />'/></div>
        <div class="col-sm-5">
            <div class="row">
                <div class="col-sm-9">
                    <list class="personal_data">
                        <li><input id="client_id" name="id" type="hidden" value='<c:out value="${id}" />'></li>
                        <li><input disabled id="name"
                                   type="text" value='<fmt:message key="client.name" />:  <c:out value="${name}" />'/>
                        </li>
                        <li><input disabled id="age"
                                   type="text" value='<fmt:message key="client.age" />:  <c:out value="${age}" />'/>
                        </li>
                        <li><input disabled id="gender"
                                   type="hidden"
                                   value='<c:out value="${gender}"/>'/>
                        </li>
                        <li><input disabled id="gender_out"
                                   type="text"
                                   value='<fmt:message key="client.gender" />:  <fmt:message key="client.gender.${gender}" />'/>
                        </li>
                        <li><input disabled id="height"
                                   type="text"
                                   value='<fmt:message key="client.height" />:  <c:out value="${height}" />'/></li>
                        <li><input disabled id="weight"
                                   type="text"
                                   value='<fmt:message key="client.weight" />:  <c:out value="${weight}" />'/></li>
                        <li><input disabled id="lifeStyle"
                                   type="text"
                                   value='<fmt:message key="client.lifestyle" />:  <c:out value="${lifeStyle}" />'/>
                        </li>
                    </list>
                </div>
                <div class="col-sm-3">
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <a href="/custom_food">
                <fmt:message key="menu.custom_food"/>
            </a>

        </div>
    </div>
</div>

<!-- End Client Data -->
<!-- Add Food Form -->
<div class="container" id="add-food-form">
  <form class="addPlate" method="post" action="/add_to_plate">
        <div class="col-sm-4">
            <select id="food_selection" name="food_selection">
                <c:forEach items="${foodList}" var="food">
                    <option value="${food.id}">
                        <c:out value="${food.name}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-sm-4">
               <input type="submit" class="submit-button" value='<fmt:message key="food.add"/>'/>
            </form>
               <div class="col-sm-4">
                   <fmt:message key="food.amount"/>
                   <input id="food_amount" min="1" name="food_amount" type="number" value="1">
               </div>
        </div>
</div>

<!-- Client`s plate -->
<a name="calc"></a>
<div class="column">
    <div class="row">
        <div class="col-sm-3">
            <h3>
                <fmt:message key="food.your_plate"/>
            </h3>
        </div>
        <div class="col-sm-6"></div>
    </div>
</div>

<table class="plate_table">
    <thead>
    <td>
        <fmt:message key="food.name"/>
    </td>
    <td>
        <fmt:message key="food.calories"/>
    </td>
    <td>
        <fmt:message key="food.proteins"/>
    </td>
    <td>
        <fmt:message key="food.fats"/>
    </td>
    <td>
        <fmt:message key="food.carbohydrates"/>
    </td>
    <td>
        <fmt:message key="food.number"/>
    </td>
    <td>
        <fmt:message key="food.amount"/>
    </td>
    </thead>

    <tbody>
    <c:forEach items="${plate}" var="list" varStatus="it">
         <c:forEach items="${list}" var="item">
                <tr>
                    <td>
                        <div class="col-md-2">
                            <c:out value="${item.name}"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-md-2">
                            <c:out value="${item.calories}"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-md-2">
                            <c:out value="${item.protein}"/>
                        </div>
                    </td>
                    <td>
                        <div class="col-md-2">
                            <c:out value="${item.fat}"/>
                        </div>
                    </td>
                      <td>
                        <div class="col-md-2">
                             <c:out value="${item.carbohydrates}"/>
                         </div>
                      </td>
                       <td>
                         <div class="col-md-2">
                              <c:out value="${item.number}"/>
                         </div>
                       </td>
                         <td>
                           <div class="col-md-2">
                               <c:out value="${amount.get(it.count -1)}"/>
                           </div>
                        </td>
                </tr>
                </c:forEach>

            </c:forEach>
    </tbody>
</table>

<!-- End Client`s plate -->
</form>
<button class="btn btn-default" onclick="caculateNorm()">
    <fmt:message key="menu.calc"/>
</button>
<table id="deflection">
    <thead>
    <tr>
        <td>
            <fmt:message key="food.calories"/>
        </td>
        <td>
            <fmt:message key="food.proteins"/>
        </td>
        <td>
            <fmt:message key="food.fats"/>
        </td>
        <td>
            <fmt:message key="food.carbohydrates"/>
        </td>
    </tr>
    </thead>
    <tr id="def_value"></tr>
</table>

</body>
</html>