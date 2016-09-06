<%-- 
    Document   : factorizor
    Created on : 3-Apr-2016, 2:04:29 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <title>Factorizor</title>
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
                        <form class="form-horizontal" action="FactorizorController" method="POST">
                            <h1># Factorizor #</h1>
                            <h4>Please enter a number to factor:</h4>
                            <input type="number" name="numberToFactor" class="form-control"/>
                            <br/>
                            <button type="submit" class="btn btn-success">Factor</button>
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
