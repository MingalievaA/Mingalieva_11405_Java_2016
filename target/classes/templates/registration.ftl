<#import "/spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/js/jquerymin.js"></script>
    <script src="/js/jquery.validate.min.js"></script>
    <script src="/js/registration-validation.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/script.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Document</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Парфюмерия с вокзала</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Каталог</a></li>
                <li><a href="/basket/">Корзина</a></li>
                <li><a href="/basket/paid">Оплаченные заказы</a></li>
                <li  class="active"><a href="/registration">Регистрация</a></li>
                <li><a href="/login">Логин</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<form action='/registration' method="post" id="reg_form">
    <label>Имя:<br>
    <@spring.bind "userform.name"/>
        <input type="text"
               name="name"/><br>
    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
        <br>
    </label>


    <label>Почта:<br>
    <@spring.bind "userform.email"/>
        <input type="text"
               name="email"/><br>
    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
        <br>
    </label>

    <label>Логин:<br>
    <@spring.bind "userform.login"/>
        <input type="text"
               name="login"/><br>
    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
    <#if loginError??>
        <b>${loginError}</b>
    </#if>
        <br>
    </label>

    <label>Пароль:<br>
    <@spring.bind "userform.password"/>
        <input type="password"
               name="password" id="password"/><br>
    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
        <br>
    </label>

    <label>Повторите пароль:<br>
    <@spring.bind "userform.repassword"/>
        <input type="password"
               name="repassword"/><br>
    <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
        <br>
    </label>


    <input type="submit" value="Сохранить">
</form>


</body>
</html>