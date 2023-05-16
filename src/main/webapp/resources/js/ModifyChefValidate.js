$('#update-form').validate({
    rules: {
        name: {
            required: true,
            minlength: 4,
            maxlength: 30
        },        
        phoneNumber: {
            required: true,
            phoneRegex: true,
            minlength: 6,
            maxlength: 14,
            normalizer: value => removeWhitespaces(value, '#phone'),
        },
    },
    messages: {
        name: {
            required: "Please enter a chef name",
            minlength: "Name must consist of at least 4 characters",
            maxlength: "Name must be no more than 30 characters long"
        },        
        phoneNumber: {
            required: "Please enter phone number",
            minlength: "Must be at least 10 characters long",
            maxlength: "Must be no more than 14 characters long"
        },
    },
    errorClass: "form-input-error warning-message"
})