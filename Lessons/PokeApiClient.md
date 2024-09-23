# Ejemplo PokeAPI

---

- [Ejemplo PokeAPI](#ejemplo-pokeapi)
  - [Dependencias necesarias:](#dependencias-necesarias)
  - [Código en Java](#código-en-java)
  - [Descripción del Código:](#descripción-del-código)
  - [Ejemplo de Salida:](#ejemplo-de-salida)


---

Aquí te presento un ejemplo de código en Java que realiza una consulta al API de PokeAPI. Usaremos `HttpURLConnection` para hacer la solicitud HTTP GET y la biblioteca `org.json` para procesar la respuesta en formato JSON.

## Dependencias necesarias:
Para manejar las respuestas JSON, utilizaremos la biblioteca `org.json`. Puedes agregarla en tu proyecto de Maven de la siguiente manera, si es que usas Maven:

```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version>
</dependency>
```

## Código en Java

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class PokeApiClient {

    // Método para consultar el API de PokeAPI y obtener información de un Pokémon
    public static String getPokemonData(String pokemonName) {
        String urlString = "https://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder responseContent = new StringBuilder();

        try {
            // Crear objeto URL con la URL del Pokémon
            URL url = new URL(urlString);
            
            // Abrir la conexión
            connection = (HttpURLConnection) url.openConnection();
            
            // Establecer el método de solicitud como GET
            connection.setRequestMethod("GET");
            
            // Establecer tiempo de espera para la conexión
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            // Verificar el código de respuesta HTTP
            int status = connection.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("Error: " + status + " - No se pudo obtener información del Pokémon.");
            }

            // Leer la respuesta del servidor
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            // Convertir la respuesta en JSON y extraer algunos datos
            JSONObject pokemonJson = new JSONObject(responseContent.toString());

            // Obtener el nombre del Pokémon
            String name = pokemonJson.getString("name");

            // Obtener el peso del Pokémon
            int weight = pokemonJson.getInt("weight");

            // Obtener la lista de tipos del Pokémon
            String types = "";
            for (int i = 0; i < pokemonJson.getJSONArray("types").length(); i++) {
                types += pokemonJson.getJSONArray("types")
                            .getJSONObject(i)
                            .getJSONObject("type")
                            .getString("name");
                if (i < pokemonJson.getJSONArray("types").length() - 1) {
                    types += ", ";
                }
            }

            // Retornar los datos obtenidos
            return "Nombre: " + name + "\nPeso: " + weight + "\nTipos: " + types;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener los datos del Pokémon.";
        } finally {
            // Cerrar el lector y la conexión
            try {
                if (reader != null) reader.close();
                if (connection != null) connection.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Consultar los datos de un Pokémon (ejemplo: "pikachu")
        String pokemonInfo = getPokemonData("pikachu");
        System.out.println(pokemonInfo);
    }
}
```

## Descripción del Código:
1. **URL de la API**: Se construye la URL usando el nombre del Pokémon proporcionado. Por ejemplo, si quieres obtener datos de "Pikachu", la URL es `https://pokeapi.co/api/v2/pokemon/pikachu`.

2. **Conexión HTTP**: Se establece una conexión HTTP con el método `GET`. Si la respuesta es exitosa (código de estado 200), se procede a leer el contenido de la respuesta.

3. **Procesamiento de JSON**: Se utiliza la clase `JSONObject` para interpretar la respuesta JSON. Se obtienen campos como el nombre del Pokémon, su peso y sus tipos.

4. **Estructura**: El código está estructurado para manejar excepciones y garantizar que los recursos, como las conexiones y los lectores, se cierren adecuadamente.

5. **Prueba**: En el método `main`, se hace una prueba solicitando la información del Pokémon "Pikachu". El resultado se imprime en la consola.

## Ejemplo de Salida:
```
Nombre: pikachu
Peso: 60
Tipos: electric
```

Este es un ejemplo básico que puedes extender para obtener más información de otros endpoints de la PokeAPI o manejar datos adicionales como habilidades, estadísticas, entre otros.