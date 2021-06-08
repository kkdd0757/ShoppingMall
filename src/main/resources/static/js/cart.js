const display = document.getElementById('display');

$(document).ready(function () {
    cart.init();
    let totalPrice = getTotalPrice();
    display.innerText = String(totalPrice);
    // $('.quantity').keydown(function () {
    //     totalPrice = getTotalPrice();
    //     display.innerText = String(totalPrice);
    // });
})

function getTotalPrice() {
    let length = $(".quantity").length;
    let totalPrice = 0;

    for (let idx = 0; idx < length; idx++) {
        let price = $(`#price_${idx}`).val();
        let quantity = $(`#quantity_${idx}`).val();

        totalPrice += price * quantity;
    }

    return totalPrice;
}

function setTotalPrice() {
    let totalPrice = getTotalPrice();
    display.innerText = String(totalPrice);
}


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

            let length = $(".quantity").length;

            for (let idx = 0; idx < length; idx++) {
                let id = $(`#itemId_${idx}`).val();
                let price = $(`#price_${idx}`).val();
                let quantity = $(`#quantity_${idx}`).val();

                params.push({
                    "itemId": id,
                    "quantity": quantity,
                    "price": price
                });
            }

            let token = $("meta[name='_csrf']").attr("content");
            let header = $("meta[name='_csrf_header']").attr("content");

            $.ajax({
                type: "POST",
                url: "/payment", //보내는 주소 설정
                data: JSON.stringify({params: params}),
                dataType: "json", //받아올 데이터(생략가능) html, json등 사용 가능
                contentType: 'application/json; charset=utf-8;',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },

                success: (res) => {
                    console.log(res);
                    if (res.code !== 200) {
                        alert("결제에 실패했습니다");
                        return false;
                    }
                    alert(res.message);
                    location.replace("/");
                },
                error: (log) => {
                    alert("실패" + log)
                }
            });
        })
    },
};