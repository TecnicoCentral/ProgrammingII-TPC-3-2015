package v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class API {
    public static Show getShow(String show_name, Integer index) {
        String urlString = "https://api.tvmaze.com/search/shows?q=" + show_name.toLowerCase().replace(" ", "%20");
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL(urlString);
            
            connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("Error: " + status + " - No se pudo obtener información del show.");
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            JSONArray show_array = new JSONArray(responseContent.toString());
            JSONObject show3 = show_array.getJSONObject(index);
            JSONObject show_bd = show3.getJSONObject("show");

            String name = show_bd.getString("name");
            String url_bd = show_bd.getString("url");
            String language = show_bd.getString("language");
            String type = show_bd.getString("type");
            String officialSite	 = show_bd.getString("officialSite");
            Integer id	 = show_bd.getInt("id");
            
            Show BD_show = new Show(id, name, url_bd, officialSite, language, type);

            return BD_show;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) reader.close();
                if (connection != null) connection.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}