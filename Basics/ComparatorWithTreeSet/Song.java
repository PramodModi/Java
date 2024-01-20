package ComparatorWithTreeSet;

public class Song {
    String title;
    String singer;
    String rating;
    public Song(String title, String singer, String rating){
        this.title = title;
        this.rating = rating;
        this.singer = singer;
    }

    public String getRating() {
        return rating;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Title = " + title + "," + "Singer = " + singer + "," + "Rating = " + rating;
    }
}
