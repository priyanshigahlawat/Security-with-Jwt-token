$(document).ready(function(){
    console.log("login entered");
    $("#loginAnchor").click(function(){
            let id = $(".loginId").val();
            const z = {
                "id" : $(".loginId").val(),
                "password" : $(".loginPass").val()
            }
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/login",
                data: JSON.stringify(z),
                dataType: 'json',

                success: function (data){
                    console.log(data);
                    if(data.statusCode == "202"){
                        $("#remark2").html(data.msg);
                    }
                    else{
                        localStorage.setItem("id",id);
                        localStorage.setItem("token",data.token);
                        window.location = '/dashboard';
                    }
                }
            });
        });
});