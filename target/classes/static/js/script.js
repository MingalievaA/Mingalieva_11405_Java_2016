$(document).ready(function () {
    $(".js-to-basket").on("click", function(){
        var productId = $(this).attr("productid");
        $.ajax({
            url:"/basket/add/"+productId,
            type:"post"
        })
    });

    $(".js-remove").on("click", function(){
        var productId = $(this).parent().attr("class").split(" ")[1];
        var parent = $(this).parent();
        $.ajax({
            url:"/basket/remove/"+productId,
            type: "post",
            success: function (data) {
                $(parent).remove();
                $("#sum").html(data);
            }
        })
    });

    $(".js-confirm-buy").on("click", function(){
        $.ajax({
            url:"/basket/end-buy",
            type:"post",
            success: function (data) {
                window.location.replace("http://localhost:8080/");
            }
        })
    });
});