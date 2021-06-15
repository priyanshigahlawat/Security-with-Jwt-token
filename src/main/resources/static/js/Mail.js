$(document).ready(function(){

    $("#login2").click(function(){

        const z = {
            "id" : $(".loginId").val(),
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/sendMail",
            data: JSON.stringify(z),
            dataType: 'json',

            success: function (data){
                if(data.statusCode == "202"){
                    $("#remark2").html(data.msg);
                } else if(data.statusCode == "200"){
                    $("#verify").prop("disabled",false);
                    $(".qwe").css("display", "block");
                    $("#remark2").html(data.msg);
                }
            }
        });
    });

    $("#verify").click(function(){
        $(".remark2").html("");
        const z = {
            "id" : $(".loginId").val(),
            "otp" : $(".loginPass").val()
        }
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/verifyOtp",
            data: JSON.stringify(z),
            dataType: 'json',

            success: function (data){
                if(data.statusCode == "202")
                    $("#remark2").html(data.msg);
                else{
                    $("#loginAnchor2").attr("href", "/dashboard");
                    window.location = '/dashboard';
                }
            }
        });
    });
});