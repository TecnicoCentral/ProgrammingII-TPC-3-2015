interface Volador {
  void volar(); // Método abstracto
}

class Pajaro implements Volador {
  public void volar() {
      System.out.println("El pájaro está volando.");
  }
}

public class Main {
  public static void main(String[] args) {
      Volador pajaro = new Pajaro();
      pajaro.volar();
  }
}
