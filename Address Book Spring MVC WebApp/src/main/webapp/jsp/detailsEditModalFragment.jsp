 <!--Start of detail modal-->
        <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="detailsModalLabel">Address Details</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="address-id"></h3>
                        <table class="table table-bordered">
                            <tr>
                                <th>First Name:</th>
                                <td id="address-firstName"></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td id="address-lastName"></td>
                            </tr>
                            <tr>
                                <th>Address</th>
                                <td id="address-address"></td>
                            </tr>
                            <tr>
                                <th>City</th>
                                <td id="address-city"></td>
                            </tr>
                            <tr>
                                <th>State</th>
                                <td id="address-state"></td>
                            </tr>
                            <tr>
                                <th>Zipcode</th>
                                <td id="address-zipcode"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Start of edit modal-->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="editModalLabel">Edit Address</h4>
                    </div>
                    <div class="modal-body">
                        <h3 id="address-id"></h3>
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
                                <label for="edit-address" class="col-md-4 control-label">Address</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-address" placeholder="Address"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-city" class="col-md-4 control-label">City</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-city" placeholder="City"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-phone" class="col-md-4 control-label">Phone:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-state" placeholder="State"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-zipcode" class="col-md-4 control-label">ZipCode</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="edit-zipcode" placeholder="Zipcode"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <input type="hidden" id="edit-address-id"/>
                                    <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Address</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
