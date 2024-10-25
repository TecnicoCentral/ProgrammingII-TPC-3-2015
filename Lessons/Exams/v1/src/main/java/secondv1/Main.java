package secondv1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        // Reading data from API
        System.out.println("Querying API...");
        Record audio1 = ApiQuery.getAudios("bogota", 1);
        Record audio2 = ApiQuery.getAudios("bogota", 2);
        Record audio3 = ApiQuery.getAudios("bogota", 3);
        Record audio4 = ApiQuery.getAudios("bogota", 4);
        Record audio5 = ApiQuery.getAudios("bogota", 5);
        Record audio15 = ApiQuery.getAudios("bogota", 15);
        
        ArrayList<Record> audios = new ArrayList<>();
        audios.add(audio1); audios.add(audio2); audios.add(audio3);
        audios.add(audio4); audios.add(audio5); audios.add(audio15);

        for(Record record: audios){
            String id = String.valueOf(record.id);
            System.out.println(record);
            Files.Save(record, id);
            System.out.println("");
        }
        
        System.out.println("\nDroping table if exists...");
        DropTable.Drop();
        
        System.out.println("\nCreating table...");
        CreateTable.Create();

        System.out.println("\nInserting values...");
        for(Record record: audios){
            InsertValue.Insert(record);
        }
        
        System.out.println("\nShowing table...");
        SelectTable.Show();

        System.out.println("\nImporting object from .ser file...");
        Files.Import("261549");

    }
}