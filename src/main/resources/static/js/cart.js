$(document).ready(function () {
    cart.init();
})

let cart = {
    init: function () {
        this.bindEvent();
    },
    bindEvent: function () {
        // $(".product").
        $("#btn_buy").click(function () {
            if (!confirm("결제하시겠습니까?")) {
                return false;
            }

            let params = [];

            [...document.querySelectorAll(".product")].forEach(product => {
                let itemId = $(product).children(".itemId").val();
                let quantity = $(product).children(".quantity").val();
                params.push({
                    "itemId": itemId,
                    "quantity": quantity
                });
            });

            let token = $("meta[name='_csrf']").attr("content");
            let header = $("meta[name='_csrf_header']").attr("content");

            $.ajax({
                type:"POST",
                url:"/payment", //보내는 주소 설정
                data: JSON.stringify({params: params}),
                dataType: "json", //받아올 데이터(생략가능) html, json등 사용 가능
                contentType: 'application/json; charset=utf-8;',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },

                success: (res)=>{
                    console.log(res);
                    if (res.code !== 200) {
                        alert("결제에 실패했습니다");
                        return false;
                    }
                    alert("결제에 성공했습니다.");
                    location.replace("/");
                },
                error: (log)=>{alert("실패"+log)}
            });
        })
    },
};