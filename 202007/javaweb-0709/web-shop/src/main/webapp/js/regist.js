var userName = null;
var userPassword = null;
var ruserPassword = null;
var userEmail = null;
var addBtn = null;
var backBtn = null;


$(function () {
    userName = $("#userName");
    userPassword = $("#userPassword");
    ruserPassword = $("#ruserPassword");
    userEmail = $("#userEmail");
    addBtn = $("#add");
    backBtn = $("#back");
    //初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
    userName.next().html("*");
    userPassword.next().html("*");
    ruserPassword.next().html("*");
    userEmail.next().html("*");

    userName.bind("focus", function () {
        validateTip(userName.next(), {"color": "#666666"}, "* 用户名长度必须是大于1小于10的字符", false);
    }).bind("blur", function () {
        if (userName.val() != null && userName.val().length > 1
            && userName.val().length < 10) {
            validateTip(userName.next(), {"color": "green"}, imgYes, true);
        } else {
            validateTip(userName.next(), {"color": "red"}, imgNo + " 用户名输入的不符合规范，请重新输入", false);
        }

    });

    userPassword.bind("focus", function () {
        validateTip(userPassword.next(), {"color": "#666666"}, "* 密码长度必须是大于6小于20", false);
    }).bind("blur", function () {
        if (userPassword.val() != null && userPassword.val().length > 6
            && userPassword.val().length < 20) {
            validateTip(userPassword.next(), {"color": "green"}, imgYes, true);
        } else {
            validateTip(userPassword.next(), {"color": "red"}, imgNo + " 密码输入不符合规范，请重新输入", false);
        }
    });

    ruserPassword.bind("focus", function () {
        validateTip(ruserPassword.next(), {"color": "#666666"}, "* 请输入与上面一致的密码", false);
    }).bind("blur", function () {
        if (ruserPassword.val() != null && ruserPassword.val().length > 6
            && ruserPassword.val().length < 20 && userPassword.val() == ruserPassword.val()) {
            validateTip(ruserPassword.next(), {"color": "green"}, imgYes, true);
        } else {
            validateTip(ruserPassword.next(), {"color": "red"}, imgNo + " 两次密码输入不一致，请重新输入", false);
        }
    });


    userEmail.bind("focus", function () {
        validateTip(userEmail.next(), {"color": "#666666"}, "* 邮箱", false);
    }).bind("blur", function () {
        if (userEmail.val() != null && userEmail.val() != "") {
            validateTip(userEmail.next(), {"color": "green"}, imgYes, true);
        } else {
            validateTip(userEmail.next(), {"color": "red"}, imgNo + " 邮箱格式不正确,请重新输入", false);
        }
    });


    addBtn.bind("click", function () {
        if (userName.attr("validateStatus") != "true") {
            userName.blur();
        } else if (userPassword.attr("validateStatus") != "true") {
            userPassword.blur();
        } else if (ruserPassword.attr("validateStatus") != "true") {
            ruserPassword.blur();
        } else if (userEmail.attr("validateStatus") != "true") {
            userEmail.blur();
        } else {
            if (confirm("是否确认提交数据")) {
                $("#userForm").submit();
            }
        }
    });

    backBtn.on("click", function () {
        if (referer != undefined
            && null != referer
            && "" != referer
            && "null" != referer
            && referer.length > 4) {
            window.location.href = referer;
        } else {
            history.back(-1);
        }
    });

});