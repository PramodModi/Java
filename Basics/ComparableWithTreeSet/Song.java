package ComparableWithTreeSet;

public class Song implements Comparable{
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
    public int compareTo(Object o) {
        Song s = (Song) o;
        return title.compareTo(s.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Song s = (Song) obj;
        return title.equals(s.getTitle());
    }

    @Override
    public String toString() {
        return "Title = " + title + "," + "Singer = " + singer + "," + "Rating = " + rating;
    }
}
