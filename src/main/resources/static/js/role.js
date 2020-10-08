const protocol = window.location.protocol;
const host = window.location.host;
const hostPath = protocol + "//" + host

$(function () {
    modal();
    findPermission();
    $("#save_submit").on("click", function () {
        submit();
    });
});

function modal() {
    $("#save").on("click", function () {
        $('#saveModal').modal({
            backdrop: false,
            keyboard: false
        });
    });
}

function submit() {
    let permissionIds = $('input[name=permissionIds]:checked').map(function(){
        return $(this).val();
    }).get();
    let formObject = {};
    let data = $("#save_form").serializeArray();
    $.each(data, function (i, item) {
        formObject[item.name] = item.value
    });
    formObject["permissionIds"] = permissionIds;

    $.ajax({
        contentType: "application/json;charset=UTF-8",
        url: hostPath + "/role",
        type: "POST",
        dataType: "json",
        data: JSON.stringify(formObject),
        success: function (data) {
            if (data.success) {
                alert(data["msg"]);
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

function findPermission() {
    $.ajax({
        contentType: "application/json;charset=UTF-8",
        url: hostPath + "/per",
        type: "PATCH",
        dataType: "json",
        success: function (data) {
            if (data.success) {
                $.each(data.data, function (index, item) {
                    $("#permissions").append("" +
                        "<div class=\"checkbox\">\n" +
                        "                    <label>\n" +
                        "                        <input type=\"checkbox\" name=\"permissionIds\" value=\"" +
                        item.id +
                        "\"> " +
                        item.permissionName +
                        "                    </label>\n" +
                        "                </div>");
                });
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