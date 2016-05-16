<!doctype html>
<html lang="en">
<head>
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
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
                <li><a href="/login">Логин</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <img alt="Bootstrap Image Preview" src="${product.url}" />
        </div>
        <div class="col-md-4">
            <h2>
                ${product.name}
            </h2>
            <p>
                ${product.descriptionInfo}
            </p>
        </div>
        <div class="col-md-4">
            <h3>
                ${product.price}
            </h3>
        </div>
    </div>
</div>
</body>
</html>