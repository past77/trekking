
<html>
<body>
<div class="menu">
<ul class = "ule">
<li>  <a href="/" class="lnk"><fmt:message key="main.page"/></a></li>
          <c:choose>
                      <c:when test="${client == null}">

                             <li> <a href="/login"><fmt:message key="login.login"/></a><li>
                            <li>  <a href="/registration"><fmt:message key="registration.page"/></a><li>
                      </c:when>
                  <c:when test="${client != null}">

                            <li>  <a href="/client_page"><fmt:message key="profile.page"/></a> </li>

                                 <div class = "logged">
                              <li>    <fmt:message key="header.logged"/> </li>
                                  <c:out value="${client.getName()} ${client.getRoleEnum()}"/>
                                  </div>
                                  </ul>
                           <li>  <a href="${pageContext.request.contextPath}/logout"><fmt:message key="login.logout"/></a></li>
                      </c:when>
                  </c:choose>
<ul>
</div>
</body>
</html>
