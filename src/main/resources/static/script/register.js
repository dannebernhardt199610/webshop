$(document).ready(function() {

    $('#register-form').validate({
        rules: {
            firstname: {
                required: true,
                minlength: 2
            },
            lastname: {
                required: true,
                minlength: 2
            },
            address: {
                required: true,
                minlength: 3
            },
            username: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 4
            },
            email: {
                required: true,
                email: true
            }

        },
        messages: {
            firstname: {
                required: 'firstname is a must.',
                minlength: 'must contain more than 2 letters.'
            },
            lastname: {
                required: 'lastname is a must.',
                minlength: 'must contain more than 2 letters.'
            },
            address: {
                required: 'Adress is a must.',
                minlength: 'must contain more than 3 letters.'
            },
            username: {
                required: 'Username is a must.',
                minlength: 'must contain more than 4 letters.'
            },
            password: {
                required: 'Password is a must.',
                minlength: 'must contain more than 4 letters.'
            },
            email: {
                required: 'Email is a must.',
                email: 'Du måste ange en giltig email adress.'
            },

        }
    })

    $("#register-form").submit(function( event ) {


        event.preventDefault();

        let $form = $( this ),
            firstname = $form.find( "input[name='firstname']" ).val(),
            lastname = $form.find( "input[name='lastname']" ).val(),
            address = $form.find( "input[name='address']" ).val(),
            username = $form.find( "input[name='username']" ).val(),
            password = $form.find( "input[name='password']" ).val(),
            email = $form.find( "input[name='email']" ).val();


        let data = {
            firstname: firstname,
            lastname: lastname,
            address: address,
            username: username,
            password: password,
            email: email,
            role: 0,
            totalAmount: 0.0
        }
        console.log(data);


        $.ajax({
            url: 'http://localhost:8080/user/add',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: false,
            success: function(responseMessage){
                if(responseMessage.status) {

                    $('.register-message').empty().append(`<p>${responseMessage.message}</p>`);
                    setTimeout(function(){
                        window.location.href='http://localhost:8080/';
                    }, 2000);
                } else {

                    console.log("Användaren har inte blivit reggad!");
                    $('.register-message').empty().append(
                        `<p>${responseMessage.message}</p>`
                    );
                }
            }
        });
    });
});