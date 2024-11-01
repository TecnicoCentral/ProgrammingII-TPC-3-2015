package pagina;

public class Titulo extends ComponenteWeb{
  public String tipo = "Título";
  String texto;
  String nivel;

  public Titulo(String texto, String nivel){
    this.texto = texto;
    this.nivel = nivel;
  }

  public String generarCodigoHTML(){
    return "  <%s>%s</%s>\n".formatted(nivel, texto, nivel);
  }
}
