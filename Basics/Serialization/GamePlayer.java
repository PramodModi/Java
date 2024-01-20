package Serialization;

import java.io.*;
public class GamePlayer implements Serializable{
    int score;
    String name;
    String [] tools;
    public GamePlayer(int s, String n, String[] t){
        score = s;
        name = n;
        tools = t;
    }

    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }
    public String getTools(){
        String tool = "";
        for(String w : tools){
            tool += w;
        }
        return tool;
    }
}

