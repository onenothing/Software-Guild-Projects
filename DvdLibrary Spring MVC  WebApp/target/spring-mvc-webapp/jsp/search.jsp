<%-- 
    Document   : home
    Created on : 28-Mar-2016, 1:16:11 PM
    Author     : Adam Coate <adamcoate1@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dvd Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Dvd Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role = "presentation">
                        <a href="${pageContext.request.contextPath}/home">home</a>
                    </li>
                    <li role="presentation"  class="active">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/rest">Rest</a>
                    </li>
                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/displayDVDListNoAjax">
                            DVD Library (No Ajax)</a>
                    </li>

                </ul>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2>My Dvds</h2>
                    <%@include file="dvdSummaryTableFragment.jsp" %>
                </div>
                <!-- start of search form -->
                <div class="col-md-6">
                    <h2>Search</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-dvd-title" class="col-md-4 control-label">Dvd Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-dvd-title" placeholder="Dvd Title" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-directors-name" class="col-md-4 control-label">Director's Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-directors-name" placeholder="Director's Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-mpaaRating" class="col-md-4 control-label">Mpaa Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-mpaaRating" placeholder="Mpaa Rating" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-studio" placeholder="Studio" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-releaseDate" class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-releaseDate" placeholder="Release Date" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="search-button"
                                        class="btn btn-success">Search Dvd</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>  
        </div>
        <%@include file="detailsEditModalFragment.jsp" %>
        <div id="validationErrors" style="color: red"/>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>
    </body>
</html>
