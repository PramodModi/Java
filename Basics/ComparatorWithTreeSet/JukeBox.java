package ComparatorWithTreeSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class JukeBox {
    class TitleComparator implements Comparator<Song>{
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
    ArrayList<Song> songList = new ArrayList<>();
    void getSongsFromFile(String fileName){
        try {
            //Reading from file.
            FileReader file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            while((line = reader.readLine()) != null){
                String [] tokens = line.split("/");
                songList.add(new Song(tokens[0], tokens[1], tokens[2]));

            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JukeBox jb = new JukeBox();
        jb.go();

    }
    public void go(){
        getSongsFromFile("songlist.txt");
        //Print all songs. It will use toString method of Song class.
        System.out.println(songList);
        // Ordered Set
        Set<Song> orderedSong = new TreeSet<>(new TitleComparator());
        orderedSong.addAll(songList);
        //Print song list in Ascending order
        System.out.println(orderedSong);
    }
}
