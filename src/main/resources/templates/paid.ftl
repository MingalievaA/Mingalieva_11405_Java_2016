<!doctype html>
<html lang="en">
<head>
    <script src="/js/jquery.min.js"></script>
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
                <li class="active"><a href="/basket/paid">Оплаченные заказы</a></li>
                <li><a href="/registration">Регистрация</a></li>
                <li><a href="/login">Логин</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-8">
        <#list baskets as basket>
            <div class="product ${basket.productId.id}">
                <h3>
                ${basket.productId.name}
                </h3>
                <h4>
                ${basket.productCount} шт. x ${basket.productId.price} руб.
                </h4>
                <h4>Колличесво товара: ${basket.productCount}</h4>
                <button type="button" class="btn btn-default js-remove" aria-label="Left Align">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
            </div>
        </#list>
        </div>
        <div class="col-md-4">
            <h3>
                <div id="sum">
                ${sum}
                </div>
            </h3>
        </div>
    </div>
</div>
</body>
</html>