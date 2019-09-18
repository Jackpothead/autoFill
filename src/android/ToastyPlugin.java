package ae.unitconsulting.cordova.plugin;

// The native Toast API
import android.widget.Toast;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.autofill.AutofillManager;
import android.content.Context;

public class ToastyPlugin extends CordovaPlugin {
  
  private static final String DURATION_LONG = "long";
  
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
      
      // Verify that the user sent a 'show' action
      if (!action.equals("show")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }

      Context context = this.cordova.getActivity().getApplicationContext();
      AutofillManager autofillManager = context.getSystemService(AutofillManager.class);
      autofillManager.disableAutofillServices();

      return true;
  }
}