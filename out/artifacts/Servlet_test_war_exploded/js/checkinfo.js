function checkaddr(form) {
    if ($("#uu").val().length < 8) {
        alert("学号位数小于8");
        form.id.value = "";
        return false;
    }
    return true;
}

function delconfirm() {
    $('input[name="select"]:checked').each(function () {
        return confirm("确认删除吗?");
    })
    alert("没有选择");
    return false;
}

function check(form){
    if(form.receiver.value==="null"){
        alert("请选择一个收件人");
        return false;
    }
    return true;
}
function checkuser() {
    if ($("#uu").val().length < 8) {
        alert("学号位数小于8");
        return false;
    }
    if (isEmpty($("#pwd").val())) {
        alert("密码不能为空");
        return false;
    }
    return true;
}

function showPopup() {
    var overlay = document.getElementById("overlay");
    overlay.style.display = "block";
}

function hidePopup() {
    var overlay = document.getElementById("overlay");
    overlay.style.display = "none";
}

function isEmpty(str) {
    return str == null || str.trim() === "";
}