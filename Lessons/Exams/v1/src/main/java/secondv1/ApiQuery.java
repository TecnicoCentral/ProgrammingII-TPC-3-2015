package secondv1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiQuery {
  
    public static Record getAudios(String ciudad, int index) {
        String urlString = "https://xeno-canto.org/api/2/recordings?query=loc:" + ciudad.toLowerCase().replace(" ", "%20");
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Establecer tiempo de espera para la conexión
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            // Verificar el código de respuesta HTTP
            int status = connection.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("Error: " + status + " - No se pudo obtener información de la ciudad.");
            }

            // Leer la respuesta del servidor
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            // Convertir la respuesta en JSON y extraer algunos datos
            JSONObject all_audios = new JSONObject(responseContent.toString());
            JSONArray recordings = all_audios.getJSONArray("recordings");
            JSONObject single_record = recordings.getJSONObject(index);
            
            Integer id = Integer.parseInt(single_record.getString("id"));
            String gen = single_record.getString("gen");
            String loc = single_record.getString("loc");
            String name_en = single_record.getString("en");
            String file_url = single_record.getString("file");

            Record record = new Record(id, gen, loc, name_en, file_url);
            return record;

        } catch (Exception e) {
            e.printStackTrace();
            Record empty =  new Record();
            return empty;
        } finally {
            try {
                if (reader != null) reader.close();
                if (connection != null) connection.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Record bogotaInfo = getAudios("bogota", 15);
        System.out.println(bogotaInfo);
    }
}