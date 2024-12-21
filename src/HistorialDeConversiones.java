import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversiones {

    private final List<String> historial = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void agregarRegistro(double cantidad, double resultado, String monedaOrigen, String monedaDestino) {
        String marcaTiempo = LocalDateTime.now().format(formatter);
        String registro = String.format("[%s] %.2f %s = %.2f %s", marcaTiempo, cantidad, monedaOrigen, resultado, monedaDestino);
        historial.add(registro);

        // Limitar historial a las últimas 10 conversiones
        if (historial.size() > 10) {
            historial.remove(0);
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n=== Historial de Conversiones ===");
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            for (String registro : historial) {
                System.out.println(registro);
            }
        }
    }
}