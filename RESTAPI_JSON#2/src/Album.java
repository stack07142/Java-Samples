public class Album {

    String userId;
    String id;
    String title;

    Album() {

    }

    @Override
    public String toString() {

        return "[Album]\n"
                + "userId: " + userId + "\n"
                + "id: " + id + "\n"
                + "title: " + title + "\n";
    }
}
