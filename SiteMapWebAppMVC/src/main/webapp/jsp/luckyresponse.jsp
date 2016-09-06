<%-- 
    Document   : luckyresponse
    Created on : 3-Apr-2016, 11:50:40 AM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
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
           
                <div class="col-lg-4 well">
                    <form class="form-horizontal" action="LuckyController" method="POST">
                        <h4>Starting bet was: ${startBet}</h4><br/>
                        <h4>You are broke after: ${rolls} rolls(s).</h4><br/>
                        <h4>You should have quit after ${bestRoll} roll(s) when you had: ${bestBet}.</h4><br/><br/>

                        <a href ="LuckyController">
                            <button type ="button" class="btn btn-success">Get Lucky Again</button></a>
                    </form>
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
