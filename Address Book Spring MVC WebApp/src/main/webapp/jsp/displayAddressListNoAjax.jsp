<%-- 
    Document   : home
    Created on : 28-Mar-2016, 1:16:11 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- #1 - Directive for Spring Form tag libraries -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon if you want to use, or place image to use below -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role = "presentation">
                        <a href="${pageContext.request.contextPath}/home">home</a>
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
                    <li role ="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayAddressListNoAjax">
                            Address Book (No Ajax)
                        </a>
                    </li>

                </ul>
            </div>
        </div>
        <div class="container">
            <h1>Address Book</h1>
            <!-- #1 - Link to addAddressForm -->
            <a href="${pageContext.request.contextPath}/displayNewAddressFormNoAjax">Add an Address</a>
            <hr/>

            <!-- #2 - Iterate over addressList: forEach address in addressList, do something -->
            <c:forEach var= "address" items="${addressBook}">
                <!-- #3 - Build custom delete URL for each address. Use the id of the address -->
                <!-- to specify the address to delete or update -->
                <s:url value="deleteAddressNoAjax" var="deleteAddress_url">
                    <s:param name ="addressId" value = "${address.addressId}"/>
                </s:url>
                <!-- Build custom edit URL for each address -->
                <s:url value="displayEditAddressFormNoAjax" var="editAddress_url">
                    <s:param name="addressId" value="${address.addressId}"/>
                </s:url>

                Name: ${address.firstName} ${address.lastName} |
                <a href="${deleteAddress_url}">Delete</a> |
                <a href="${editAddress_url}">Edit</a><br/>
                Address: ${address.address}<br/>
                City: ${address.city}<br/>
                State ${address.state}<br/>
                Zipcode: ${address.zipCode}<br/>
                <hr/>
            </c:forEach>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src ="{$pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src ="{$pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
