$(document).ready(function () {
    let id = $('#hiddenValue').val();
    $("#cart_button").click(()=> {
        let token = $("meta[name='_csrf']").attr("content");
        let header = $("meta[name='_csrf_header']").attr("content");

        $.ajax({
            type:"POST",
            url:"/product/cart", //보내는 주소 설정
            data: JSON.stringify({"id": id}),
            dataType: "json", //받아올 데이터(생략가능) html, json등 사용 가능
            contentType: 'application/json; charset=utf-8;',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            
            success: (data)=>{console.log(data)},
            error: (log)=>{alert("실패"+log)}
        });
    });
});
