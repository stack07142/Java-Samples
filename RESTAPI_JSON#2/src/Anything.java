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
                + "  headers >> Accept-Encoding: " + headers.acceptEncoding + "\n"
                + "  headers >> Accept-Language: " + headers.acceptLanguage + "\n"
                + "  headers >> Connection: " + headers.connection + "\n"
                + "  headers >> Cookie: " + headers.cookie + "\n"
                + "  headers >> Host: " + headers.host + "\n"
                + "  headers >> Referer: " + headers.referer + "\n"
                + "  headers >> User-Agent: " + headers.userAgent + "\n";
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

        @SerializedName("Referer")
        String referer;

        @SerializedName("User-Agent")
        String userAgent;

        Headers() {

        }
    }
}
