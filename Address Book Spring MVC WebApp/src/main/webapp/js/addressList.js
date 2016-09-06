/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Document ready function
// Fires after all HTML/code has been read from the DOM
$(document).ready(function () {
    // loadAddresses() gets called below in it's own function 
    loadAddresses();

    // on click for our add button
    // subscribing to the click event on the add button 
    $('#add-button').click(function (event) {

        //  Remove all validation error messages
        $('#validationErrors').text('');

        // we don’t want the button to actually submit form
        // we'll handle data submission via ajax
        // Make an Ajax call to the server. HTTP verb = POST, URL = address
        // event.preventDefault prevents HTML from performing it's own version of POST?????
        event.preventDefault();
        var ajaxCallSetup = {
            type: 'POST',
            url: 'address',
            //Taking in JSON data and converting it to a string
            data: JSON.stringify({
                // .val() gets the value from the object 
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                address: $('#add-address').val(),
                city: $('#add-city').val(),
                state: $('#add-state').val(),
                zipCode: $('#add-zipcode').val()
            }),
            // setting the negotiation terms for the header
            // communication agreement between the client and the server only accept JSON
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            // tells ajax what type of data it's handling
            'dataType': 'json'
                    // on success of post above clear out data  
        };
        
        $.ajax(ajaxCallSetup).success(function (data, status) {
            // If the call succeeds, clear the form and reload the summary table
            //  .val('') clears out the value from the object
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-address').val('');
            $('#add-city').val('');
            $('#add-state').val('');
            $('#add-zipcode').val('');
            // #1 - Remove all validation error messages
            $('#validationErrors').text('');
            loadAddresses();
            //return false;
        }).error(function (data, status) {
            // #2 - Iterate through each of the fieldErrors and display the associated error
            // message in the validationErrors div
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');

                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    // onclick handler for edit button
    $('#edit-button').click(function (event) {

        $('#validationErrors').text('');
        // prevent the button press from submitting the whole page
        event.preventDefault();
        // Ajax call -
        // Method - PUT
        // URL - address/{id}
        // Just reload all of the Addresses upon success
        $.ajax({
            type: 'PUT',
            url: 'address/' + $('#edit-address-id').val(),
            data: JSON.stringify({
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                address: $('#edit-address').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zipCode: $('#edit-zipcode').val(),
            }),
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            loadAddresses();
        }).error(function (data, status) {
            // Go through each of the fieldErrors and display the associated error
            // message in the validationErrors div
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    // on click for our search button
    $('#search-button').click(function (event) {
        // we don’t want the button to actually submit
        // we'll handle data submission via ajax
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/addresses',
            data: JSON.stringify({
                // .val() gets the value from the object 
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                address: $('#search-address').val(),
                city: $('#search-city').val(),
                state: $('#search-state').val(),
                zipCode: $('#search-zipcode').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            // .val('') clears out the value from the object
            $('#search-first-name').val('');
            $('#search-last-name').val('');
            $('#search-address').val('');
            $('#search-city').val('');
            $('#search-state').val('');
            $('#search-zipcode').val('');
            fillAddressTable(data, status);
        });
    });
});
// addressList holds data from payload   --status????
//here we're calling data addressList
function fillAddressTable(addressList, status) {
    // makes sure to clear out the address table
    clearAddressTable();
    var adTable = $('#contentRows');
    $.each(addressList, function (index, address) {
        //setting up table structure
        adTable.append($('<tr>')
                .append($('<td>').append($('<a>')
                        //setting up modal structure
                        // .attr gets attribute value for first element
                        .attr({
                            //?????????????????????
                            //details modal
                            'data-address-id': address.addressId,
                            'data-toggle': 'modal',
                            //grabs id from details fragment modal
                            'data-target': '#detailsModal'
                        })
                        //text to fill our content rows
                        .text(address.firstName + ' ' + address.lastName)

                        )   // end of <a> append
                        ) // end of <td> append
                .append($('<td>').text(address.address))
                .append($('<td>').append($('<a>')
                        .attr({
                            //edit modal 
                            'data-address-id': address.addressId,
                            //bootstrap looks for this
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')))
                .append($('<td>').append($('<a>').attr({'onclick': 'deleteAddress(' + address.addressId + ')'}).text('Delete')))


                );
    });
}

// Load addresses into the summary table
function loadAddresses() {
    // Make an Ajax GET call to the 'addresses' endpoint in our RESTcontroller
    // upon success we have a function takes in a data array and checks status
    $.ajax({
        url: "addresses"
    }).success(function (data, status) {
        fillAddressTable(data, status);
    });
}
//    ******kept for reference******
//    clearAddressTable();
//    
//    // grab the tbody element that will hold the new list of addresses
//    var cTable = $('#contentRows');
//    Make an Ajax GET call to the 'addresses' endpoint. Iterate through
//    each of the JSON objects that are returned and render them to the
//    summary table.
//    $.ajax({
//        url: 'addresses'
//    }).success(function (data, status) {
//        $.each(data, function (index, address) {
//            cTable.append($('<tr>')
//                    .append($('<td>').append($('<a>')
//                            .attr({
//                                'data-address-id': address.addressId,
//                                'data-toggle': 'modal',
//                                'data-target': '#detailsModal'
//                            })
//                            .text(address.firstName + ' ' + address.lastName)
//
//                            )   // end of <a> append
//                            ) // end of <td> append
//                    .append($('<td>').text(address.address))
//                    .append($('<td>').append($('<a>')
//                            .attr({
//                                'data-address-id': address.addressId,
//                                'data-toggle': 'modal',
//                                'data-target': '#editModal'
//                            })
//                            .text('Edit')))
//                    .append($('<td>').append($('<a>').attr({'onclick': 'deleteAddress(' + address.addressId + ')'}).text('Delete')))
//
//
//                    );
//        });
//
//    });


// Clear all content rows from the summary table
function clearAddressTable() {
    $("#contentRows").empty();
}


function deleteAddress(id) {
    var answer = confirm("Do you really want to delete this address?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'address/' + id
        }).success(function () {
            loadAddresses();
        });
    }
}

// This code runs in response to show.bs.modal event for the details Modal
$('#detailsModal').on('show.bs.modal', function (event) {
    // get the element that triggered the event
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    // make an ajax call to get address information for given address id
    // this is a GET request to address/{id}
    // upon success, put the returned JSON data into the modal dialog
    $.ajax({
        url: 'address/' + addressId
    }).success(function (address) {
        // .text gets text for each element
        modal.find('#address-id').text(address.addressId);
        modal.find('#address-firstName').text(address.firstName);
        modal.find('#address-lastName').text(address.lastName);
        modal.find('#address-address').text(address.address);
        modal.find('#address-city').text(address.city);
        modal.find('#address-state').text(address.state);
        modal.find('#address-zipcode').text(address.zipCode);
    });
});

// This code runs in response to the show.hs.modal event for the edit Modal
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var addressId = element.data('address-id');
    var modal = $(this);
    $.ajax({
        url: 'address/' + addressId
    }).success(function (address) {
//use .text on text display fields like <h3> or <span>
        modal.find('#address-id').text(address.addressId);
        //use .val on input fields
        modal.find('#edit-first-name').val(address.firstName);
        modal.find('#edit-last-name').val(address.lastName);
        modal.find('#edit-address').val(address.address);
        modal.find('#edit-city').val(address.city);
        modal.find('#edit-state').val(address.state);
        modal.find('#edit-zipcode').val(address.zipCode);
        modal.find('#edit-address-id').val(address.addressId);
    });
});