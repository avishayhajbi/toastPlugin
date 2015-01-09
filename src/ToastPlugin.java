package com.plugin;

//import com.avishayhajbi.finance.R;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
//json parse
import org.json.JSONObject;
//toast
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.app.AlarmManager;



public class ToastPlugin extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if(action.equals("echo")){
          final String message = args.getString(0); 
          	cordova.getActivity().runOnUiThread(new Runnable() { //cordova.getThreadPool().execute(new Runnable() {
	        	public void run() {
                    Mytoast myts =  new Mytoast(message);
		            android.widget.Toast toast = android.widget.Toast.makeText(webView.getContext(),myts.name , 0);
		           	toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 20);
		           	toast.setDuration(android.widget.Toast.LENGTH_LONG);
					toast.show();
		       		callbackContext.success("java returning value");
	            }
            });
            return true;
        }
      	callbackContext.error("unknown");
      	return false;
    }
}
