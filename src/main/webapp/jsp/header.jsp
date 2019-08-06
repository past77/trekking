<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="menu">
    <div class="row">
    <ul class = "ule">
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