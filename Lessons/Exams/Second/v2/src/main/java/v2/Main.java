package v2;

import java.util.ArrayList;

public class Main {
    static ArrayList<Show> shows = new ArrayList<>();

    public static void main(String[] args) {
        // Read API
        System.out.println("\nReading data from API...");
        Show BD_show3 = API.getShow("Breaking Bad", 3);
        System.out.println(BD_show3);

        int[] indexes = {0, 1, 3, 4};
        for(int i: indexes){
            Show BD_show = API.getShow("Breaking Bad", i);
            shows.add(BD_show);
        }

        System.out.println("\nSerializing and deserializing Show object...");
        // Save and load serialized class
        Serializar ser = new Serializar("BreakingBad");
        ser.Save(BD_show3);
        Show BD_show_deserialized = ser.Load();
        System.out.println(BD_show_deserialized);

        // Create table
        System.out.println("\nCreating table Shows...");
        DataBase DB = new DataBase("Shows");
        DB.CreateTable();

        // Import data
        System.out.println("\nImporting data...");
        for(Show show: shows){
            DB.insertShow(show);
        }        

        // Show table
        System.out.println("\nShowing table Shows...");
        DB.selectAllShows();

        // Delete show
        System.out.println("\nDeleting table Shows...");
        //DB.deleteShow(BD_show_deserialized);
        for(Show show: shows){
            DB.deleteShow(show);
        }
        DB.selectAllShows();
    }
}