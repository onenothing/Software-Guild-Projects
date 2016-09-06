<%-- 
    Document   : flooringcalc
    Created on : 3-Apr-2016, 4:22:18 PM
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

        <title>Flooring Calculator</title>
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

                    <div class="col-lg-5 well">

                        <form class="form-horizontal" action ="FlooringCalcController" method="post">
                            <h1>Flooring Calculator</h1>
                            <h4>Welcome to the Flooring Calculator App!!</h4>
                            <h4>Use this calculator to figure out how much your flooring project will cost.</h4>

                            <h4>Please enter the length of the floor you want to cover:</h4>
                            <input type="numbers" name="length" class="form-control"/>
                            <br/><br/>
                            <h4>Please enter the width of the floor you want to cover:</h4>
                            <input type="numbers" name="width" class="form-control"/>
                            <br/><br/>
                            <h4>Please enter the cost per square foot of the floor you want to cover:</h4>
                            <input type="numbers" name="costSqFt" class="form-control"/>
                            <br/>
                            <button type ="submit" class="btn btn-success">Calculate Total</button>
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
                    </body>
                    </html>
