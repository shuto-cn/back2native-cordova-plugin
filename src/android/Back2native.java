package back2native;

import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;


/**
 * This class echoes a string called from JavaScript.
 */
public class Back2native extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("back")) {
            return this.goBack(callbackContext);
        }
        return false;
    }

    private boolean goBack(CallbackContext callbackContext) {
        try {
            this.cordova.getActivity().finish();
//            // try to send it back and back to previous app
//            boolean sentAppToBackground = this.cordova.getActivity().moveTaskToBack(true);
//
//            // if not possible jump to home
//            if (!sentAppToBackground) {
//                Intent i = new Intent(Intent.ACTION_MAIN);
//                i.setAction(Intent.ACTION_MAIN);
//                i.addCategory(Intent.CATEGORY_HOME);
//                this.cordova.getActivity().startActivity(i);
//            }
            callbackContext.success();
            return true;

        } catch (Exception e) {
            Log.e(Back2native.class.getSimpleName(), "Exception occurred: ".concat(e.getMessage()));
            return false;
        }
    }

    private boolean goHome(CallbackContext callbackContext) {
        try {
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            this.cordova.getActivity().startActivity(i);
            callbackContext.success();
            return true;

        } catch (Exception e) {
            Log.e(Back2native.class.getSimpleName(), "Exception occurred: ".concat(e.getMessage()));
            return false;
        }
    }
}
