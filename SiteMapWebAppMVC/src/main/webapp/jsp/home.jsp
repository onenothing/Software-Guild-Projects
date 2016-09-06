<%-- 
    Document   : home
    Created on : 1-Apr-2016, 12:44:41 AM
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
        <title>Site Lab MVC</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>

        <div class="container">

            <div class="page-header">
                <h2 class="text-center">Software Craftsmanship Guild Java Cohort</h2>
                <h3 class="text-center">MVC Site Lab</h3>

            </div>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/LuckyController">Lucky Sevens</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/TipCalcController">Tip Caluclator</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/FactorizorController">Factorizer</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/InterestCalcController">Interest Calculator</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/FlooringCalcController">Flooring Calculator</a>
                    </li>

                </ul>
            </div>
            <div>
                <div class="well">
                    <h2>Game/ Calculator Page</h2>
                    <h4>Would you like to play a game, or do some very useful calculations?</h4>
                </div>
            </div>
            <br/>
            <br/>
            <br/>
            <br/>
            <footer class="footer">
                <div class="container text-center">
                    <h5 class="text-muted">
                        Created By: Adam Coate 2016<br/>
                        Powered by Java and Bootstrap

                    </h5>
                </div>
            </footer>
        </div>
    </div>
    <script src ="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src ="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
