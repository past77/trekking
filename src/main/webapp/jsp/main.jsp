
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
                    <c:when test="${client.getRoleEnum() == 'C'}">
                    <li>  <a href="/client_page"><fmt:message key="profile.page"/></a> </li>
                           <li> <a href="/custom_food">
                                <fmt:message key="menu.custom_food"/>
                          </a></li>
                          <li> <a><fmt:message key="header.logged"/> <c:out value="${client.getName()}"/> </a>  </li>
                          <li>  <a href="${pageContext.request.contextPath}/logout"><fmt:message key="login.logout"/></a></li>
                      </c:when>
                        <c:when test="${client.getRoleEnum() != 'C'}">
                        <li> <a href="/stat_page">
                                                        <fmt:message key="menu.table"/>
                                                  </a></li>
                          <li>  <a href="${pageContext.request.contextPath}/logout"><fmt:message key="login.logout"/></a></li
                        </c:when>


                  </c:choose>

 <form method="get">
                 <li><a href=""><fmt:message key="language"/></a>
                     <ul>
                           <li><a href="?language=en_US">En</a></li>
                           <li><a href="?language=uk_UA">Ua</a></li>
                           <li><a href="?language=ru_RU">Ru</a></li>
                      </ul>
                 </li>
        </form>
         </ul>
</div>
</body>
</html>
