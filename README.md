# Cordova-Toast

cordova插件,调用android原生Toast.

example:
    时间较长的toast:
        window.plugins.toastPlugin.longToast("long");
        参数 message 在toast上展示的信息
            callback  调用成功回调函数
    时间较短的toast:
        window.plugins.toastPlugin.shortToast("short");
    取消toast:
        window.plugins.toastPlugin.cancel();

ios 版的正在learn;