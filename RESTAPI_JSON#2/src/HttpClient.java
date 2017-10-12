import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    private URL url;
    private HttpURLConnection conn;
    private InputStream in;
    private OutputStream out;

    /* Constructor & Initializer -----------------------------------------------------------------------*/

    HttpClient() {

    }

    public void setupGetAPIClient(String api_url) {

        try {

            url = new URL(api_url);

            conn = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(conn.getInputStream());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void setupPostAPIClient(String api_url, String content) {

        try {

            url = new URL(api_url);

            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-type", "application/json");

            out = new DataOutputStream(conn.getOutputStream());
            out.write(content.getBytes());
            out.flush();

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {

                in = new BufferedInputStream(conn.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String line;
                StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null) sb.append(line);
                br.close();

                System.out.println(sb.toString());
            }
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
