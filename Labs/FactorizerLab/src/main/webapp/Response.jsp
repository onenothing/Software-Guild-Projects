<%-- 
    Document   : Response
    Created on : 25-Mar-2016, 2:24:35 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factors</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg 4"></div>
                <div class="col-lg-4">
                    <form class="form-horizontal" action="FactorsServlet" method="POST">
                        <h1>I've Factored the Number</h1>
                        <br/>
                        <h4>The Factors are: ${factors}</h4>
                        <br/>
                        <h4>The number is perfect: ${perfect}</h4><br/>
                        <h4>The number is prime: ${prime}</h4>
                        <a href ="FactorsServlet">
                            <button type="button" class="btn btn-success">Factor Another Number</button></a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
