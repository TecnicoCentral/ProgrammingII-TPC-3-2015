package pagina;

import java.io.Serializable;

public abstract class ComponenteWeb implements Serializable{
  public String tipo;

  public abstract String generarCodigoHTML();
  public void serializarComponente(){};

}
