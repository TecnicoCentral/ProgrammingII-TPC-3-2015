package pagina;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializadorPagina {
  public String path = "./archivos/";
  PaginaWeb pagina;

  public SerializadorPagina(PaginaWeb pagina){
    this.pagina = pagina;
  }

  public void serializarPagina(String nombre_archivo){
    // Serializar el objeto
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path+nombre_archivo+".ser"))) {
            oos.writeObject(pagina);
            System.out.println("Objeto serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
  }

  public PaginaWeb deserializarPagina(String nombre_archivo){
     // Deserializar el objeto
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path+nombre_archivo+".ser"))) {
          PaginaWeb paginaweb = (PaginaWeb) ois.readObject();
            System.out.println("Objeto deserializado:\n" + paginaweb);
            return paginaweb;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
  }
}
