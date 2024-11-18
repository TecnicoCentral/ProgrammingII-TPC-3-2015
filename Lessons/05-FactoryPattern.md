# Patrón Factory

## 1. ¿Qué es el Patrón Factory?

El **Patrón Factory** es un patrón de diseño creacional que tiene como objetivo delegar la responsabilidad de instanciar objetos a una clase especializada conocida como "Factory" (fábrica). En lugar de crear objetos directamente con el operador `new`, se utiliza un método especializado en la clase Factory que decide qué tipo de objeto debe ser instanciado.

Este patrón es útil cuando no conocemos de antemano el tipo exacto de objetos que se crearán o cuando se requiere flexibilidad para decidir qué objeto devolver en tiempo de ejecución.


### Ventajas del Patrón Factory
- **Desacoplamiento**: El patrón separa la lógica de creación de objetos de su uso, mejorando la flexibilidad y mantenibilidad del código.
- **Reutilización de código**: Facilita la reutilización al centralizar la creación de objetos.
- **Fácil extensión**: Permite agregar nuevos tipos de objetos sin modificar el código cliente.
- **Control sobre la instancia**: El patrón Factory puede gestionar la cantidad de instancias creadas, incluyendo singletons.


## 2. Ejemplo básico del Patrón Factory en Java

A continuación, veremos un ejemplo básico del Patrón Factory aplicado en Java.

### Ejemplo: Crear diferentes tipos de transporte (Coche y Bicicleta)

1. Primero, creamos una interfaz que define un método común para los tipos de transporte:
```java
// Interfaz Transporte
public interface Transporte {
    void conducir();
}
```

2. Luego, implementamos las clases concretas que representan tipos específicos de transporte:
```java
// Clase Coche que implementa Transporte
public class Coche implements Transporte {
    @Override
    public void conducir() {
        System.out.println("Conduciendo un coche...");
    }
}

// Clase Bicicleta que implementa Transporte
public class Bicicleta implements Transporte {
    @Override
    public void conducir() {
        System.out.println("Montando una bicicleta...");
    }
}
```

3. Ahora, creamos la clase Factory que decide qué tipo de transporte instanciar:
```java
// Clase Factory de Transporte
public class TransporteFactory {

    // Método que devuelve un tipo de transporte dependiendo del parámetro
    public static Transporte getTransporte(String tipo) {
        if (tipo.equalsIgnoreCase("COCHE")) {
            return new Coche();
        } else if (tipo.equalsIgnoreCase("BICICLETA")) {
            return new Bicicleta();
        }
        return null; // Si no coincide, devuelve null
    }
}
```

4. Finalmente, utilizamos la clase Factory para crear instancias de `Transporte` sin conocer los detalles internos:
```java
public class Main {
    public static void main(String[] args) {
        // Crear un coche usando el Factory
        Transporte coche = TransporteFactory.getTransporte("COCHE");
        coche.conducir(); // Salida: Conduciendo un coche...
        
        // Crear una bicicleta usando el Factory
        Transporte bicicleta = TransporteFactory.getTransporte("BICICLETA");
        bicicleta.conducir(); // Salida: Montando una bicicleta...
    }
}
```

## 3. Aplicabilidad del Patrón Factory

El Patrón Factory se utiliza en diversas situaciones donde se requiere flexibilidad en la creación de objetos:

- **Cuando el proceso de creación es complejo**: En algunos casos, el proceso de creación de objetos puede incluir múltiples pasos, lo que hace conveniente encapsular la lógica de creación en una clase Factory.
  
- **Cuando se necesita devolver diferentes objetos**: Por ejemplo, si se está creando una aplicación de mensajería, el patrón Factory podría decidir si devolver un mensaje SMS, un mensaje de correo electrónico o una notificación push, dependiendo del tipo de comunicación requerida.

- **Cuando se desea mejorar la mantenibilidad**: Si el tipo de objetos a crear cambia con frecuencia, se puede modificar solo la clase Factory sin afectar el código que utiliza dichos objetos.


### Ejemplo de Aplicación del Patrón Factory en un Sistema de Pedidos

En un sistema de pedidos, podemos tener diferentes formas de pago (tarjeta de crédito, PayPal, transferencia bancaria), cada una con su propia lógica de procesamiento. El patrón Factory puede ayudar a simplificar la creación de los objetos de pago y la lógica asociada a cada uno:

1. Definir la interfaz `MetodoDePago`:
```java
public interface MetodoDePago {
    void procesarPago(double monto);
}
```

2. Implementar clases concretas para cada método de pago:
```java
public class TarjetaCredito implements MetodoDePago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con tarjeta de crédito: $" + monto);
    }
}

public class PayPal implements MetodoDePago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal: $" + monto);
    }
}
```

3. Crear la clase Factory para generar los métodos de pago:
```java
public class MetodoDePagoFactory {
    public static MetodoDePago getMetodoDePago(String tipo) {
        if (tipo.equalsIgnoreCase("TARJETA")) {
            return new TarjetaCredito();
        } else if (tipo.equalsIgnoreCase("PAYPAL")) {
            return new PayPal();
        }
        return null;
    }
}
```

4. Finalmente, se puede utilizar la clase Factory para manejar los pagos:
```java
public class Main {
    public static void main(String[] args) {
        MetodoDePago pago = MetodoDePagoFactory.getMetodoDePago("TARJETA");
        pago.procesarPago(150.00);
        
        MetodoDePago pago2 = MetodoDePagoFactory.getMetodoDePago("PAYPAL");
        pago2.procesarPago(200.00);
    }
}
```
