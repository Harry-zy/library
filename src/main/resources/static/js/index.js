const protocol = window.location.protocol;
const host = window.location.host;
const hostPath = protocol + "//" + host

$(function () {
    modal();
    passwordOpen();
    $("#login").on("click", function () {
        login();
    });
    $("#register_submit").on("click", function () {
        let confirmPassword = $(".confirmPassword");
        if ($("#registerModal .password").val() === confirmPassword.val()) {
            submit();
        } else {
            confirmPassword.focus();
        }
    });
});

function passwordOpen() {
    $(".confirmPasswordOpen").hide();
    $(".passwordOpen").hide();
    $(".glyphicon-eye-open").on("click", function () {
        $(".glyphicon-eye-open").hide();
        $(".glyphicon-eye-close").show();
        $(".passwordOpen").val($("#registerModal .password").hide().val()).show();
        $(".confirmPasswordOpen").val($(".confirmPassword").hide().val()).show();
    });
    $(".glyphicon-eye-close").hide().on("click", function () {
        $(".glyphicon-eye-close").hide();
        $(".glyphicon-eye-open").show();
        $("#registerModal .password").val($(".passwordOpen").hide().val()).show();
        $(".confirmPassword").val($(".confirmPasswordOpen").hide().val()).show();
    });
}

function modal() {
    $('#loginModal').modal({
        backdrop: false,
        keyboard: false
    });
    $("#register").on("click", function () {
        $('#registerModal').modal({
            backdrop: false,
            keyboard: false
        });
        $('#loginModal').modal('hide');
    });
}

function submit() {
    let formObject = {};
    let data = $("#register_form").serializeArray();
    $.each(data,function(i,item){
        formObject[item.name] = item.value
    });
    $.ajax({
        url: hostPath + "/user",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        data: JSON.stringify(formObject),
        success: function (data) {
            if (data.success) {
                $("#registerModal .username").val("");
                $(".nickname").val("");
                $(window).attr('location', hostPath + "/success/注册");
            } else {
                alert(data["msg"]);
            }
        },
        error: function (errorInfo) {
            let alertMsg = '<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a>' +
                '<h1 style="text-align: center">' + JSON.parse(errorInfo.responseText).message + ":" + errorInfo.status + '</h1>' +
                '</div>';
            $("body").prepend(alertMsg);
        }
    });
}

function login(){
    let formObject = {};
    let data = $("#login_form").serializeArray();
    $.each(data,function(i,item){
        formObject[item.name] = item.value
    });
    $.ajax({
        url: hostPath + "/login",
        type: "POST",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        data: JSON.stringify(formObject),
        success: function (data) {
            if (data.success) {
                $("#loginModal .username").val("");
                $("#loginModal .password").val("");
                $(window).attr('location', hostPath + "/success/登录/" + data.t.nickname + "/" + data.t.role.roleName);
            } else {
                alert(data["msg"]);
            }
        },
        error: function (errorInfo) {
            let alertMsg = '<div class="alert alert-danger"><a href="#" class="close" data-dismiss="alert">&times;</a>' +
                '<h1 style="text-align: center">' + JSON.parse(errorInfo.responseText).message + ":" + errorInfo.status + '</h1>' +
                '</div>';
            $("body").prepend(alertMsg);
        }
    });
}