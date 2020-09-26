const protocol = window.location.protocol;
const host = window.location.host;
const hostPath = protocol + "//" + host

$(function () {
    $("#register").on("click", function () {
        register();
    });
    $("#register_submit").on("click", function () {
        submit();
    });
});

function register() {
    window.location.href = hostPath + "/register"
}

function submit() {
    // let res;
    // res.isSusses = undefined;
    // res.msg = undefined;
    $.ajax({
        url: hostPath + "/user",
        type: "POST",
        dataType: "json",
        data: {
            username: "dfs",
            password: "5203344",
            nickname: "小歘歘"
        },
        success: function (res) {
            let success = res.success;
            if (success) {
                alert(res.success);
            } else {
                alert(res.msg);
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