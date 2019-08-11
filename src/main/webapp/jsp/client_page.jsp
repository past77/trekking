<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>

<html>

<head>
<%@include file="head.jsp" %>
</head>

<body>
<%@include file="main.jsp" %>

<!-- Client Data -->
<div class="container" id="client-data">
    <div class="row">
        <div><img class="circular--square"
                src='<c:out value="${image}" default="/img/avatars/default.png" />'/></div>
        <div class="col-sm-5">
                <div class="personal_data">
                    <list class="personal_data">
                        <li><input id="client_id" name="id" type="hidden" value='<c:out value="${id}" />'></li>
                        <div class = "pr_data"> <fmt:message key="client.name" />:  <c:out value="${name}"/>
                        </div>
                        <div class = "pr_data"> <fmt:message key="client.age" />:  <c:out value="${age}" />
                        </div>
                        <div class = "pr_data">
                                   <fmt:message key="client.gender" />:  <fmt:message key="client.gender.${gender}"/>
                        </div>
                        <div class = "pr_data">
                                  <fmt:message key="client.height" />:  <c:out value="${height}" /></li>
                         </div>
                        <div class = "pr_data">
                                   <fmt:message key="client.weight" />:  <c:out value="${weight}"/></li>
                          </div>
                        <div class = "pr_data">
                                  <fmt:message key="client.lifestyle" />:  <c:out value="${lifeStyle}"/>
                        </div>
                    </list>
                </div>
            </div>
    </div>
</div>

<div class="container2" id="add-food-form">
<h3> Add Food</h3>
  <form method="post" action="/add_to_plate">
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
<table class="plate_table">
<caption><fmt:message key="food.your_plate"/></caption>
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
   <form method="post" action="/norm">
        <input type="submit" class="submit-button" value='<fmt:message key="menu.calc"/>'/>
   </form>

<table class = "plate_table" id="deflection">
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
    <tbody>
                    <tr>
                        <td>
                            <div class="col-md-2">
                                <c:out value="${norma.get(0)}"/>
                            </div>
                        </td>
                        <td>
                            <div class="col-md-2">
                                <c:out value="${norma.get(1)}"/>
                            </div>
                        </td>
                        <td>
                            <div class="col-md-2">
                                <c:out value="${norma.get(2)}"/>
                            </div>
                        </td>
                        <td>
                            <div class="col-md-2">
                                <c:out value="${norma.get(3)}"/>
                            </div>
                        </td>
                    </tr>
</tbody>
</table>

</body>
</html>