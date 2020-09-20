const protocol = window.location.protocol;
const host = window.location.host;
const hostPath = protocol + "//" + host

$(function () {
    $("#register").on("click", function () {
        register();
    });
    $("#submit").on("click", function () {
        submit();
    });
});

function register() {
    window.location.href = hostPath + "/register"
}

function submit() {
    $.ajax({
        url: hostPath + "/user",
        type: "POST",
        dataType: "application/json;charset=UTF-8",
        data: {username: "小歘歘", password: "5203344"},
        success: function (data) {
            // data = jQuery.parseJSON(data);  //dataType指明了返回数据为json类型，故不需要再反序列化
        }
    });
}