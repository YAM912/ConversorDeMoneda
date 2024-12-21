import java.util.Scanner;  // Captura la entrada del usuario.

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);  // Lectura del teclado para entrada de datos
        String apiKey = "5f9c01bfc8cfa142848975c4"; // Clave de la API
        String baseApiUrl = "https://v6.exchangerate-api.com/v6/";  // URL de la API
        HistorialDeConversiones historial = new HistorialDeConversiones();  // Objeto para registrar el historial

        // Bucle infinito hasta que el usuario decida salir
        while (true) {
            // Menú principal
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1) Euro (EUR) => Peso Colombiano (COP)");
            System.out.println("2) Peso Colombiano (COP) => Euro (EUR)");
            System.out.println("3) Dollar (USD) => Peso Colombiano (COP)");
            System.out.println("4) Peso Colombiano (COP) => Dollar (USD)");
            System.out.println("5) Dollar (USD) => Peso Argentino (ARS)");
            System.out.println("6) Peso Argentino (ARS) => Dollar (USD)");
            System.out.println("7) Dollar (USD) => Real Brasileño (BRL)");
            System.out.println("8) Real Brasileño (BRL) => Dollar (USD)");
            System.out.println("9) Dollar (USD) => Peso Mexicano (MXN)");
            System.out.println("10) Peso Mexicano (MXN) => Dollar (USD)");
            System.out.println("11) Ver Historial de Conversiones");
            System.out.println("12) Salir");
            System.out.print("Elija una opción válida: ");

            int opcion = teclado.nextInt(); // Lee la opción del usuario

            // Si la opción es 12, salir del programa
            if (opcion == 12) {
                System.out.println("Saliendo del programa...");
                break;
            }

            // Mostrar historial de conversiones
            if (opcion == 11) {
                historial.mostrarHistorial();
                continue; // Regresar al inicio del bucle
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = teclado.nextDouble(); // Lee la cantidad ingresada por el usuario

            String monedaDeOrigen = "", monedaDeDestino = "";

            // Determina las monedas según la opción seleccionada
            switch (opcion) {
                case 1 -> {
                    monedaDeOrigen = "EUR";
                    monedaDeDestino = "COP";
                }
                case 2 -> {
                    monedaDeOrigen = "COP";
                    monedaDeDestino = "EUR";
                }
                case 3 -> {
                    monedaDeOrigen = "USD";
                    monedaDeDestino = "COP";
                }
                case 4 -> {
                    monedaDeOrigen = "COP";
                    monedaDeDestino = "USD";
                }
                case 5 -> {
                    monedaDeOrigen = "USD";
                    monedaDeDestino = "ARS";
                }
                case 6 -> {
                    monedaDeOrigen = "ARS";
                    monedaDeDestino = "USD";
                }
                case 7 -> {
                    monedaDeOrigen = "USD";
                    monedaDeDestino = "BRL";
                }
                case 8 -> {
                    monedaDeOrigen = "BRL";
                    monedaDeDestino = "USD";
                }
                case 9 -> {
                    monedaDeOrigen = "USD";
                    monedaDeDestino = "MXN";
                }
                case 10 -> {
                    monedaDeOrigen = "MXN";
                    monedaDeDestino = "USD";
                }
                default -> {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue; // Regresar al inicio del bucle
                }
            }

            // Llamado al metodo para obtener la tasa de cambio
            double tasaDeCambio = ConversorDeMoneda.getExchangeRate(apiKey, baseApiUrl, monedaDeOrigen, monedaDeDestino);

            if (tasaDeCambio != -1) {
                // Realiza la conversión y muestra el resultado
                double convertirCantidad = cantidad * tasaDeCambio;
                String resultadoFormateado = FormatearMoneda.formatConversion(cantidad, convertirCantidad, monedaDeOrigen, monedaDeDestino);
                System.out.println(resultadoFormateado);
                // Registrar la conversión en el historial
                historial.agregarRegistro(cantidad, tasaDeCambio, monedaDeOrigen, monedaDeDestino);
            } else {
                System.out.println("Error al obtener la tasa de cambio, porque la moneda no existe o falló la API.");
            }
        }

        teclado.close(); // Cierra el Scanner después de salir del bucle
    }
}


