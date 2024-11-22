import java.util.Scanner; 
import java.time.LocalDate;

public class Taller1{
  private String name = "Sebastian";
  private LocalDate date = java.time.LocalDate.now();
  
  public static void main(String[] args){

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Ingresa un número: ");
    String number = "25";//myObj.nextLine();        // Read user input
    System.out.println("Número ingresado: %s".formatted(number));
    
    // 1ero
    new Taller1().PrimerPunto();

    // 2do
    System.out.println("2DO PUNTO:");
    // No implementado

    // 3ro
    new Taller1().TercerPunto(number);
    // new Taller1().TercerPunto(Integer.parseInt(args[0])); // using the args variable

    // // 4to
    new Taller1().CuartoPunto();

    // // 5to
    new Taller1().QuintoPunto(Double.parseDouble(number));
    //new Taller1().QuintoPunto(Double.parseDouble(args[0]));
  }

  public void PrimerPunto(){
    System.out.print("""
    1ER PUNTO:
        Olá, %S, como você está hoje (%s)?
        La suma entre %d y %d es %d
        El modulo de %f y %d es %d
        """.formatted(name, date,  13, 5, 13+5,  13.22f, 2, 13%5));
  }

  public void TercerPunto(String porcentaje){
    new Porcentaje().Imprimir(porcentaje);
  }

  public void CuartoPunto(){
    // Imprimiendo fechas
    String string_date = "  Date: %1$td-%1$tm-%1$tY%n".formatted(date);
    System.out.print("""
      4TO PUNTO:
        Cinco decimales: %.5f
        No decimales: %.0f
        Hexadecimal de %d es: %x
        Notación cientifica con 3 digitos: %.2e
        Padded number (agregando 0s a la izquierda): %05d
        ¿Hoy tendras un buen día?: %b
        """.formatted(Math.PI,   // Cinco decimales
                      Math.PI,   // No decimales
                      255, 255,  // Números hexadecimales
                      Math.E,    // Notación cientifica con 3 digitos
                      420,       // Número con 7 espacios al inicio 
                      true)+string_date);    // Imprimiendo bolean
  }

  public void QuintoPunto(double temperatura){
    double celcius = (temperatura-32)*5/9;
    double fahrenheit = temperatura*9/5+32;

    System.out.print("""
    5TO PUNTO:
      %.3f C° son %.3f °F 
      %.3f F° son %.3f °C
        """.formatted(temperatura, celcius,
                      temperatura, fahrenheit));
  }
}

class Porcentaje{
  public void Imprimir(String number){
    int porcentaje = Integer.parseInt(number);
    if (porcentaje>=0 && porcentaje<=100) {
      System.out.print("3ER PUNTO:\n"+
                       "%d %%: %s%n".formatted(porcentaje, "#".repeat(porcentaje))+
                       "%d %%: %s%n".formatted(porcentaje/2, "#".repeat(porcentaje/2))+
                       "% 2d %%: %s%n".formatted(porcentaje/8, "#".repeat(porcentaje/8)));
      
    } 
    else{
      System.out.println("  ¡ERROR!: Intenta de nuevo, el número que ingresaste no esta en el rango de 0 a 100.");
    }
    
  } 
}