package pagina;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class PaginaWeb implements Serializable{
  public String titulo;
  public String html_nombre;
  public String css_nombre;
  public ArrayList<ComponenteWeb> componentes = new ArrayList<>();
  public String estilos = "";
  public String plantilla;
  public String plantilla_final;
  public String path = "./archivos/";

  public PaginaWeb(String titulo){
    html_nombre=path+"index.html";
    css_nombre=path+"styles.css";
    this.titulo = titulo;

    plantilla = """
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>%s</title>
    <link rel="stylesheet" type="text/css" href="%s">
</head>
<body>
""".formatted(titulo, css_nombre);
  plantilla_final = """
      <!-- Pie de página -->
<footer>
    <p>&copy; 2024 Mi Empresa. Todos los derechos reservados.</p>
</footer>
</body>
</html>
""";
  }

  public PaginaWeb(String titulo, String html_nombre, String css_nombre){
    this.html_nombre = html_nombre;
    this.css_nombre = css_nombre;
    this.titulo = titulo;

    plantilla = """
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>%s</title>
    <link rel="stylesheet" type="text/css" href="%s">
</head>
<body>
""".formatted(titulo, css_nombre);
  plantilla_final = """
      <!-- Pie de página -->
<footer>
    <p>&copy; 2024 Mi Empresa. Todos los derechos reservados.</p>
</footer>
</body>
</html>
""";
  }

  public void agregarComponente(ComponenteWeb componente){
    componentes.add(componente);
  }
  
  public void generarHTML(){
    for (ComponenteWeb componenWeb : componentes) {
      plantilla += componenWeb.generarCodigoHTML();
    }
    plantilla = plantilla+plantilla_final;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path+html_nombre))) {
            writer.write(plantilla);
            System.out.println("Archivo html generado");
        } catch (IOException e) {
            e.printStackTrace();
        }
  }

  public void generarCSS(){
    Estilo estilo = new Estilo();
    String estilo_str = estilo.generarCSS();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path+css_nombre))) {
      writer.write(estilo_str);
      System.out.println("Archivo css generado");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String toString(){
    return plantilla;
  }
}
