<%-- 
    Document   : newContactFormNoAjax
    Created on : 29-Mar-2016, 10:24:05 AM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
        </div>
        <div class="container">
            <h1>Edit Address Form</h1>
            <a href="displayAddressListNoAjax">Address List No Ajax</a>
            <hr/>
            <sf:form class="form-horizontal" modelAttribute="address"

                     role="form"
                     action="editAddressNoAjax"
                     method="POST">
                <div class="form-group">
                    <label for="add-first-name" class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-first-name" path="firstName" placeholder="First Name"/>
                        <sf:errors path="firstName" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-last-name" class="col-md-4 control-label">Last Name:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-first-name" path="lastName" placeholder="Last Name"/>
                        <sf:errors path="lastName" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-address" class="col-md-4 control-label">Address</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-address" path="address" placeholder="Address"/>
                        <sf:errors path="address" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-city" class="col-md-4 control-label">City:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-city" path="city" placeholder="City"/>
                        <sf:errors path="city" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-state" path="state" placeholder="State"/>
                        <sf:errors path="state" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-zipCode" class="col-md-4 control-label">Zipcode</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-zipCode" path="zipCode" placeholder="Zipcode"/>
                        <sf:errors type="zipCode" cssClass="text-danger"></sf:errors>
                        <sf:hidden path="addressId"/>
                    </div>
                </div>
                <div class ="form-group">
                    <div class ="col-md-offset-4 col-md-8">
                        <button type="submit" id="edit-button" class="btn btn-default">Edit New Address</button>
                    </div>
                </div>

            </sf:form>
        </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
