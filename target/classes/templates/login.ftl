<!doctype html>
<html lang="en">
<head>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/script.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <meta charset="UTF-8">
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
                <li><a href="/registration">Регистрация</a></li>
                <li class="active"><a href="/login">Логин</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<#if error??>
    <p>error</p>
</#if>

<form action="/login/process" method="post">
    Login: <input type="text" name="username">
    Pass: <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>