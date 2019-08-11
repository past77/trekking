<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language :
pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="la"/>

<link rel="stylesheet" type="text/css" href="/resources/css/style9.css">
<title><fmt:message key="trekking"/></title>