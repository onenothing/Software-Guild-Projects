<%-- 
    Document   : tipcalc
    Created on : 1-Apr-2016, 1:22:03 AM
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

        <title>Tip Calculator</title>
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

                    <div class="col-lg-4 well">

                        <form class="form-horizontal" action ="TipCalcController" method="POST">
                            <h1>$ Tip Calculator $</h1>
                            <h4>Hello! Please use this calculator to figure out how much your tip for services should be.</h4>

                            <h4>Please enter the total amount of your bill:</h4>
                            <input type="number" step=".01" name="costOfService" class="form-control"/>
                            <br/><br/>
                            <h4>Please enter the percentage amount you would like to tip (whole numbers only please):</h4>
                            <input type="number" name="tipPercent" class="form-control"/>
                            <br/><br/>
                            <button type ="submit" class="btn btn-success">Calculate Tip</button>

                        </form>
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
