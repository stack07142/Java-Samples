import com.google.gson.annotations.SerializedName;

public class Anything {

    String data;
    String method;
    String origin;
    String url;
    Headers headers;

    Anything() {

    }

    @Override
    public String toString() {

        return "[AnyThing] \n"
                + "data: " + data + "\n"
                + "method: " + method + "\n"
                + "origin: " + origin + "\n"
                + "url: " + url + "\n"
                + "  headers >> Accept: " + headers.accept + "\n"
                + "  headers >> Accept: " + headers.acceptEncoding + "\n"
                + "  headers >> Accept: " + headers.acceptLanguage + "\n"
                + "  headers >> Accept: " + headers.connection + "\n"
                + "  headers >> Accept: " + headers.cookie + "\n"
                + "  headers >> Accept: " + headers.host + "\n"
                + "  headers >> Accept: " + headers.userAgent + "\n";
    }

    class Headers {

        @SerializedName("Accept")
        String accept;

        @SerializedName("Accept-Encoding")
        String acceptEncoding;

        @SerializedName("Accept-Language")
        String acceptLanguage;

        @SerializedName("Connection")
        String connection;

        @SerializedName("Cookie")
        String cookie;

        @SerializedName("Host")
        String host;

        @SerializedName("User-Agent")
        String userAgent;

        Headers() {

        }
    }
}
