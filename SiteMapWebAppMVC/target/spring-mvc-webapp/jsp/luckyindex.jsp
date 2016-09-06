<%-- 
    Document   : luckyindex
    Created on : 3-Apr-2016, 11:17:50 AM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <title>Lucky Sevens</title>
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
            <div class="container-fluid">
                <div class="row">
                    <!--<div class="col-lg 4">-->
                    <div class="col-lg-4">
                        <div class="well">
                            <form class="form-horizontal" action='LuckyController' method='POST'>
                                <h1>$ Lucky Sevens $</h1>
                                <h4>Please enter the dollar amount you would like to gamble:</h4>
                                <input class="form-control" type ="number" name="myRolls"/><br/>
                                <input type="submit" class ="btn btn-success" value="Roll Dice"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <footer class="footer">
            <div class="container text-center">
                <h5 class="text-muted">
                    Created By: Adam Coate 2016<br/>
                    Powered by Java and Bootstrap
                    <script src ="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
                    <script src ="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

                    </body>
                    </html>
