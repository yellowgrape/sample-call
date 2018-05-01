package rebeccapurple.telephony.serializers;

import android.telephony.ServiceState;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class ServiceStateSerializer extends rebeccapurple.json.Serializer<ServiceState> {
    private JsonObject operator(ServiceState state){
        JsonObject object = new JsonObject();
        object.add("alpha", alpha(state));
        object.add("numeric", new JsonPrimitive(state.getOperatorNumeric()));
        return object;
    }

    private JsonObject alpha(ServiceState state){
        JsonObject object = new JsonObject();
        object.add("long", new JsonPrimitive(state.getOperatorAlphaLong()));
        object.add("short", new JsonPrimitive(state.getOperatorAlphaShort()));
        return object;
    }

    @Override
    public JsonElement serialize(ServiceState state, Type type, JsonSerializationContext context) {
        if(state != null){
            JsonObject object = new JsonObject();
            object.add("manual selection", new JsonPrimitive(state.getIsManualSelection()));
            object.add("operator", operator(state));
            object.add("roaming", new JsonPrimitive(state.getRoaming()));
            object.add("operator", new JsonPrimitive(state.getState()));
            return object;
        }
        return JsonNull.INSTANCE;
    }
}
