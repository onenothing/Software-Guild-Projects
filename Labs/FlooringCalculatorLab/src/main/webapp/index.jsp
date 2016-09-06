<%-- 
    Document   : index
    Created on : 27-Mar-2016, 6:14:15 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
    <center>
        <div class="container-fluid">

            <div class="row">

                
                    <div class="col-lg-6">
                        <!--<form class="form-horizontal" action="FlooringCalculatorServlet" method="POST">-->

                        <form class="form-horizontal" action ="FlooringCalculatorServlet" method="post">
                            <h1>Flooring Calculator</h1>
                            <h4>Welcome to the Flooring Calculator App!!</h4>
                            <h4>Hello! You can use this calculator to figure out how much your flooring project will cost.</h4>

                            <h4>Please enter the length of the floor you want to cover:</h4>
                            <input type="numbers" name="length" class="form-control"/>
                            <br/><br/>
                            <h4>Please enter the width of the floor you want to cover:</h4>
                            <input type="numbers" name="width" class="form-control"/>
                            <br/><br/>
                            <h4>Please enter the cost per square foot of the floor you want to cover:</h4>
                            <input type="numbers" name="costSqFt" class="form-control"/>
                            <br/>
                            <button type ="submit" class="btn btn-success">Calculate</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </center>

</body>
</html>
