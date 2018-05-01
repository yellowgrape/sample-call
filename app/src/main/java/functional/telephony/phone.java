package functional.telephony;

import android.telephony.TelephonyManager;

public class phone {
    private static String __data_activity_str(String parameter, int v){
        if(functional.string.equal(parameter, "direction")){
            switch(v){
                case TelephonyManager.DATA_ACTIVITY_DORMANT: return "dormant";
                case TelephonyManager.DATA_ACTIVITY_IN: return "in";
                case TelephonyManager.DATA_ACTIVITY_OUT: return "out";
                case TelephonyManager.DATA_ACTIVITY_INOUT: return "in/out";
                case TelephonyManager.DATA_ACTIVITY_NONE: return "none";
                default: return "unknown";
            }
        } else {
            functional.log.e("unsupported parameter");
        }
        return "unsupported";
    }

    private static String __data_connection_state_changed_str(String parameter, int v){
        if(functional.string.equal(parameter, "state")){
            switch(v){
                case TelephonyManager.DATA_DISCONNECTED: return "disconnected";
                case TelephonyManager.DATA_CONNECTING: return "connecting";
                case TelephonyManager.DATA_CONNECTED: return "connected";
                case TelephonyManager.DATA_SUSPENDED: return "suspended";
                default: return "unknown";
            }
        } else if(functional.string.equal(parameter, "networkType")){
            return functional.string.from(v);
        } else {
            functional.log.e("unsupported parameter");
        }
        return "unsupported";
    }

    private static String __call_state_changed_str(String parameter, int v){
        if(functional.string.equal(parameter, "state")){
            switch(v){
                case TelephonyManager.CALL_STATE_IDLE: return "idle";
                case TelephonyManager.CALL_STATE_RINGING: return "ringing";
                case TelephonyManager.CALL_STATE_OFFHOOK: return "offhook";
                default: return "unknown";
            }
        } else {
            functional.log.e("unsupported parameter");
        }
        return "unsupported";
    }

    public static String str(String listener, String parameter, int v){
        switch(listener){
            case "onDataActivity": return __data_activity_str(parameter, v);
            case "onDataConnectionStateChanged": return __data_connection_state_changed_str(parameter, v);
            case "onCallStateChanged": return __call_state_changed_str(parameter, v);
        }
        return "unknown";
    }
}
