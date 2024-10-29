package secondv1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Files {
  public static String path = "/home/saguileran/Documentos/ETITC-2024-2/ProgrammingII-TPC-3-2015/Lessons/Exams/v1/src/main/java/secondv1/Records/";

    public static void Save(Record record, String name) {
        // Serializar el objeto
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("%s%s.ser".formatted(path, name)))) {
            oos.writeObject(record);
            System.out.println("  Record saved sucesfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Import(String name) {
        // Deserializar el objeto
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("%s%s.ser".formatted(path, name)))) {
            Record record = (Record) ois.readObject();
            System.out.println("\nRecord imported sucesfully!\n"+record);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
