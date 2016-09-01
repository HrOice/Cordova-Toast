var ToastPlugin = function(){}

ToastPlugin.prototype.longToast = function(message,callback) {
    var data = [];
    data.push(message);
    try{
        this.call_native("show_short",data,callback);
    } catch (exception) {
        console.log(exception);
    }
}

ToastPlugin.prototype.call_native = function (name, args, callback) {
  ret = cordova.exec(callback, this.error_callback, 'ToastPlugin', name, args);
  return ret;
}

ToastPlugin.prototype.error_callback = function (msg) {
  console.log('Javascript Callback Error: ' + msg)
}

ToastPlugin.prototype.shortToast = function(message,callback) {
    var data = [];
    data.push(message);
    try{
        this.call_native("show_long",data,callback);
    } catch (exception) {
        console.log(exception);
    }
}

ToastPlugin.prototype.cancel = function(message,callback) {
    var data = [];
    data.push(message);
    try{
        this.call_native("cancel",data,callback);
    } catch (exception) {
        console.log(exception);
    }
}

if (!window.plugins) {
  window.plugins = {}
}

if (!window.plugins.toastPlugin) {
  window.plugins.toastPlugin = new ToastPlugin()
}

module.exports = new ToastPlugin();
