<%-- 
    Document   : tipcalcresponse
    Created on : 1-Apr-2016, 2:08:46 AM
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
        <title>Tip Calculator</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
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
                        <a href="${pageContext.request.contextPath}/InterestController">Interest Calculator</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/FlooringCalcController">Flooring Calculator</a>
                    </li>

                </ul>
            </div>

            <div>
                <div class="col-lg-6 well">
                    <form class="form-horizontal" action="TipCalculatorServlet" method="POST">
                        <h1>Your Total with tip:</h1>
                        <br/>
                        <h4>If your service costs $ ${param.costOfService} when tipping ${param.tipPercent}% you should:</h4>
                        <br/>
                        <h4>Tip: $ ${tip}</h4>
                        <br/>
                        <h4>Total: $ ${param.costOfService+tip}</h4>
                        <br/>

                        <a href ="TipCalcController">
                            <button type ="button" class="btn btn-success">Calculate Another Tip</button></a>
                    </form>
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
