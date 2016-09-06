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
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
        </div>
        <div class="container">
            <h1>New DVD Library Form</h1>
            <a href="displayDVDListNoAjax">DVD Library Sans Ajax</a>
            <hr/>
            <!--this submits form to destination written in action attribute of the form tag -->
            <sf:form class="form-horizontal"
                     modelAttribute="dvd"
                     role="form"
                     action="addNewDVDFormNoAjax"
                     method="POST">
                <div class="form-group">
                    <label for="add-dvd-title" class="col-md-4 control-label">DVD Title:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-dvd-title" path="dvdTitle" placeholder="DVD Title"/>
                        <sf:errors path="dvdTitle" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-directors-name" class="col-md-4 control-label">Directors Name:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-directors-name" path="directorsName" placeholder="Directors Name"/>
                        <sf:errors path="directorsName" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-mpaaRating" class="col-md-4 control-label">MPAA Rating</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-mpaa" path="mpaaRating" placeholder="MPAA"/>
                        <sf:errors path="mpaaRating" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-studio" class="col-md-4 control-label">Studio</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-studio" path="studio" placeholder="Studio"/>
                        <sf:errors path="studio" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-releaseDate" class="col-md-4 control-label">Release Date</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-releaseDate" path="releaseDate" placeholder="Release Date"/>
                        <sf:errors path="releaseDate" cssClass="text-danger"></sf:errors>
                        </div>
                    </div>

                    <div class ="form-group">
                        <div class ="col-md-offset-4 col-md-8">
                            <button type="submit" id="add-button" class="btn btn-default">Add New DVD</button>
                        </div>
                    </div>
            </sf:form>
        </div>
    </body>
</html>
