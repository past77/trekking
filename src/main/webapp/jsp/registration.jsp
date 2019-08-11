<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <%@include file="head.jsp" %>
</head>

<body>
<%@include file="main.jsp" %>
<form class="register" method="POST" action="/registration" autocomplete="on">
    <div>
        <span><i aria-hidden="true"></i><fmt:message key="client.name"/> </span>
        <input type="text"  name="client_name"  required="required">
    </div>
    <div>
        <span><i class="forminput"  aria-hidden="true"></i><fmt:message key="login.password"/> </span>
        <input type="password"  name="client_pas" placeholder="********" required="required">
    </div>


    <div>
        <span><i class="forminput" aria-hidden="true"></i><fmt:message key="birth_date"/> </span>
        <input type="date" placeholder="<fmt:message key="birth_date"/>" name="birth_date"
                required="required">
    </div>
    <div>
        <span><i class="forminput"  aria-hidden="true"></i><fmt:message key="client.gender"/> </span>
        <select name="client.gender" required=required>
                                   <option value="M" ${client.gender == 'M' ? 'selected' : ''}> <fmt:message key="client.gender.male"></fmt:message></option>
                                   <option value="F" ${client.gender == 'F' ? 'selected' : ''}><fmt:message key="client.gender.female"></fmt:message></option>
        </select>
    </div>

    <div>
        <span><i class="forminput"  aria-hidden="true"></i><fmt:message key="client.height"/></span>
        <input type="text"  name="client_height" value="${client_height}" required="required">
    </div>

    <div>
        <span><i class="forminput"  aria-hidden="true"></i><fmt:message key="client.weight"/></span>
        <input type="text"  name="client_weight" value="${client_weight}" required="required">
    </div>

       <div>
        <span><i class="forminput"  aria-hidden="true"></i><fmt:message key="client.lifestyle"/></span>
       <select name="client_life_style" required=required>
                           <option value="L" ${client_life_style == 'L' ? 'selected' : ''}> <fmt:message key="Lite"></fmt:message></option>
                           <option value="A" ${client_life_style == 'A' ? 'selected' : ''}><fmt:message key="Average"></fmt:message></option>
                           <option value="H" ${client_life_style == 'H' ? 'selected' : ''}><fmt:message key="Hard"></fmt:message></option>
                           <option value="E" ${client_life_style == 'E' ? 'selected' : ''}><fmt:message key="Extreme"></fmt:message></option>
                       </select>
        </div>

 <div>
    <input class="submit-button" type="submit" value=<fmt:message key="sign.up"/>
    </div>
</form>

    <c:choose>
    <c:when test="${success != null}">
        <fmt:message key="message.complete"/>
    </c:when>
     </c:choose>
<%@include file="footer.jsp" %>
</body>
</html>