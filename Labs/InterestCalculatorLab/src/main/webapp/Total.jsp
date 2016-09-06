<%-- 
    Document   : Total
    Created on : 26-Mar-2016, 8:39:18 PM
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

        <title>Interest Calculator</title>
    </head>
    <body>
        <div class="container-fluid">

            <div class="row">

                
                <div class="col-lg-4">

                    <h1>Interest Calculator!!</h1>
                    <form class="form-horizontal" action="InterestServlet" method="POST">

                        <c:forEach var="ic" items="${interestYearsCalcs}">
                            Year ${ic.year}:<br/> Total: ${ic.total}<br/> Interest Earned: ${ic.interestEarned}<br/>
                        </c:forEach>
                        <c:if test="not empty ${interestCalcError}">ERROR: ${interestCalcError}</c:if>
                        <br/>
                        <a href ="InterestServlet">
                            <button type ="button" class="btn btn-success">Calculate Again</button></a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
