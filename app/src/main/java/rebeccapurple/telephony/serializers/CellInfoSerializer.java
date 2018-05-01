package rebeccapurple.telephony.serializers;

import android.telephony.CellInfo;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class CellInfoSerializer extends rebeccapurple.json.Serializer<CellInfo> {
    @Override
    public JsonElement serialize(CellInfo info, Type type, JsonSerializationContext context) {
        if(info != null){
            JsonObject object = new JsonObject();
            object.add("registered", new JsonPrimitive(info.isRegistered()));
            object.add("timestamp", new JsonPrimitive(info.getTimeStamp()));
            return object;
        }
        return JsonNull.INSTANCE;
    }
}
