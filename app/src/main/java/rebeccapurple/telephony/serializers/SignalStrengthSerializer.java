package rebeccapurple.telephony.serializers;

import android.os.Build;
import android.telephony.SignalStrength;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class SignalStrengthSerializer extends rebeccapurple.json.Serializer<SignalStrength>{
    public JsonObject cdma(SignalStrength o){
        JsonObject object = new JsonObject();
        object.add("dbm", new JsonPrimitive(o.getCdmaDbm()));
        object.add("ecio", new JsonPrimitive(o.getCdmaEcio()));
        return object;
    }

    public JsonObject evdo(SignalStrength o){
        JsonObject object = new JsonObject();
        object.add("dbm", new JsonPrimitive(o.getEvdoDbm()));
        object.add("ecio", new JsonPrimitive(o.getEvdoEcio()));
        object.add("snr", new JsonPrimitive(o.getEvdoSnr()));
        return object;
    }

    public JsonObject gsm(SignalStrength o){
        JsonObject object = new JsonObject();
        object.add("bit error rate", new JsonPrimitive(o.getGsmBitErrorRate()));
        object.add("strength", new JsonPrimitive(o.getGsmSignalStrength()));
        return object;
    }

    @Override
    public JsonElement serialize(SignalStrength o, Type type, JsonSerializationContext context) {
        if(o != null){
            JsonObject object = new JsonObject();
            object.add("cdma", cdma(o));
            object.add("evdo", evdo(o));
            object.add("gsm", gsm(o));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                object.add("level", new JsonPrimitive(o.getLevel()));
            }
            return object;
        }
        return JsonNull.INSTANCE;
    }
}
