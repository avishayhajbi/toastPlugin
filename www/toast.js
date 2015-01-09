window.toast = function(str){
    cordova.exec(function(su){console.log("ok")}, function(err){alert(err)},"ToastPlugin","echo", [str]);
}