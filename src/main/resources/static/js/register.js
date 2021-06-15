$(document).ready(function(){
    console.log("hello");
    $("#register").click(function(){
        const z = {
            "id" : $("#registerId").val(),
            "roll" : $("#registerRoll").val(),
            "name" : $("#registerName").val(),
            "password" : $("#registerPass").val(),
            "age" : $("#registerAge").val(),
            "college" : $("#registerCollege").val(),
            "stream" : $("#registerStream").val(),
        }
        console.log($("#registerId").val());
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/saveInfo",
            data: JSON.stringify(z),
            dataType: 'json',

            success: function (data){
                console.log(data.msg);
                $("#remark").html(data.msg);
            }
        });
    });
});