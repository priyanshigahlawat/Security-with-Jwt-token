$(document).ready(function(){

    const z = {
        "id":localStorage.getItem("id"),
        "token":localStorage.getItem("token")
    }
    console.log(z);
    $.ajax({
         type: "POST",
         contentType: "application/json",
         url: "/dashboard1",
         data: JSON.stringify(z),
         dataType: 'json',

         success: function (data){
              console.log(data.statusCode)
              if(data.statusCode == "202"){
                    alert('YOU NEED TO LOGIN FIRST!');
                    window.location = '/login';
              }
         }
    });


// for college dropdown ===============================================================================
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/fetchAllRecords",

        success: function (data){
            var usedNames = [];
            $.each(data, function(key,value){
                if (usedNames.indexOf(value.college) == -1){
                    $("#cllg").append("<option>"+   value.college +"</option>");
                    usedNames.push(value.college);
                }
            });
        }
    });

//    for stream dropdown ===============================================================================

    $("#cllg").change(function(){
        let college = $("#cllg").find(":selected").text();
        $("#stream").html("");
        $("#stream").append("<option selected>Select Stream</option>");
        $("#roll").html("");
        $("#roll").append("<option selected>Select Roll no</option>");
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/fetchAllRecords",

            success: function (data){
                var usedNames = [];
                $.each(data, function(key,value){
                    if (usedNames.indexOf(value.stream) == -1){
                    if(value.college == college){
                        $("#stream").append("<option>"+ value.stream +"</option>");
                        usedNames.push(value.stream);
                    }
                    }
                });
            }
        });
    });

//    for roll no dropdown =================================================================================

    $("#stream").change(function(){
        let college = $("#cllg").find(":selected").text();
        let stream = $("#stream").find(":selected").text();
        $("#roll").html("");
        $("#roll").append("<option selected>Select Roll no</option>");
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/fetchAllRecords",

            success: function (data){
                $.each(data, function(key,value){
                    if(value.college == college && value.stream == stream){
                        console.log(value);
                        $("#roll").append("<option>"+ value.roll +"</option>");
                    }
                });
            }
        });
    });

    //====================================================================================================

    $("#fetch").click(function(){
        let college = $("#cllg").find(":selected").text();
        let stream = $("#stream").find(":selected").text();
        let roll = $("#roll").find(":selected").text();
        console.log("hello");
        $("#remark").html("");
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/fetchAllRecords",

            success: function (data){
                $.each(data, function(key,value){
                    if(value.roll == roll && value.stream == stream && value.college == college){
                        console.log(value.name);
                        $("#remark").html("<br>ID: " + value.id + "</br>" +
                                          "Name: " + value.name + "</br>" +
                                          "Rollno: " + value.roll + "</br>" +
                                          "Age: " + value.age + "</br>" +
                                          "College: " + value.college + "</br>" +
                                          "Stream: " + value.stream + "</br>");
                    }
                });
            }
        });
    });
});