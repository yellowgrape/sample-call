package rebeccapurple.telephony.serializers;

import android.telephony.CellLocation;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class CellLocationSerializer extends rebeccapurple.json.Serializer<CellLocation> {
    @Override
    public JsonElement serialize(CellLocation location, Type type, JsonSerializationContext context) {
        return JsonNull.INSTANCE;
    }
}
