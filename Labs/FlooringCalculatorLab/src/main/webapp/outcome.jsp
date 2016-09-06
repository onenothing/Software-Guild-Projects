<%-- 
    Document   : outcome
    Created on : 27-Mar-2016, 6:15:16 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Response</title>
    </head>
    <body>
        <div class="container-fluid">

            <div class="row">

                
                <div class="col-lg-4">

                    <h1>Flooring Order Estimate</h1>
                    <form class="form-horizontal" action="FlooringCalculatorServlet" method="POST">
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
                        <a href ="FlooringCalculatorServlet">
                            <button type="button" class="btn btn-success">Calculate Again</button></a>


                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
