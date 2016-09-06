<%-- 
    Document   : bigTipper
    Created on : 27-Mar-2016, 2:23:43 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Tip Calculator Response</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg 4"></div>
                <div class="col-lg-4">
                    <form class="form-horizontal" action="TipCalculatorServlet" method="POST">
                        <h1>Your Total with tip:</h1>
                        <br/>
                        <h4>If your service costs $ ${param.costOfService} when tipping ${param.tipPercent}% you should:</h4>
                        <br/>
                        <h4>Tip: $ ${tip}</h4>
                        <br/>
                        <h4>Total: $ ${param.costOfService+tip}</h4>
                        <br/>

                        <a href ="TipCalculatorServlet">
                            <button type ="button" class="btn btn-success">Calculate Another Tip</button></a>
                    </form>
                </div>
            </div>
        </div>
        <script src ="{$pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src ="{$pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
