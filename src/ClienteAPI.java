import java.net.URI;   // importa la clase URI del paquete java.net, para definir la URL de la API que se está consultando
import java.net.http.HttpClient;  //Clases para realizar solicitudes HTTP.
import java.net.http.HttpRequest;  //Clases para realizar solicitudes HTTP.
import java.net.http.HttpResponse;  //Clases para realizar solicitudes HTTP.


public class ClienteAPI {

    public static String sendRequest(String url) {
        try {
            // Crea un cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            // Construye la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            // Envía la solicitud y obtiene la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica si la respuesta fue exitosa, (el estado es 200 (OK))
            if (response.statusCode() == 200) {
                return response.body(); // Retorna el cuerpo de la respuesta
            } else {
                System.out.println("Error: Código de respuesta HTTP " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la solicitud HTTP: " + e.getMessage());
        }
        return null; // Retorna null si ocurre un error
    }
}

