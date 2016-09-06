<%-- 
    Document   : Response
    Created on : 24-Mar-2016, 6:39:12 PM
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
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
            <div class="col-lg-4 well">
                <h4>Starting bet was: ${startBet}</h4><br/>
                <h4>You are broke after: ${rolls} rolls(s).</h4><br/>
                <h4>You should have quit after ${bestRoll} roll(s) when you had: ${bestBet}.</h4><br/><br/>
           
      
                    <a class="btn btn-success" href="Lucky7sServlet">Would you like to play again?</a>
                </div>
            </div>
        </div>
    </body>
</html>
