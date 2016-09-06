<%-- 
    Document   : interestcalc
    Created on : 3-Apr-2016, 3:12:49 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>
    <body>

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

                    <div class="col-lg-5 well">

                        <form class="form-horizontal" action ="InterestCalcController" method="POST">
                            <h1>$ Interest Calculator $</h1>
                            <h4>"What is the APR? (Enter as %) :</h4>
                            <input type="number" name="percentageToCalc" class="form-control"/>
                            <br/>
                            <h4>"What is the initial principal?:</h4>
                            <input type="number" name="intitialPrincipal"class="form-control" />
                            <br/>
                            <h4>"How many years??:</h4>
                            <input type="number" name="periodToInvest" class="form-control"/>
                            <br/>
                            <h4>"What type of compounding? (q/m/d/y):</h4>
                            <input type="letter" name="typeOfCompounding" class="form-control"/>
                            <br/>
                            <button type ="submit" class="btn btn-success">Calculate</button>

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
