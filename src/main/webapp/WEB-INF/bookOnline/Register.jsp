<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <title></title>
    <link rel="stylesheet" href="../../static/MDUI_files/mdui.min.css">
    <link rel="stylesheet" href="../../static/MDUI_files/style.css">
    <script src="https://hm.baidu.com/hm.js?33d719afc3e48d8a2fbdd886b164d2e4"></script>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?33d719afc3e48d8a2fbdd886b164d2e4";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <style></style>
    <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255, 255, 255, .38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink mdui-loaded" style="">

<!-- 首屏 -->
<div class="main-section mdui-color-theme" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h2>
            <br>
            客户注册
        </h2>
        <div class="mdui-center" style="width: 500px;">
            <table style="justify-content: center;margin-left: auto;margin-right: auto;">
                <form action="/bookOnline/Register.do" method="post">
                    <tr>
                        <td>
                            <div class="mdui-textfield mdui-textfield-floating-label">
                                <label class="mdui-textfield-label"></label>
                                <%--<input class="mdui-textfield-input" type = "text" size = "20" name = "customerName" required/>--%>
                            </div>
                        </td>
                    </tr>
                    <div class="mdui-textfield">
                        账号<textarea class="mdui-textfield-input" name="username" placeholder="账号"></textarea>
                    </div>
                    <div class="mdui-textfield">
                        密码<textarea class="mdui-textfield-input" name="password" placeholder="密码"></textarea>
                    </div>

                    <tr>
                        <div class="mdui-textfield">
                            姓名<textarea class="mdui-textfield-input" name="customerName" placeholder="姓名"></textarea>
                        </div>

                    <tr>
                        <div class="mdui-textfield">
                            性别
                            <label class="mdui-radio">
                                <input type="radio" name="customerGender" value="male"/>
                                <i class="mdui-radio-icon"></i>
                                男
                            </label>
                            <label class="mdui-radio">
                                <input type="radio" name="customerGender" value="female"/>
                                <i class="mdui-radio-icon"></i>
                                女
                            </label>
                        </div>
                    </tr>
                    <div class="mdui-textfield">
                        身份证号码
                        <input class="mdui-textfield-input" type="text" pattern="(^\d{15}$)|(^\d{17}([0-9]|X)$)"
                               name="customerIDNumber" placeholder="身份证号码"/>
                        <div class="mdui-textfield-error">身份证格式错误</div>
                    </div>
                    </tr>

                    <tr>
                        <td>
                            <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent"
                                    style="justify-content: center;margin-left: auto;margin-right: auto;width: 200px;">
                                注册
                                <%--<div class="main-btn-wrapper">--%>
                                <%--<a href="/bookOnline/Login.do"--%>
                                <%--class="mdui-btn main-btn mdui-ripple mdui-ripple-white mdui-m-r-2" >登录</a>--%>
                                <%--</div>--%>
                            </button>
                        </td>
                </form>
                </tr>
            </table>
        </div>
        <br>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script>
    var $$ = mdui.JQ;

    $$(function () {
        // appbar 自动隐藏
        var $appbar = $$('.mdui-appbar');
        $$(window).on('scroll', function () {
            $appbar[document.body.scrollTop === 0 ? 'addClass' : 'removeClass']('mdui-shadow-0');
        });
    });
</script>
</body>
</html>


