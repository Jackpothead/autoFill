package ae.unitconsulting.cordova.plugin;

// The native Toast API
import android.widget.Toast;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.autofill.AutofillManager;
import android.content.Context;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;



public class ToastyPlugin extends CordovaPlugin {
  
  private static final String DURATION_LONG = "long";
  
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
      
      // Verify that the user sent a 'show' action
      if (!action.equals("show")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
      cordova.getActivity().runOnUiThread(new Runnable() {
        @SuppressWarnings("ResourceType")
        @Override
        public void run() {

            final CordovaActivity cordovaActivity = (CordovaActivity) cordova.getActivity();

            ViewGroup mainViewGroup = (ViewGroup) webView.getView().getParent();

            ViewGroup rootView = (ViewGroup) mainViewGroup.getParent();

            rootView.setImportantForAutofill(IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
        }
      });
      return true;
  }
}