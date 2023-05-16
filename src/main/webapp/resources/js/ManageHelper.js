$(document).ready(() => fetchAllHelpers())

function fetchAllHelpers() {

    $.getJSON("api/v1/fetch-all-helpers",
        data => {
            let helpers = '';

            $.each(data, (key, value) => {
                helpers +=
                    '<tr id="helper' + value['helperID'] + '" >' +
                    '    <td>' + value['helperID'] + '</td> ' +
                    '    <td>' + value['name'] + '</td> ' +
                    '    <td>' + value['age'] + '</td> ' +
                    '    <td>' + value['gender'] + '</td> ' +
                    '    <td>' + value['phoneNumber'] + '</td> ' +
                    '    <td> ' +
                    '        <a class="bg-success" href="./helper-modify?id=' + value['helperID'] + ' " >Edit</a> ' +
                    '        <a class="tomato-text" onclick="' + 'deleteHelper(' + value['helperID'] + ')">Delete</a> ' +
                    '    </td>' +
                    '</tr>';
            })

            $('#helpers-table').append(helpers);
        }
    )
}

function deleteHelper(id) {

    $.ajax({
        url: 'api/v1/admin/delete-helper/' + id,
        method: "GET",
        success: $('#helper' + id).remove()
    });
}
