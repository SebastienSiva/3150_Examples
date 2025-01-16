import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Anime> readAnimeObj(String f) {
        try (
                //CREATE VARIABLES THAT CAN THROW EXCEPTIONS
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        ) {
            //DO RISKY STUFF
            ArrayList<Anime> aList = (ArrayList<Anime>) in.readObject();
            return aList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void writeAnimeObj(String f, ArrayList<Anime> aList) {
        try (
                //CREATE VARIABLES THAT CAN THROW EXCEPTIONS
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
        ) {
            //DO RISKY STUFF
            out.writeObject(aList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void writeAnimeCSV(String f, ArrayList<Anime> aList) {
        try (
                //CREATE VARIABLES THAT CAN THROW EXCEPTIONS
                PrintWriter out = new PrintWriter(new FileOutputStream(f));
        ) {
            //DO RISKY STUFF
            //for(int i = 0; ...)
            for(Anime a: aList) {
                out.println(a.getName() + "," + a.getNumEpisodes() + "," + a.getAvgLength());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Anime> readAnimeCSV(String f) {
        try (
            //CREATE VARIABLES THAT CAN THROW EXCEPTIONS
            Scanner in = new Scanner(new FileInputStream(f));
        ) {
            //DO RISKY STUFF
            ArrayList<Anime> aList = new ArrayList<Anime>();
            while(in.hasNext()) {
                String line = in.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int numEpi = Integer.parseInt(parts[1]);
                double avgLen = Double.parseDouble(parts[2]);
                aList.add(new Anime(name, numEpi, avgLen));
            }
            return aList;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        //ArrayList<Anime> myList = new ArrayList<Anime>();
        //myList.add(new Anime("Naruto", 800, 18.5));
        //System.out.println(readAnimeCSV("my_anime.csv"));
        ArrayList<Anime> myList = readAnimeCSV("my_anime.csv");
        myList.add(new Anime("Naruto", 800, 18.5));
        writeAnimeCSV("my_anime2.csv", myList);
        writeAnimeObj("my_anime.obj", myList);
        ArrayList<Anime> myList2 = readAnimeObj("my_anime.obj");
        System.out.println(myList2);
    }
}