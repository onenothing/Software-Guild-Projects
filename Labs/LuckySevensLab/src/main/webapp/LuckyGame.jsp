<%-- 
    Document   : LuckyGame
    Created on : 24-Mar-2016, 6:38:51 PM
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
        <title>Lucky Sevens</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg 4">
                    <div class="col-lg-4">
                        <h1>Please Enter Your Starting Bet:</h1>
                        <form class="form-horizontal" action='Lucky7sServlet' method='POST'>
                            <input class="form-control" type ="text" name="myRolls"/><br/>
                            <input type="submit" class ="btn btn-success" value="Roll Dice"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
