$(document).ready(function () {

    loadAddresses();

    $('#add-button').click(function (event) {
        
        $('#validationErrors').text('');

        event.preventDefault();
        var address = {
            firstName: $('#add-first-name').val(),
            lastName: $('#add-last-name').val(),
            address: $('#add-address').val(),
            city: $('#add-city').val(),
            state: $('#add-state').val(),
            zipCode: $('#add-zipcode').val()
        };

        var ajaxInfo = {
            type: 'POST',
            url: 'http://localhost:8080/AddressBookMVC/address',
            
            data: JSON.stringify(address),
            
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        };

        $.ajax(ajaxInfo)
                .success(function (data, status) {
                    $('#add-first-name').val('');
                    $('#add-last-name').val('');
                    $('#add-address').val('');
                    $('#add-city').val('');
                    $('#add-state').val('');
                    $('#add-zipcode').val('');
                    $('#validationErrors').empty();
                    loadAddresses();

                })
                .error(function (data, status) {
                    $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                        var errorDiv = $('#validationErrors');
                        //                $('#validationErrors').empty();
                        errorDiv.append(validationError.message).append($('<br>'));
                    });
                });
    });

    $('#edit-button').click(function (event) {
        $('#validationErrors').text('');
        event.preventDefault();

        $.ajax({
            type: 'PUT',
            url: 'address/' + $('#edit-address-id').val(),
            data: JSON.stringify({
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                address: $('#edit-address').val(),
                city: $('#edit-city').val(),
                state: $('#edit-state').val(),
                zipCode: $('#edit-zipcode').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            hideEditForm();
            loadAddresses();
        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });
});

function loadAddresses() {

    clearAddressTable();

    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/AddressBookMVC/addresses'

    }).success(function (data, status) {
        $.each(data, function (index, address) {
            var name = address.firstName + ' ' + address.lastName;
            var addressLine1 = address.address;
            var id = address.addressId;

            var row = '<tr>';
            row += '<td>' + name + '</td>';
            row += '<td>' + addressLine1 + '</td>';
            row += '<td><a onclick = "showEditForm(' + id + ')">Edit</a></td>';
            row += '<td><a onclick = "deleteAddress(' + id + ')">Delete</a></td>';
            row += '</tr>';
            contentRows.append(row);

        });
    });

}

function clearAddressTable() {
    $('#contentRows').empty();
}

function deleteAddress(addressId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/AddressBookMVC/address/' + addressId
    }).success(function () {
        hideEditForm();
        loadAddresses();
    });

}

function showEditForm(addressId) {

    $.ajax({
        type: 'GET',
        url: 'address/' + addressId
    }).success(function (address, status) {
        $('#edit-first-name').val(address.firstName);
        $('#edit-last-name').val(address.lastName);
        $('#edit-address').val(address.address);
        $('#edit-city').val(address.city);
        $('#edit-state').val(address.state);
        $('#edit-zipcode').val(address.zipCode);
        $('#edit-address-id').val(address.addressId);
        $('#editFormDiv').show();
        $('#addFormDiv').hide();

    });
}

function hideEditForm() {
    $('#edit-first-name').val('');
    $('#edit-last-name').val('');
    $('#edit-address').val('');
    $('#edit-city').val('');
    $('#edit-state').val('');
    $('#edit-zipcode').val('');
    $('#edit-address-id').val('');
    $('#addFormDiv').show();
    $('#editFormDiv').hide();
}