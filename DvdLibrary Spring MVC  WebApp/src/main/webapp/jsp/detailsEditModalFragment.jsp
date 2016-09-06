<!--start of detail modal-->
<div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="detailsModalLabel">Dvd Details</h4>
            </div>
            <div class="modal-body">
                <h3 id="dvd-id"></h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Dvd Title:</th>
                        <td id="dvd-dvdTitle"></td>
                    </tr>
                    <tr>
                        <th>Directors Name:</th>
                        <td id="dvd-directorsName"></td>
                    </tr>
                    <tr>
                        <th>Mpaa Rating</th>
                        <td id="dvd-mpaaRating"></td>
                    </tr>
                    <tr>
                        <th>Studio</th>
                        <td id="dvd-studio"></td>
                    </tr>
                    <tr>
                        <th>Release Date</th>
                        <td id="dvd-releaseDate"></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
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
                <h3 id="dvd-id"></h3>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-dvd-title" class="col-md-4 control-label">Dvd Title:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-dvd-title" placeholder="Dvd Title"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-directors-name" class="col-md-4 control-label">Director's Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-directors-name" placeholder="Director's Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-mpaaRating" class="col-md-4 control-label">MpaaRating:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-mpaaRating" placeholder="MpaaRating"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-studio" class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-studio" placeholder="Studio"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-releaseDate" class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="edit-releaseDate" placeholder="Release Date:"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="hidden" id="edit-dvd-id"/>
                            <button type="submit" id="edit-button" class="btn btn-success" data-dismiss="modal">Edit Dvd</button>
                            <button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
