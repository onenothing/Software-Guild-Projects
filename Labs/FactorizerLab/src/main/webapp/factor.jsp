<%-- 
    Document   : factor
    Created on : 25-Mar-2016, 2:20:53 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <title>Factorizer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
   
    </br>        </br>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <h1>* Factorizor *</h1>
                <form class="form-horizontal" action="FactorsServlet" method="POST">
                    <h4>Please enter a number to factor:</h4>
                    <input type="number" name="numberToFactor" class="form-control"/>
                    <br/>
                    <button type="submit" class="btn btn-success">Factor</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
