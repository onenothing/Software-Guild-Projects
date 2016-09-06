<%-- 
    Document   : OpenWeather2
    Created on : 9-Apr-2016, 5:32:11 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Open Weather API</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div id="UserArea">
            <div id="stateWrapper">
                <input type="text" id="cityInput" placeholder="Enter a State"/>
            </div>
            <br/>
            <div id="countryWrapper">
                <input type="text" id="countryInput" placeholder="Enter a Country"/>
            </div>
            <br/>
            <div id="buttonArea">
                <input type="submit" id="submitWeather"/>
            </div>
        </div>
        <!- USED TO SHOW RESULT -->
        <div id="WeatherWrapper">
        </div>
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/weather.js"></script>
    </body>
</html>
