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
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Search</h1>


               <div class="navbar inverse">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/mainAjaxPage">Contact List (Ajax)</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayContactListNoAjax">
                            Contact List (No Ajax)
                        </a>
                    </li>
                </ul>
            </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h2>My Contacts</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="40%">Contact Name</th>
                            <th width="30%">Company</th>
                            <th width="15%"></th>
                            <th width="15%"></th>
                        </tr>
                        <tbody id="contentRows"></tbody>
                    </table>
                </div>
                <!-- start of add form -->
                <div class="col-md-6">
                    <h2>Search New Contact</h2>
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="search-first-name" class="col-md-4 control-label">First Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-first-name" placeholder="First Name: search by partial name using % symbol" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-last-name" class="col-md-4 control-label">Last Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-last-name" placeholder="Last Name: search by partial name using % symbol" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-company" class="col-md-4 control-label">Company:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-company" placeholder="Company: search by partial name using % symbol" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-email" class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <input type="email" class="form-control" id="search-email" placeholder="Email: search by partial name using % symbol" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <input type="tel" class="form-control" id="search-phone" placeholder="Phone: search by partial # using % symbol" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id="search-button"
                                        class="btn btn-primary">Search Contact</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--start of detail modal-->
        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Contact Details</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="contact-id"></h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>First Name:</th>
                                <td id="contact-firstName"></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td id="contact-lastName"></td>
                            </tr>
                            <tr>
                                <th>Company:</th>
                                <td id="contact-company"></td>
                            </tr>
                            <tr>
                                <th>Phone:</th>
                                <td id="contact-phone"></td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td id="contact-email"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- start of edit modal -->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="editModalLabel">Edit Contact</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="contact-id"></h3>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="edit-first-name" class="col-md-4 control-label">First Name:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-first-name" placeholder="First Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-last-name" class="col-md-4 control-label">Last Name:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-last-name" placeholder="Last Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-company" class="col-md-4 control-label">Company:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-company" placeholder="Company"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-email" class="col-md-4 control-label">Email:</label>
                                <div class="col-md-8">
                                    <input type="email" class="form-control" id="edit-email" placeholder="Email"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-phone" class="col-md-4 control-label">Phone:</label>
                                <div class="col-md-8">
                                    <input type="tel" class="form-control" id="edit-phone" placeholder="Phone"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <input type="hidden" id="edit-contact-id"/>
                                    <button type="submit" id="edit-button" class="btn btn-success" data-dismiss="modal">Edit Contact</button>
                                    <button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="validationErrors" style="color: red"/>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/contactList.js"></script>
    </body>
</html>
