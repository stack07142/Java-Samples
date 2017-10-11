import java.util.List;

public class MusicFeed {

    List<String> songList;

    MusicFeed(List<String> list) {

        this.songList = list;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        int i = 1;
        for (String song : songList) {

            sb.append((i++) + ". " + song + "\n");
        }

        return sb.toString();
    }
}
