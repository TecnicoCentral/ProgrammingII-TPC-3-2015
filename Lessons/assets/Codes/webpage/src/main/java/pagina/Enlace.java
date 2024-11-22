package pagina;

public class Enlace extends ComponenteWeb{
  public String tipo = "Enlace";
  String texto;
  String url;
  String target;

  public Enlace(String texto, String url, String target){
    this.texto = texto;
    this.url = url;
    this.target = target;
  }

  public String generarCodigoHTML(){
    return """
    <a href="%s" target="%s">%s</a>
    """.formatted(url, target, texto);
  }
}
