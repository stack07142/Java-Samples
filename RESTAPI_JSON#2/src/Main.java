/**
 * REST API(HttpURLConnection) + GSON Parsing Example
 */
public class Main {

    public static void main(String[] args) {

        HttpClient httpClient = new HttpClient();

        System.out.println("*----------------------------------------------------------------------------------------*");
        System.out.println("|                                                                                        |");
        System.out.println("| 1. Nested Classes (including Inner Classes) Parsing Example                            |");
        System.out.println("|                                                                                        |");
        System.out.println("*----------------------------------------------------------------------------------------*");

        httpClient.setupAPIClient("https://httpbin.org/anything");
        Anything anything = httpClient.getAnything();

        System.out.println(anything.toString() + "\n\n");


        System.out.println("*----------------------------------------------------------------------------------------*");
        System.out.println("|                                                                                        |");
        System.out.println("| 2. Nested Classes Parsing Example - With Custom Serialization and Deserialization      |");
        System.out.println("|                                                                                        |");
        System.out.println("*----------------------------------------------------------------------------------------*");

        httpClient.setupAPIClient("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=25/json");
        MusicFeed musicFeed = httpClient.getMusicFeed();

        System.out.println(musicFeed.toString() + "\n\n");


        System.out.println("*----------------------------------------------------------------------------------------*");
        System.out.println("|                                                                                        |");
        System.out.println("| 3. Array Parsing Example                                                               |");
        System.out.println("|                                                                                        |");
        System.out.println("*----------------------------------------------------------------------------------------*");

        httpClient.setupAPIClient("https://jsonplaceholder.typicode.com/albums");
        Album[] albums = httpClient.getAlbums();

        for (Album album : albums) System.out.println(album.toString());

    }
}

