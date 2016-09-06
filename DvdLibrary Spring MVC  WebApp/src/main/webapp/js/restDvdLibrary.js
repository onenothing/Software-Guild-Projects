$(document).ready(function () {

    loadDvds();

    $('#add-button').click(function (event) {
        $('#validationErrors').text('');
        event.preventDefault();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/DVDLibraryMVC/dvd',
            data: JSON.stringify({
                dvdTitle: $('#add-dvd-title').val(),
                directorsName: $('#add-directors-name').val(),
                mpaaRating: $('#add-mpaaRating').val(),
                studio: $('#add-studio').val(),
                releaseDate: $('#add-releaseDate').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#add-dvd-title').val('');
            $('#add-directors-name').val('');
            $('#add-mpaaRating').val('');
            $('#add-studio').val('');
            $('#add-releaseDate').val('');
            $('#validationErrors').empty();
            loadDvds();

        }).error(function (data, status) {
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
            url: 'dvd/' + $('#edit-dvd-id').val(),
            data: JSON.stringify({
                dvdTitle: $('#edit-dvd-title').val(),
                directorsName: $('#edit-directors-name').val(),
                mpaaRating: $('#edit-mpaaRating').val(),
                studio: $('#edit-studio').val(),
                releaseDate: $('#edit-releaseDate').val()

            }),
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            hideEditForm();
            loadDvds();
        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });
});

function loadDvds() {

    clearDvdTable();

    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/DVDLibraryMVC/dvds'

    }).success(function (data, status) {
        $.each(data, function (index, dvd) {
            var id = dvd.dvdId;
            var title = dvd.dvdTitle;
            var dvdLine1 = dvd.mpaaRating;


            var row = '<tr>';
            row += '<td>' + title + '</td>';
            row += '<td>' + dvdLine1 + '</td>';
            row += '<td><a onclick = "showEditForm(' + id + ')">Edit</a></td>';
            row += '<td><a onclick = "deleteDvd(' + id + ')">Delete</a></td>';
            row += '</tr>';
            contentRows.append(row);

        });
    });
//
//    var contentRows = $('#contentRows');
//    var settings = {
//        "async": true,
//        "crossDomain": true,
//        "url": "",
//        "method": "GET",
//        "headers": {
//            "content-type": "application/json",
//            "cache-control": "no-cache"
//            
//        },
//        "processData": false,
//        "data": ""
//    }
//
//    $.ajax(settings).done(function (response) {
//        $.each(response, function (index, dvd) {
//            var title = dvd.dvdTitle;
//            var dvdLine1 = dvd.dvd;
//            var id = dvd.dvdId;
//
//            var row = '<tr>';
//            row += '<td>' + title + '</td>';
//            row += '<td>' + dvdLine1 + '</td>';
//            row += '<td><a onclick = "showEditForm(' + id + ')">Edit</a></td>';
//            row += '<td><a onclick = "deleteDvd(' + id + ')">Delete</a></td>';
//            row += '</tr>';
//            contentRows.append(row);
//        });
//    });


}

function clearDvdTable() {
    $('#contentRows').empty();
}

function deleteDvd(dvdId) {

    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/DVDLibraryMVC/dvd/' + dvdId
    }).success(function () {
        hideEditForm();
        loadDvds();
    });

}

function showEditForm(dvdId) {

    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (dvd, status) {
        $('#edit-dvd-title').val(dvd.dvdTitle);
        $('#edit-directors-name').val(dvd.directorsName);
        $('#edit-mpaaRating').val(dvd.mpaaRating);
        $('#edit-studio').val(dvd.studio);
        $('#edit-releaseDate').val(dvd.releaseDate);
        $('#edit-dvd-id').val(dvd.dvdId);
        $('#editFormDiv').show();
        $('#addFormDiv').hide();

    });
}

function hideEditForm() {
    $('#edit-dvd-title').val('');
    $('#edit-directors-name').val('');
    $('#edit-mpaaRating').val('');
    $('#edit-studio').val('');
    $('#edit-releaseDate').val('');
    $('#edit-dvd-id').val('');
    $('#addFormDiv').show();
    $('#editFormDiv').hide();
}


