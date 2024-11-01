package pagina;

public class Parrafo extends ComponenteWeb{
  public String tipo = "Párrafo";
  String texto;

  public Parrafo(String texto){
    this.texto = texto;
  }

  public String generarCodigoHTML(){
    return "  <p>%s</p>\n".formatted(texto);
  }
}
