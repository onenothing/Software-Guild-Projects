<%-- 
    Document   : index
    Created on : 27-Mar-2016, 1:21:18 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg 4"></div>
                <div class="col-lg-4">

                    <form class="form-horizontal" action ="TipCalculatorServlet" method="post">
                        <h1>$ Tip Calculator $</h1>
                        <h4>Hello! Please use this calculator to figure out how much your tip for services should be.</h4>

                        <h4>Please enter amount of services rendered:</h4>
                        <input type="number" step=".01" name="costOfService" class="form-control"/>
                        <br/><br/>
                        <h4>Please enter the percentage amount you would like to tip (whole numbers only please):</h4>
                        <input type="input" name="tipPercent"/>
                        <br/><br/>
                        <button type ="submit" class="btn btn-success">Calculate Tip</button>

                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
