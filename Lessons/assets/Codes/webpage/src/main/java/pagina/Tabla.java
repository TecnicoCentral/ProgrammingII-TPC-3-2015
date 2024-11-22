package pagina;

public class Tabla extends ComponenteWeb{
  String[][] datos;

  public Tabla(String[][] datos){
    this.datos = datos;
  }

  public String generarCodigoHTML(){
    String html = "<table>\n";
    for(int i=0; i<datos.length; i++){
      String filas = "  <tr>\n";
      for(int j=0; j<datos[i].length; j++){
        if(i==0){
          filas += "    <th>%s</th>\n".formatted(datos[i][j]); 
        }
        else{
        filas += "    <td>%s</td>\n".formatted(datos[i][j]); 
        }
      }
      html += filas+"  </tr>\n";
    }
    return html+"</table>\n";
  }
}
