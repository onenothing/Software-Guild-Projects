/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    loadDvds();
    $('#add-button').click(function (event) {
        $('#validationErrors').text('');

        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'dvd',
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
            loadDvds();
        }).error(function (data, status) {
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });
    
    $('#search-button').click(function (event) {

        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/dvds',
            data: JSON.stringify({
                dvdTitle: $('#search-dvd-title').val(),
                directorsName: $('#search-directors-name').val(),
                mpaaRating: $('#search-mpaaRating').val(),
                studio: $('#search-studio').val(),
                releaseDate: $('#search-releaseDate').val(),
               
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#search-dvd-title').val('');
            $('#search-directors-name').val('');
            $('#search-mpaaRating').val('');
            $('#search-studio').val('');
            $('#search-releaseDate').val('');
            fillDvdTable(data, status);
        });
    });
});

function fillDvdTable(dvdList, status) {
    clearDvdTable();
    var discTable = $('#contentRows');
    $.each(dvdList, function (index, dvd) {
        discTable.append($('<tr>')
                .append($('<td>').append($('<a>')
                        .attr({
                            'data-dvd-id': dvd.dvdId,
                            'data-toggle': 'modal',
                            'data-target': '#detailsModal'
                        })
                        .text(dvd.dvdTitle)

                        )   // end of <a> append
                        ) // end of <td> append
                .append($('<td>').text(dvd.mpaaRating))
                .append($('<td>').append($('<a>')
                        .attr({
                            'data-dvd-id': dvd.dvdId,
                            'data-toggle': 'modal',
                            'data-target': '#editModal'
                        })
                        .text('Edit')))
                .append($('<td>').append($('<a>').attr({'onclick': 'deleteDvd(' + dvd.dvdId + ')'}).text('Delete')))


                );
    });
}
function loadDvds() {
    
    $.ajax({
        url: "dvds"
    }).success(function (data, status){
        fillDvdTable(data, status);
    });
    
}

//    clearDvdTable();
//    var discTable = $('#contentRows');
//    $.ajax({
//        url: 'dvds'
//    }).success(function (data, status) {
//        $.each(data, function (index, dvd) {
//            discTable.append($('<tr>')
//                    .append($('<td>').append($('<a>')
//                            .attr({
//                                'data-dvd-id': dvd.dvdId,
//                                'data-toggle': 'modal',
//                                'data-target': '#detailsModal'
//                            })
//                            .text(dvd.dvdTitle)
//
//                            )   // end of <a> append
//                            ) // end of <td> append
//                    .append($('<td>').text(dvd.mpaaRating))
//                    .append($('<td>').append($('<a>')
//                            .attr({
//                                'data-dvd-id': dvd.dvdId,
//                                'data-toggle': 'modal',
//                                'data-target': '#editModal'
//                            })
//                            .text('Edit')))
//                    .append($('<td>').append($('<a>').attr({'onclick': 'deleteDvd(' + dvd.dvdId + ')'}).text('Delete')))
//
//
//                    );
//        });
//
//    });


function clearDvdTable()
{
    $("#contentRows").empty();

}
function deleteDvd(id) {
    var answer = confirm("Do you really want to delete this dvd?");

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            loadDvds();
        });
    }
}

$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
        modal.find('#dvd-id').text(dvd.dvdId);
        modal.find('#dvd-dvdTitle').text(dvd.dvdTitle);
        modal.find('#dvd-directorsName').text(dvd.directorsName);
        modal.find('#dvd-mpaaRating').text(dvd.mpaaRating);
        modal.find('#dvd-studio').text(dvd.studio);
        modal.find('#dvd-releaseDate').text(dvd.releaseDate);
//        modal.find('#dvd-id').val(dvd.dvdId);
    });
});
$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    $.ajax({
        url: 'dvd/' + dvdId
    }).success(function (dvd) {
//use .text on text display fields like <h3> or <span>
        modal.find('#dvd-id').text(dvd.dvdId);
        //use .val on input fields
        modal.find('#edit-dvd-title').val(dvd.dvdTitle);
        modal.find('#edit-directors-name').val(dvd.directorsName);
        modal.find('#edit-mpaaRating').val(dvd.mpaaRating);
        modal.find('#edit-studio').val(dvd.studio);
        modal.find('#edit-releaseDate').val(dvd.releaseDate);
        modal.find('#edit-dvd-id').val(dvd.dvdId);
    });
});