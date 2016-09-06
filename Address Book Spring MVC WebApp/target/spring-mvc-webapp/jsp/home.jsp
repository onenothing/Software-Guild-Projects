
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role = "presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/rest">Rest</a>
                    </li>
                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/displayAddressListNoAjax">
                            Address Book (Sans Ajax)</a>
                    </li>
                </ul>
            </div>

            <!--#1: Start Changes
            Add a row to our container - this will hold the summary table and the new
            contact form.--> 
            <div class="row">
                <!--#2: Add a col to hold the summary table - have it take up half the row-->
                <div class="col-md-6">
                    <h2>My Addresses</h2>
                    <!--This holds the contact table now placed in AddressSummaryFragment.jsp-->
                    <%@include file="addressSummaryTableFragment.jsp" %>
                </div>
                <!-- start of add form -->
                <div class="col-md-6">
                    <h2>Add New Address</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-first-name" placeholder="First Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-last-name" placeholder="Last Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-address" class="col-md-4 control-label">Address:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-address" placeholder="Address" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-city" placeholder="City" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-state" class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-state" placeholder="State" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-zipcode" class="col-md-4 control-label">Zipcode:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="add-zipcode" placeholder="Zipcode" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-success">Create Address</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>             
        </div>
        <%@include file="detailsEditModalFragment.jsp" %>
        <div id="validationErrors" style="color: red"/>
        <!--Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/mockData.js"></script>
        <script src="${pageContext.request.contextPath}/js/addressList.js"></script>

    </body>
</html>
