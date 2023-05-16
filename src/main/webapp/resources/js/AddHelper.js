$('#add-helper-form').validate({
    submitHandler: form => {
        $.ajax({
            url: 'api/v1/admin/add-helper-action',
            method: "POST",
            data: $('#add-helper-form').serialize(),
            success: data => {
                let message = document.getElementById('admin-prompt');

                if (data === 'error')
                    message.innerHTML = '<p class="tomato-text">Please fill out all the fields properly.</p>'
                else if (data === 'duplicate')
                    message.innerHTML = '<p class="tomato-text">Another helper with that name already exists.</p>'
                else {
                    message.innerHTML = '<p class="green-text">New helper added!</p>'
                    $('#add-helper-form').trigger("reset");
                }
            }
        })
    },
    rules: {
        name: {
            required: true,
            minlength: 4,
            maxlength: 30
        },
        age: {
            required: true,
            minlength: 1,
            maxlength: 3,
            normalizer: value => removeWhitespaces(value, '#age')
        },       
        phoneNumber: {
            required: true,
            phoneRegex: true,
            minlength: 10,
            maxlength: 14,
            normalizer: value => removeWhitespaces(value, '#phone'),
        },
        gender: {
            required: true
        },
    },
    messages: {
        name: {
            required: "Please enter a helper name",
            minlength: "Name must consist of at least 4 characters",
            maxlength: "Name must be no more than 30 characters long"
        },
        age: {
            required: "Please enter age",
            minlength: "Age must consist of at least 1 character",
            maxlength: "Age must be no more than 3 characters long"
        },
        phoneNumber: {
            required: "Please enter phone number",
            minlength: "Your phone number must be at least 10 characters long",
            maxlength: "Your phone number must be no more than 14 characters long"
        },
        gender: "Please select the gender",
    },
    errorClass: "form-input-error warning-message",
    errorPlacement: function (error, element) {
        if (element.attr("type") === "radio") {
            error.insertAfter('#radio-button-box');
            $('#radio-button-box').addClass('form-input-error');
        } else error.insertAfter(element);
    }
})

$('input[type=radio][name=gender]').change(() =>
    $('#radio-button-box').removeClass('form-input-error'));