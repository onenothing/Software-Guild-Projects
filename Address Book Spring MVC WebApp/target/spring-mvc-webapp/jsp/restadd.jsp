<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css"
              rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Address Application</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role = "presentation">
                        <a href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/search">Search</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/stats">Stats</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/rest">Rest</a>
                    </li>
                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/displayAddressListNoAjax">
                            Address Book (No Ajax)</a>
                    </li>

                </ul>
            </div>

            <!-- Add a row to our container - this will hold the summary table and the new contact form.
            -->
            <div class="row">
                <!-- #2: Add a col to hold the summary table - have it take up half the row -->
                <div class="col-md-6">
                    <div id="address">
                        <h2>My Addresses</h2>

                        <table id="contactTable" class="table table-hover">
                            <tr>
                                <th width="40%">Address Name</th>
                                <th width="30%">Address</th>
                                <th width="15%"></th>
                                <th width="15%"></th>
                            </tr>
                            <!--
                             #3: This holds the list of contacts - we will add rows
                            dynamically
                             using jQuery
                            -->
                            <tbody id="contentRows"></tbody>
                        </table>
                    </div>
                </div> <!-- End col div -->
                <!--
                #4: Add col to hold the new contact form - have it take up the other half of the row
                -->
                <div class="col-md-6">

                    <div id="editFormDiv" style="display: none">
                        <h2 onclick="hideEditForm()">Edit Address</h2>

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-first-name" class="col-md-4 control-label">
                                    First Name:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-first-name"
                                           placeholder="First Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-last-name" class="col-md-4 control-label">
                                    Last Name:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-last-name"
                                           placeholder="Last Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-address" class="col-md-4 control-label">
                                    Address:</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-address"
                                           placeholder="Address"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-city" class="col-md-4 control-label">City</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-city"
                                           placeholder="City"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-state" class="col-md-4 control-label">State</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-state"
                                           placeholder="State"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-zipcode" class="col-md-4 control-label">Zipcode</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-zipcode"
                                           placeholder="Zipcode"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-4">
                                    <input type="hidden" id="edit-address-id">
                                    <button type="button"
                                            id="edit-cancel-button"
                                            class="btn btn-default"
                                            onclick="hideEditForm()">
                                        Cancel
                                    </button>
                                </div>
                                <div class="col-md-4">
                                    <button type="submit"
                                            id="edit-button"
                                            class="btn btn-success">
                                        Update Address
                                    </button>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div id="addFormDiv">

                        <h2>Add New Address</h2>

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-first-name" class="col-md-4 control-label">
                                    First Name:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-first-name"
                                           placeholder="First Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-last-name" class="col-md-4 control-label">
                                    Last Name:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-last-name"
                                           placeholder="Last Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-address" class="col-md-4 control-label">
                                    Address:</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-address"
                                           placeholder="Address"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-city" class="col-md-4 control-label">City</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-city"
                                           placeholder="City"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-state" class="col-md-4 control-label">State</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-state"
                                           placeholder="State"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-zipcode" class="col-md-4 control-label">Zipcode</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-zipcode"
                                           placeholder="Zipcode"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit"
                                            id="add-button"
                                            class="btn btn-success">
                                        Create Address
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div> <!-- End col div -->
            </div> <!-- End row div -->
        </div> <!-- End of container div -->
        <div id="validationErrors" style="color: red"/>
        <!-- #5: Placed at the end of the document so the pages load faster -->
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/restAddressBook.js"></script>
    </body>
</html>