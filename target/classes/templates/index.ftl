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
                <li class="active"><a href="/">Каталог</a></li>
                <li><a href="/basket/">Корзина</a></li>
                <li><a href="/basket/paid">Оплаченные заказы</a></li>
                <li><a href="/registration">Регистрация</a></li>
                <li><a href="/login">Логин</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
<div id="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <span class="label label-info">Label</span>
                <div class="btn-group">

                    <button class="btn btn-default">
                        Action
                    </button>
                    <button data-toggle="dropdown" class="btn btn-default dropdown-toggle">
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">Action</a>
                        </li>
                        <li class="disabled">
                            <a href="#">Another action</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">Something else here</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4">
                <span class="label label-info">Label</span>
                <div class="btn-group">

                    <button class="btn btn-default">
                        Action
                    </button>
                    <button data-toggle="dropdown" class="btn btn-default dropdown-toggle">
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">Action</a>
                        </li>
                        <li class="disabled">
                            <a href="#">Another action</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">Something else here</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4">

                <button type="button" class="btn btn-primary btn-block btn-default">
                    Default
                </button>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <br>
            </div>
        </div>
    </div>
    <div class="products">
        <#list goods as product>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4">
                        <img alt="Bootstrap Image Preview" src="${product.url}" class="img-rounded"/>
                    </div>
                    <div class="col-md-4">
                        <h3>
                        ${product.name}
                        </h3>
                    </div>
                    <div class="col-md-4">

                        <a href="/info/${product.id}"><button type="button" class="btn btn-block btn-lg btn-primary js-go-info">
                            Info
                        </button></a>
                        <button type="button" productid="${product.id}" class="btn btn-block btn-lg btn-success js-to-basket">
                            Buy ${product.price} руб.
                        </button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <br>
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>