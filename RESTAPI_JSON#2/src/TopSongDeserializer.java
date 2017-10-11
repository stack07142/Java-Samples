import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TopSongDeserializer implements JsonDeserializer<MusicFeed> {

    @Override
    public MusicFeed deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        final Gson gson = new Gson();

        final JsonObject obj = jsonElement.getAsJsonObject();

        final JsonElement feed = obj.get("feed");
        final JsonElement entry = feed.getAsJsonObject().get("entry");
        final JsonArray songArray = entry.getAsJsonArray();

        final List<String> songList = new ArrayList<>();

        for (Object object : songArray) {

            final JsonObject jsonObject = (JsonObject) object;

            final JsonElement title = jsonObject.get("title");
            final JsonElement label = title.getAsJsonObject().get("label");

            final String name = gson.fromJson(label, String.class);
            songList.add(name);
        }

        return new MusicFeed(songList);
    }
}
