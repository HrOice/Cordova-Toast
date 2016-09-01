package com.hroice.cordova.plugin.toast;

import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by bowen on 16/9/1.
 */
public class ToastPlugin extends CordovaPlugin {

    private Toast toast = null;

    private final static Integer MESSAGE_INDEX = 0;

    private final static String SHOW_SHORT = "show_short";
    private final static String SHOW_LONG = "show_long";
    private final static String CANCEL = "cancel";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        String message ;
        if (action.equals(SHOW_SHORT)) {
            message = args.getString(MESSAGE_INDEX);
            showToast(message,Toast.LENGTH_SHORT);
        } else if (action.equals(SHOW_LONG)) {
            message = args.getString(MESSAGE_INDEX);
            showToast(message,Toast.LENGTH_LONG);
        } else if (action.equals(CANCEL)) {
            cancelToast();
        } else {
            LOG.e("error toast action",action);
            callbackContext.error(action);
            return true;
        }
        callbackContext.success();
        return true;
    }

    private void showToast(final String message, final int length) {
        cordova.getActivity().runOnUiThread(new Runnable(){

            @Override
            public void run() {
                toast = Toast.makeText(cordova.getActivity(), message, length);
                toast.show();
            }

        });
    }

    private void cancelToast() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toast != null){
                    toast.cancel();
                }
            }
        });
    }
}
