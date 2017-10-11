import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    private URL url;
    private HttpURLConnection conn;
    private InputStream in;

    /* Constructor & Initializer -----------------------------------------------------------------------*/

    HttpClient() {

    }

    public void setupAPIClient(String api_url) {

        try {

            url = new URL(api_url);

            conn = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(conn.getInputStream());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /* Functions --------------------------------------------------------------------------------------*/

    /**
     * Nested Classes (including Inner Classes) Parsing Example
     */
    public Anything getAnything() {

        Gson gson = new Gson();
        Anything any = gson.fromJson(new InputStreamReader(in), Anything.class);

        return any;
    }

    /**
     * Nested Classes Parsing Example - With Custom Serialization and Deserialization
     */
    public MusicFeed getMusicFeed() {

        Gson gson = new GsonBuilder().registerTypeAdapter(MusicFeed.class, new TopSongDeserializer()).create();
        MusicFeed musicFeed = gson.fromJson(new InputStreamReader(in), MusicFeed.class);

        return musicFeed;
    }

    /**
     * Array Parsing Example
     */
    public Album[] getAlbums() {

        Gson gson = new Gson();
        Album[] albums = gson.fromJson(new InputStreamReader(in), Album[].class);

        return albums;
    }
}
