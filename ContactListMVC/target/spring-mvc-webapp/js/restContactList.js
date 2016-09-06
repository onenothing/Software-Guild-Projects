$(document).ready(function () {

    loadContacts();

    $('#add-button').click(function (event) {

        event.preventDefault();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/ContactListMVC/contact',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#add-first-name').val('');
            $('#add-last-name').val('');
            $('#add-company').val('');
            $('#add-phone').val('');
            $('#add-email').val('');
            $('#validationErrors').empty();
            loadContacts();

        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                $('#validationErrors').empty();
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $('#edit-button').click(function (event) {

        event.preventDefault();

        $.ajax({
            type: 'PUT',
            url: 'contact/' + $('#edit-contact-id').val(),
            data: JSON.stringify({
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                company: $('#edit-company').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val()
                
            }),
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            hideEditForm();
            //$('#validationErrors').empty();may not need
            loadContacts();
        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                //$('#validationErrors').empty(); may not need
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });
});

function loadContacts() {

    clearContactTable();

    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/ContactListMVC/contacts'

    }).success(function (data, status) {
        $.each(data, function (index, contact) {
            var name = contact.firstName + '' + contact.lastName;
            var company = contact.company;
            var id = contact.contactId;

            var row = '<tr>';
            row += '<td>' + name + '</td>';
            row += '<td>' + company + '</td>';
            row += '<td><a onclick = "showEditForm(' + id + ')">Edit</a></td>';
            row += '<td><a onclick = "deleteContact(' + id + ')">Delete</a></td>';
            row += '</tr>';
            contentRows.append(row);

        });
    });

}

function clearContactTable() {
    $('#contentRows').empty();
}

function deleteContact(contactId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/ContactListMVC/contact/' + contactId
    }).success(function () {
        hideEditForm();
        loadContacts();
    });

}

function showEditForm(contactId) {

    $.ajax({
        type: 'GET',
        url: 'contact/' + contactId
    }).success(function (contact, status) {
        $('#edit-first-name').val(contact.firstName);
        $('#edit-last-name').val(contact.lastName);
        $('#edit-company').val(contact.company);
        $('#edit-phone').val(contact.phone);
        $('#edit-email').val(contact.email);
        $('#edit-contact-id').val(contact.contactId);
        $('#editFormDiv').show();
        $('#addFormDiv').hide();

    });
}

function hideEditForm() {
    $('#edit-first-name').val('');
    $('#edit-last-name').val('');
    $('#edit-company').val('');
    $('#edit-phone').val('');
    $('#edit-email').val('');
    $('#edit-contact-id').val('');
    $('#addFormDiv').show();
    $('#editFormDiv').hide();
}