<%-- 
    Document   : WeatherAPI
    Created on : 8-Apr-2016, 10:13:09 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <title>WeatherAPI</title>
    </head>
    <body>
        <div class="container">

            <h2>Please enter the zip of the state you would like to find the weather for:</h2>


            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="add-zip-code" class="col-md-4 control-label">
                        Zip Code:
                    </label>

                    <div class="col-md-4">
                        <input type="text"
                               class="form-control"
                               id="add-zip-code"
                               placeholder="Zip Code"/>
                    </div>
                    <div class="col-md-4">
                        <button type="submit"
                                id="zip-button"
                                class="btn btn-primary">
                            Enter Zip
                        </button>
                        
                        
                    </div>
                </div>
        </div>
    </form>
            <table>
                <tbody id="contentRows"></tbody>

            </table>







    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/weather.js"></script>
</body>
</html>
