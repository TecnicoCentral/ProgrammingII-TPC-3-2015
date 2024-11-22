package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class api {

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