<!DOCTYPE html>
<html>
    <head>
        <title>Dvd Library</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css"
              rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Dvd Application</h1>
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
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/rest">Rest</a>
                    </li>
                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/displayDVDListNoAjax">
                            DVD Library (No Ajax)</a>
                    </li>

                </ul>
            </div>

            <!--
            Add a row to our container - this will hold the summary table and the new dvd form.
            -->
            <div class="row">
                <!-- #2: Add a col to hold the summary table - have it take up half the row -->
                <div class="col-md-6">
                    <div id="dvdTableDiv">
                        <h2>My Dvds</h2>

                        <table id="dvdTable" class="table table-hover">
                            <tr>
                                <th width="40%">Dvd Title</th>
                                <th width="30%">Mpaa Rating</th>
                                <th width="15%"></th>
                                <th width="15%"></th>
                            </tr>
                            <!--
                             #3: This holds the list of dvds - we will add rows
                            dynamically
                             using jQuery
                            -->
                            <tbody id="contentRows"></tbody>
                        </table>
                    </div>
                </div> <!-- End col div -->
                <!--
                #4: Add col to hold the new dvd form - have it take up the other half of the row
                -->
                <div class="col-md-6">

                    <div id="editFormDiv" style="display: none">
                        <h2 onclick="hideEditForm()">Edit Dvd</h2>

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-dvd-title" class="col-md-4 control-label">
                                    Dvd Title:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-dvd-title"
                                           placeholder="Dvd Title"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-directors-name" class="col-md-4 control-label">
                                    Director's Name:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-directors-name"
                                           placeholder="Director's Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-mpaaRating" class="col-md-4 control-label">
                                    Mpaa Rating:</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-mpaaRating"
                                           placeholder="Mpaa Rating"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-studio" class="col-md-4 control-label">
                                    Studio:</label>
                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-studio"
                                           placeholder="Studio"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-releaseDate" class="col-md-4 control-label">
                                    Release Date</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="edit-releaseDate"
                                           placeholder="Release Date"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-4">
                                    <input type="hidden" id="edit-dvd-id">
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
                                            class="btn btn-default">
                                        Update Dvd
                                    </button>
                                </div>
                            </div>

                        </form>
                    </div>
                    <div id="addFormDiv">

                        <h2>Add New Dvd</h2>

                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-dvd-title" class="col-md-4 control-label">
                                    Dvd Title:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-dvd-title"
                                           placeholder="Dvd Title"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-directors-name" class="col-md-4 control-label">
                                    Director's Name:
                                </label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-directors-name"
                                           placeholder="Director's Name"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-mpaaRating" class="col-md-4 control-label">
                                    Mpaa Rating:</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-mpaaRating"
                                           placeholder="Mpaa Rating"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-studio" class="col-md-4 control-label">Studio:</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-studio"
                                           placeholder="Studio"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-releaseDate" class="col-md-4 control-label">Release Date:</label>

                                <div class="col-md-8">
                                    <input type="text"
                                           class="form-control"
                                           id="add-releaseDate"
                                           placeholder="Release Date"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit"
                                            id="add-button"
                                            class="btn btn-success">
                                        Create Dvd
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div> <!-- End col div -->
            </div> <!-- End row div -->
        </div>
        <div id="validationErrors" style="color: red"/>
        <!-- #5: Placed at the end of the document so the pages load faster -->
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/restDvdLibrary.js"></script>
    </body>
</html>

