package v2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializar {
  static String path = "/home/saguileran/Documentos/ETITC-2024-2/ProgrammingII-TPC-3-2015/Lessons/Exams/v2/";
  static String name;

  public Serializar(String name){
    Serializar.name = name;
  }
  public void Save(Show show) {
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+name+".ser"))) {
          oos.writeObject(show);
          System.out.println("Object serialized successfully!");
      } catch (IOException e) {
          e.printStackTrace();
      }
  } 

  public Show Load() {
        // Deserializar el objeto
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+name+".ser"))) {
            Show show = (Show) ois.readObject();
            System.out.println("Object deserialized successfully!\n");
            return show;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
