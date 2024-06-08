import com.google.gson.Gson; // Biblioteca para convertir objetos Java a JSON y viceversa
import com.google.gson.JsonObject; // Clase para representar un objeto JSON
import com.google.gson.JsonParser; // Clase para analizar y parsear JSON

import java.io.IOException; // Excepción que se lanza cuando hay un problema de entrada/salida
import java.net.URI; // Clase para representar una URL o URI
import java.net.http.HttpClient; // Cliente HTTP para realizar solicitudes web
import java.net.http.HttpRequest; // Solicitud HTTP para enviar al servidor
import java.net.http.HttpResponse; // Respuesta HTTP recibida del servidor

// Clase que se encarga de realizar consultas a la API de tipos de cambio.
public class Consulta {
    // Clave de la API para autenticar las solicitudes.
    private static final String API_KEY = "4dd8d06296bad5fa724b1eb1";
    // URL base de la API de tipos de cambio.
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    /*
     * Método para convertir una cantidad de una moneda a otra.
     *
     * @param primerMoneda La moneda de origen.
     * @param segundaMoneda La moneda de destino.
     * @param cantidad La cantidad a convertir.
     * @return Un objeto Moneda con los detalles de la conversión.
     */
    public Moneda convertirMoneda(String primerMoneda, String segundaMoneda, double cantidad) {
        // Construye la URI para la solicitud a la API.
        URI link = URI.create(BASE_URL + primerMoneda);
        // Crea un cliente HTTP.
        HttpClient client = HttpClient.newHttpClient();
        // Construye la solicitud HTTP.
        HttpRequest request = HttpRequest.newBuilder().uri(link).build();
        try {
            // Envía la solicitud y obtiene la respuesta.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Analiza la respuesta JSON.
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
            // Obtiene la tasa de conversión para la moneda de destino.
            double conversionRate = conversionRates.get(segundaMoneda).getAsDouble();

            // Calcula el resultado de la conversión.
            double conversionResult = cantidad * conversionRate;

            // Retorna un nuevo objeto Moneda con los detalles de la conversión.
            return new Moneda(primerMoneda, segundaMoneda, conversionRate, conversionResult);
        } catch (IOException | InterruptedException e) {
            // Lanza una excepción en caso de error.
            throw new RuntimeException("Error al convertir moneda: " + e.getMessage(), e);
        }
    }

    /*
     * Método para obtener la tasa de conversión entre dos monedas.
     *
     * @param primerMoneda La moneda de origen.
     * @param segundaMoneda La moneda de destino.
     * @return Un objeto Moneda con los detalles de la tasa de conversión.
     */
    public Moneda tazaConversionPar(String primerMoneda, String segundaMoneda) {
        // Construye la URI para la solicitud a la API.
        URI link = URI.create(BASE_URL + primerMoneda);
        // Crea un cliente HTTP.
        HttpClient client = HttpClient.newHttpClient();
        // Construye la solicitud HTTP.
        HttpRequest request = HttpRequest.newBuilder().uri(link).build();
        try {
            // Envía la solicitud y obtiene la respuesta.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Analiza la respuesta JSON.
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
            // Obtiene la tasa de conversión para la moneda de destino.
            double conversionRate = conversionRates.get(segundaMoneda).getAsDouble();

            // Retorna un nuevo objeto Moneda con los detalles de la tasa de conversión.
            return new Moneda(primerMoneda, segundaMoneda, conversionRate, 0);
        } catch (IOException | InterruptedException e) {
            // Lanza una excepción en caso de error.
            throw new RuntimeException("Error al obtener tasa de conversión: " + e.getMessage(), e);
        }
    }

    /*
     * Método para obtener el código ISO de una moneda.
     *
     * @param divisa La divisa de la que se desea obtener el código ISO.
     * @return Un objeto Moneda con los detalles del código ISO.
     */
    public Moneda tazaConversionMoneda(String divisa) {
        // Construye la URI para la solicitud a la API.
        URI link = URI.create("https://open.er-api.com/v6/latest/" + divisa);
        // Crea un cliente HTTP.
        HttpClient client = HttpClient.newHttpClient();
        // Construye la solicitud HTTP.
        HttpRequest request = HttpRequest.newBuilder().uri(link).build();
        try {
            // Envía la solicitud y obtiene la respuesta.
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Analiza la respuesta JSON.
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            // Retorna un objeto Moneda a partir del JSON analizado.
            return new Gson().fromJson(jsonResponse, Moneda.class);
        } catch (IOException | InterruptedException e) {
            // Lanza una excepción en caso de error.
            throw new RuntimeException("Moneda no encontrada: " + e.getMessage(), e);
        }
    }
}