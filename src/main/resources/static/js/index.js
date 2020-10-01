const protocol = window.location.protocol;
const host = window.location.host;
const hostPath = protocol + "//" + host

$(function () {
    modal();
    passwordOpen();
    $("#register_submit").on("click", function () {
        if ($("#registerModal [name='password']").val() === $("#registerModal [name='confirmPassword']").val()) {
            submit();
        } else {
            $("#registerModal [name='confirmPassword']").focus();
        }
    });
});

function passwordOpen() {
    $("input[name='confirmPasswordOpen']").hide();
    $("input[name='passwordOpen']").hide();
    $(".glyphicon-eye-open").on("click", function () {
        $(".glyphicon-eye-open").hide();
        $(".glyphicon-eye-close").show();
        $("#registerModal [name='passwordOpen']").val($("#registerModal [name='password']").hide().val()).show();
        $("input[name='confirmPasswordOpen']").val($("input[name='confirmPassword']").hide().val()).show();
    });
    $(".glyphicon-eye-close").hide().on("click", function () {
        $(".glyphicon-eye-close").hide();
        $(".glyphicon-eye-open").show();
        $("#registerModal [name='password']").val($("#registerModal [name='passwordOpen']").hide().val()).show();
        $("input[name='confirmPassword']").val($("input[name='confirmPasswordOpen']").hide().val()).show();
    });
}

function modal() {
    $('#loginModal').modal({
        backdrop: false
    });
    $("#register").on("click", function () {
        $('#registerModal').modal({
            backdrop: false
        });
        $('#loginModal').modal('hide');
    });
}

function submit() {
    let username = $("#registerModal [name='username']").val();
    let password = $("#registerModal [name='password']").val();
    let nickname = $("#registerModal [name='nickname']").val();
    $.ajax({
        url: hostPath + "/user",
        type: "POST",
        dataType: "json",
        data: {
            username: username,
            password: password,
            nickname: nickname
        },
        success: function (res) {
            if (res.success) {
                $("#registerModal [name='username']").val("");
                $("#registerModal [name='nickname']").val("");
                $(window).attr('location',hostPath+"/success/注册");
            } else {
                alert(res["msg"]);
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
