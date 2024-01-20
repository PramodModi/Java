package ComparableWithTreeSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class JukeBox {
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
        jb.getSongsFromFile("songlist.txt");
        //Print all songs. It will use toString method of Song class.
        System.out.println(jb.songList);
        // Ordered Set
        Set<Song> orderedSong = new TreeSet<>();
        orderedSong.addAll(jb.songList);
        //Print song list in Ascending order
        System.out.println(orderedSong);

    }
}
