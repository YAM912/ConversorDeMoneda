import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;  // Se utilizan para analizar y manipular JSON.

public class ConversorDeMoneda {

    public static double getExchangeRate(String apiKey, String baseApiUrl, String fromCurrency, String toCurrency) {
        try {
            // Construcción de la URL de solicitud a la API
            String requestUrl = baseApiUrl + apiKey + "/latest/" + fromCurrency;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .build();

            // Llamada al cliente HTTP para obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica si la respuesta es válida y parsea los datos
            if (response.statusCode() == 200) {
                JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
                return conversionRates.get(toCurrency).getAsDouble();
            } else {
                System.out.println("Error: Código de respuesta HTTP " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }

        // Retorna -1 si ocurre un error
        return -1;
    }
}



