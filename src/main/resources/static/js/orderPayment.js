// $(document).ready(function(text,reviver){
//     var flag = "YES";
//
//     //결제
//     var payment = {
//         init:function (){
//             var _this = this;
//             //main 상세페이지에서 구매 버튼 누를 시
//             $("#btn_buy").on("click",function (){
//                 _this.getBuy(flag);
//             });
//             return this;
//         },
//         getBuy: function (flag) {
//             if(flag === "YES"){
//                 if(confirm("구매하시겠습니까?")){
//                     //구매할 경우
//                     var data = {
//                         goodsNum: $("#goodsNum").val(),
//                         goodsName:$("#goodsName").val(),
//                         goodsPrice:$("#goodsPrice").val(),
//                         flag: flag
//                     };
//                 } else {
//                     return false;
//                 }
//             }else if(flag === "NO") {
//                 var data = {
//                     flag : flag
//                 }
//             } else{
//                 alert("잠시후 다시 시도해주세요");
//                 return false;
//             }
//
//             $.ajax({
//                 type : "POST",
//                 url: "/product/cart",
//                 dataType: "json",
//                 contentType: "application/json; charset=utf-8",
//                 data: JSON.stringify(data),
//             }).done(function(data) {
//                 if(data.result === true) {
//                     payment.getPaymentModule();
//                 }
//             }).fail(function (jqXHR, textStatus, errorThrown){
//                 alert("관리자에게 문의해주세요");
//                 console.log(jqXHR,""+textStatus+""+errorThrown+"");
//             });
//         },
//         getPaymentModule: function (){
//             var IMP = window.IMP;
//             IMP.init('imp36331565');
//             IMP.request_pay({
//                 pg:'inicis',
//                 pay_method: 'card',
//                 merchant_uid:'merchant_',
//                 name: "주문명: 결제테스트",
//                 amount: 1000,
//                 buyer_email : '구매자 이메일',
//                 buyer_name : '구매자',
//                 buyer_tel : '구매자 연락처',
//                 buyer_addr: '서울특별시 강남구 삼성동',
//                 buyer_postcode: '구매자 우편번호',
//                 m_redirect_url: '구매후 리다이렉트 될 페이지'
//             }, function (rsp){
//                 if(rsp.success){
//                     var msg = '결제가 완료되었습니다';
//                     msg+='ID'+rsp.imp_uid;
//                     msg+='상점 거래 ID'+rsp.merchant_uid;
//                     msg+='결제금액'+rsp.paid_amount;
//                     msg+='카드 승인번호'+rsq.apply_num;
//                 } else {
//                     flag = "NO";
//                     payment.getBuy(flag);
//                     var msg = rsp.error_msg + ".";
//                 }
//                 alert(msg);
//             });
//         },
//     };
//     payment.init();
// })