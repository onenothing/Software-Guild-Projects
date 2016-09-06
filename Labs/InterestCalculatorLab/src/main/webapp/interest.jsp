<%-- 
    Document   : inters
    Created on : 26-Mar-2016, 9:00:26 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

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

                <div class="col-lg 4"></div>
                <div class="col-lg-4">
                    
                    <h1>$ Interest Calculator $</h1>
                    <br/>
                    <form class="form-horizontal" action="InterestServlet" method="POST">
                        <label>"What is the APR? (Enter as %) :</label>
                        <input type="number" name="percentageToCalc" class="form-control"/>
                        <br/>
                        <label>"What is the initial principal?:</label>
                        <input type="number" name="intitialPrincipal"class="form-control" />
                        <br/>
                        <label>"How many years??:</label>
                        <input type="number" name="periodToInvest" class="form-control"/>
                        <br/>
                        <label>"What type of compounding? (q/m/d/y):</label>
                        <input type="letter" name="typeOfCompounding" class="form-control"/>
                        <br/>
                        <button type ="submit" class="btn btn-success">Calculate</button>
                        
                    </form>
                </div>
            </div>
        
        </div>
</body>
</html>
