package pagina;

public class Imagen extends ComponenteWeb {
  public String tipo = "Imagen";
  String ruta;
  String texto;

  public Imagen(String ruta, String texto){
    this.ruta = ruta;
    this.texto = texto;
  }

  public String generarCodigoHTML(){
    return "    <img src='%s' alt='%s'>\n <br> <br>".formatted(ruta, texto);
  }

}
