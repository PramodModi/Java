package Serialization;

import java.io.*;
public class SerDeser{
    public static void main(String[] args){

        GamePlayer obj1 = new GamePlayer(1, "P1", new String[] {"Gold", "Silver", "Axe"});
        GamePlayer obj2 = new GamePlayer(2, "P2", new String[] {"Gold", "Iron", "Axe"});
        GamePlayer obj3 = new GamePlayer(3, "P3", new String[] {"Canon", "Silver", "Axe"});

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("gameplayer.ser"));
            os.writeObject(obj1);
            os.writeObject(obj2);
            os.writeObject(obj3);
            os.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }


        obj1 = null;
        obj2 = null;
        obj3 = null;

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("gameplayer.ser"));
            GamePlayer obj1Ser = (GamePlayer) is.readObject();
            GamePlayer obj2Ser = (GamePlayer) is.readObject();
            GamePlayer obj3Ser = (GamePlayer) is.readObject();
            is.close();

            System.out.println("Obj1 name: " + obj1Ser.getName());
            System.out.println("Obj2 name: " + obj2Ser.getName());
            System.out.println("Obj3 name: " + obj3Ser.getName());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
