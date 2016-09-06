<%-- 
    Document   : home
    Created on : 28-Mar-2016, 1:16:11 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role = "presentation">
                        <a href="${pageContext.request.contextPath}/home">home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/rest">Rest</a>
                    </li>
                    <li role ="presentation"  class="active">
                        <a href="${pageContext.request.contextPath}/displayDVDListNoAjax">
                            DVD Library (No Ajax)</a>
                    </li>

                </ul>
            </div>
        </div>
        <div class="container">
            <h1>DVD Library</h1>
            <a href="displayNewDVDFormNoAjax">Add a DVD</a>
            <hr/>

            <c:forEach var= "dvd" items="${dvdLibrary}">
                <s:url value="deleteDVDNoAjax" var="deleteDVD_url">
                    <s:param name ="dvdId" value = "${dvd.dvdId}"/>
                </s:url>
                <s:url value="displayEditDVDFormNoAjax" var="editDVD_url">
                    <s:param name="dvdId" value="${dvd.dvdId}"/>
                </s:url>

                Title: ${dvd.dvdTitle} |
                <a href="${deleteDVD_url}">Delete</a> |
                <a href="${editDVD_url}">Edit</a><br/>
                Director: ${dvd.directorsName}<br/>
                MPAA: ${dvd.mpaaRating}<br/>
                Studio: ${dvd.studio}<br/>
                Release Date: ${dvd.releaseDate}<br/>
                <hr/>
            </c:forEach>
        </div>
        <script src ="{$pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src ="{$pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
