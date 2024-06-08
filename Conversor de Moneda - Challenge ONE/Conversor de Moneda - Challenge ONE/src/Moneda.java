/*
 * La clase Moneda representa la información de una conversión de moneda.
 * Utiliza la característica de 'record' de Java para definir una clase de datos.
 * Realiza validaciones para asegurar que los valores sean correctos.
 *
 * @param base_code         Código de la moneda de origen.
 * @param target_code       Código de la moneda de destino.
 * @param conversion_rate   Tasa de conversión de la moneda de origen a la moneda de destino.
 * @param conversion_result Resultado de la conversión de una cantidad específica de la moneda de origen a la moneda de destino.
 */
public record Moneda(String base_code, String target_code, double conversion_rate, double conversion_result) {
    public Moneda {
        // Validar que la tasa de conversión sea positiva.
        if (conversion_rate <= 0) {
            throw new IllegalArgumentException("La tasa de conversión debe ser positiva.");
        }
        // Validar que el resultado de la conversión no sea negativo.
        if (conversion_result < 0) {
            throw new IllegalArgumentException("El resultado de la conversión no puede ser negativo.");
        }
    }

    /*
     * Convierte una cantidad específica de la moneda base a la moneda objetivo.
     *
     * @param amount Cantidad de la moneda base a convertir.
     * @return Resultado de la conversión.
     */
    public double convertir(double amount) {
        // Multiplica la cantidad por la tasa de conversión para obtener el resultado.
        return amount * conversion_rate;
    }
}