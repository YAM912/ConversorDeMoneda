import java.text.DecimalFormat;  // Importa la clase DecimalFormat del paquete java.text, que se utiliza para dar formato a números decimales.

// Metodos para dar formato a cantidades monetarias.
public class FormatearMoneda {

    /*
     * Metodo estático que formatea las cantidades de dinero y genera una representación amigable de la conversión.
     *
     * @param amount         La cantidad inicial ingresada por el usuario (cantidad a convertir).
     * @param convertedAmount La cantidad resultante después de aplicar la tasa de conversión.
     * @param fromCurrency    La moneda de origen (por ejemplo, USD, COP, etc.).
     * @param toCurrency      La moneda de destino (por ejemplo, COP, USD, etc.).
     * @return                Una cadena de texto que muestra las cantidades formateadas y las monedas involucradas.
     */

    public static String formatConversion(double amount, double convertedAmount, String fromCurrency, String toCurrency) {

        // Crea una instancia de DecimalFormat para formatear números decimales con el patrón "#,##0.00".
        // El patrón "#,##0.00" asegura que el número tendrá comas como separadores de miles y dos decimales.
        DecimalFormat formatter = new DecimalFormat("#,##0.00");

        // Formatea la cantidad original (amount) al formato definido.
        String formattedAmount = formatter.format(amount);

        // Formatea la cantidad convertida (convertedAmount) al mismo formato.
        String formattedConverted = formatter.format(convertedAmount);

        // String.format para construir una cadena de texto en el formato:
        // "[cantidad formateada] [moneda origen] = [cantidad convertida formateada] [moneda destino]"
        return String.format("%s %s = %s %s", formattedAmount, fromCurrency, formattedConverted, toCurrency);
    }
}
