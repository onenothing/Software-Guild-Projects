<%-- 
    Document   : fcresponse
    Created on : 3-Apr-2016, 4:36:53 PM
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
        <title>Flooring Calculator</title>
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
                        <a href="${pageContext.request.contextPath}/InterestCalcController">Interest Calculator</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/FlooringCalcController">Flooring Calculator</a>
                    </li>

                </ul>
            </div>

            <div>
                <div class="col-lg-6 well">
                    <h1>Flooring Order Estimate</h1>
                    <form class="form-horizontal" action="FlooringCalcController" method="POST">
                        <h1>Flooring Order Estimate</h1>
                        For a ${param.width}' by ${param.length}' room, with a material cost of * $ ${param.costSqFt}.00 * per square ft:
                        <br/>
                        <ul>
                            <h5>
                                Your materials cost to install this floor will be: ${newMatCost}. 
                            </h5>
                            <br/>
                            <h5>
                                Your labor cost for installing the floor in this room will be: $ ${newLaborCost}.
                            </h5>
                            <br/>
                            <h5>
                                Your total cost to complete the job will be $ ${newTotal} and the job will take ${totalTime} hours to complete.
                            </h5>
                        </ul>
                        <a href ="FlooringCalcController">
                            <button type="button" class="btn btn-success">Calculate Again</button></a>

                    </form>
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
