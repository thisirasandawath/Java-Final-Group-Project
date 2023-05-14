$(document).ready(() => fetchAllChefs())

function fetchAllChefs() {

    $.getJSON("api/v1/fetch-all-chefs",
        data => {
            let chefs = '';

            $.each(data, (key, value) => {
                chefs +=
                    '<tr id="chef' + value['chefID'] + '" >' +
                    '    <td>' + value['chefID'] + '</td> ' +
                    '    <td>' + value['name'] + '</td> ' +
                    '    <td>' + value['age'] + '</td> ' +
                    '    <td>' + value['gender'] + '</td> ' +
                    '    <td>' + value['phoneNumber'] + '</td> ' +
                    '    <td> ' +
                    '        <a class="bg-success" href="./chef-modify?id=' + value['chefID'] + ' " >Edit</a> ' +
                    '        <a class="tomato-text" onclick="' + 'deleteChef(' + value['chefID'] + ')">Delete</a> ' +
                    '    </td>' +
                    '</tr>';
            })

            $('#chefs-table').append(chefs);
        }
    )
}

function deleteChef(id) {

    $.ajax({
        url: 'api/v1/admin/delete-chef/' + id,
        method: "GET",
        success: $('#chef' + id).remove()
    });
}
