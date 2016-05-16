jQuery.validator.addMethod(
    'regexp',
    function(value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#reg_form").validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 30
            },
            email: {
                required: true,
                email: true
            },
            login: {
                required: true,
                minlength: 3,
                maxlength: 16,
                regexp: /^[a-zA-Z0-9_-]{3,16}$/
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 24
            },
            repassword: {
                required: true,
                minlength: 6,
                maxlength: 24,
                equalTo: "#password"
            }
        },
        messages: {
            name: {
                required: "Это поле обязательно для заполнения",
                minlength: "Минимальное число символов - 2",
                maxlength: "Максимальное число символов - 30"
            },
            email: {
                required: "Это поле обязательно для заполнения",
                email: "Введите коректную почту"
            },
            login: {
                required: "Это поле обязательно для заполнения",
                minlength: "Минимальное число символов - 3",
                maxlength: "Максимальное число символов - 16",
                regexp: "Поле должно содержать латинские символы или цифры"
            },
            password: {
                required: "Это поле обязательно для заполнения",
                minlength: "Минимальное число символов - 6",
                maxlength: "Максимальное число символов - 24"
            },
            repassword: {
                required: "Это поле обязательно для заполнения",
                minlength: "Минимальное число символов - 6",
                maxlength: "Максимальное число символов - 24",
                equalTo: "Пароли не совпадают"
            }
        }
    });
});