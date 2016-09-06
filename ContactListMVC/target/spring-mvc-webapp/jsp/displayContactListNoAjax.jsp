<%-- 
    Document   : home
    Created on : 28-Mar-2016, 1:16:11 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Company Contacts</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/mainAjaxPage">Contact List (Ajax)</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">
                            Contact List (No Ajax)
                        </a>
                    </li>
                    <!-- #1 - Logout link -->
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                    </li> 
                </ul>
            </div>
        </div>
        <div class="container">
            <h1>Company Contacts</h1>
            <!-- #2 - Personalized welcome message --> 
            Hello <sec:authentication property="principal.username" />!<br/> 
            <!-- #3 - Only render this link if user has admin role -->
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="displayNewContactFormNoAjax">Add a Contact</a><br/>
            </sec:authorize>

            <hr/>

            <c:forEach var= "contact" items="${contactList}">
                <s:url value="deleteContactNoAjax" var="deleteContact_url">
                    <s:param name ="contactId" value = "${contact.contactId}"/>
                </s:url>
                <s:url value="displayEditContactFormNoAjax" var="editContact_url">
                    <s:param name="contactId" value="${contact.contactId}"/>
                </s:url>

                Name: ${contact.firstName} ${contact.lastName} |
                <a href="${deleteContact_url}">Delete</a> |
                <a href="${editContact_url}">Edit</a><br/>
                Phone: ${contact.phone}<br/>
                Email: ${contact.email}<br/>
                <hr/>
            </c:forEach>
        </div>
        <script src ="{$pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src ="{$pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
