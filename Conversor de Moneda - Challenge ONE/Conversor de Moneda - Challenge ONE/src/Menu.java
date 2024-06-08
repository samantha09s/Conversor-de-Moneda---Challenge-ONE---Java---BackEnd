import com.google.gson.Gson; // Biblioteca para convertir objetos Java a JSON y viceversa.
import com.google.gson.GsonBuilder; // Constructor para crear instancias de Gson con opciones personalizadas.

import java.io.FileWriter; // Clase para escribir datos en un archivo de texto.
import java.io.IOException; // Excepción que se lanza cuando hay un problema de entrada/salida.
import java.util.Scanner; // Clase para leer datos de la entrada del usuario.

// Clase que representa el menú de un programa de conversión de monedas.
public class Menu {
    // Variables que almacenan información sobre las monedas.
    private String nombre = "";  // Nombre de la moneda.
    private String divisa = "";  // Código ISO de la moneda.
    private String primerMoneda = "";  // Moneda de origen para la conversión.
    private String segundaMoneda = "";  // Moneda de destino para la conversión.
    private final Scanner lectura = new Scanner(System.in);  // Objeto para leer la entrada del usuario.

    // Método que muestra el menú principal del programa.
    public void inicio() {
        System.out.println("""
                **Menú Principal**
                Seleccione la opción que desea realizar:
                ..............................................................
                    1. Consultar Tasa de Conversión Actual
                    2. Realizar Conversión de Moneda
                    3. Obtener Código ISO de la Moneda
                    4. Salir
                ..............................................................
                """);
    }

    // Método que maneja el menú para consultar tasas de conversión.
    public void firstMenu() throws IOException {
        // @throws IOException si ocurre un error al guardar el historial.
        int indice = 1;  // Contador de consultas realizadas.
        String historial = "";  // Historial de consultas.
        String nombreArchivo = "TasasConversion";  // Nombre del archivo para guardar el historial.

        // Bucle infinito para mostrar y procesar las opciones del usuario.
        while (true) {
            historial = "";  // Reiniciar historial.
            System.out.println("""
                    **Menú de Consulta de Tasas de Conversión**
                    Seleccione la conversión que desea realizar:
                    ..............................................................
                    1. Euro (EUR) -> Dólar (USD)
                    2. Dólar (USD) -> Euro (EUR)
                    3. Dólar (USD) -> Dólar Canadiense (CAD)
                    4. Dólar Canadiense (CAD) -> Dólar (USD)
                    5. Peso Argentino (ARS) -> Dólar (USD)
                    6. Dólar (USD) -> Peso Argentino (ARS)
                    7. Peso Mexicano (MXN) -> Dólar (USD)
                    8. Dólar (USD) -> Peso Mexicano (MXN)
                    9. Crear archivo con historial de consultas
                    10. Volver al inicio
                    ..............................................................
                    """);

            int choice = lectura.nextInt();  // Leer la opción seleccionada por el usuario.
            switch (choice) {
                case 1 -> {
                    primerMoneda = "EUR";
                    segundaMoneda = "USD";
                }
                case 2 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "EUR";
                }
                case 3 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "CAD";
                }
                case 4 -> {
                    primerMoneda = "CAD";
                    segundaMoneda = "USD";
                }
                case 5 -> {
                    primerMoneda = "ARS";
                    segundaMoneda = "USD";
                }
                case 6 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "ARS";
                }
                case 7 -> {
                    primerMoneda = "MXN";
                    segundaMoneda = "USD";
                }
                case 8 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "MXN";
                }
                case 9 -> guardarHistorial(historial, nombreArchivo);  // Guardar el historial de consultas.
                case 10 -> {
                    // Mensaje de salida y terminar el bucle.
                    System.out.println("**¡Hasta pronto! Gracias por usar el Conversor de Monedas Personalizado.**\n");
                    return;
                }
                default -> {
                    // Mensaje de error y continuar el bucle.
                    System.out.println("**Opción no válida. Por favor, seleccione una opción del menú.**\n");
                    continue;
                }
            }

            // Si se seleccionó una opción válida de conversión (1 a 8)
            if (choice >= 1 && choice <= 8) {
                // Crear una nueva instancia para realizar la consulta.
                Consulta consulta = new Consulta();
                Moneda moneda = consulta.tazaConversionPar(primerMoneda, segundaMoneda);
                // Resultado de la conversión.
                String resultado = String.format("La tasa de conversión de %s a %s es de: %.4f", primerMoneda, segundaMoneda, moneda.conversion_rate());
                System.out.println("................................................................\n" +
                        resultado + "\n" +
                        "................................................................\n");

                // Agregar el resultado al historial.
                historial += indice + "- " + resultado + "\n";
                indice++;
            }
        }
    }

    // Método que maneja el menú para realizar conversiones de monedas.
    public void secondMenu() throws IOException { // @throws IOException si ocurre un error al guardar el historial.
        int indice = 1;  // Contador de conversiones realizadas
        String historial = "";  // Historial de conversiones
        String nombreArchivo = "Conversiones";  // Nombre del archivo para guardar el historial

        // Bucle infinito para mostrar y procesar las opciones del usuario.
        while (true) {
            System.out.println("""
                    **Menú de Consulta de Tasas de Conversión**
                    Seleccione la conversión que desea realizar:
                    ..............................................................
                    1. Euro (EUR) -> Dólar (USD)
                    2. Dólar (USD) -> Euro (EUR)
                    3. Dólar (USD) -> Dólar Canadiense (CAD)
                    4. Dólar Canadiense (CAD) -> Dólar (USD)
                    5. Peso Argentino (ARS) -> Dólar (USD)
                    6. Dólar (USD) -> Peso Argentino (ARS)
                    7. Peso Mexicano (MXN) -> Dólar (USD)
                    8. Dólar (USD) -> Peso Mexicano (MXN)
                    9. Crear archivo con historial de consultas
                    10. Volver al inicio
                    ..............................................................
                    """);

            int choice = lectura.nextInt();  // Leer la opción seleccionada por el usuario.
            switch (choice) {
                case 1 -> {
                    primerMoneda = "EUR";
                    segundaMoneda = "USD";
                }
                case 2 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "EUR";
                }
                case 3 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "CAD";
                }
                case 4 -> {
                    primerMoneda = "CAD";
                    segundaMoneda = "USD";
                }
                case 5 -> {
                    primerMoneda = "ARS";
                    segundaMoneda = "USD";
                }
                case 6 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "ARS";
                }
                case 7 -> {
                    primerMoneda = "MXN";
                    segundaMoneda = "USD";
                }
                case 8 -> {
                    primerMoneda = "USD";
                    segundaMoneda = "MXN";
                }
                case 9 -> guardarHistorial(historial, nombreArchivo);  // Guardar el historial de conversiones.
                case 10 -> {
                    // Mensaje de salida y terminar el bucle.
                    System.out.println("**¡Hasta pronto! Gracias por usar el Conversor de Monedas Personalizado.**\n");
                    return;
                }
                default -> {
                    // Mensaje de error y continuar el bucle.
                    System.out.println("**Opción no válida. Por favor, seleccione una opción del menú.**\n");
                    continue;
                }
            }

            // Si se seleccionó una opción válida de conversión (1 a 8)
            if (choice >= 1 && choice <= 8) {
                // Solicitar al usuario el monto a convertir.
                System.out.println("Especifique el monto que desea convertir: ");
                double cantidad = lectura.nextDouble();

                // Realizar la conversión de moneda.
                Consulta consulta = new Consulta();
                Moneda moneda = consulta.convertirMoneda(primerMoneda, segundaMoneda, cantidad);
                String resultado = String.format("Resultado de conversión: %.2f (%s) equivalen a %.2f (%s)", cantidad, primerMoneda, moneda.conversion_result(), segundaMoneda);
                System.out.println("...............................................................\n"
                        + resultado + "\n"
                        + "...............................................................\n");

                // Agregar el resultado al historial.
                historial += indice + "- " + resultado + "\n";
                indice++;
            }
        }
    }

    // Método que maneja el menú para consultar códigos ISO de monedas.
    public void thirdMenu() throws IOException { // @throws IOException si ocurre un error al guardar el historial.
        int indice = 1;  // Contador de consultas realizadas.
        String historial = "";  // Historial de consultas.
        String nombreArchivo = "CodigosMonedas";  // Nombre del archivo para guardar el historial.

        // Bucle infinito para mostrar y procesar las opciones del usuario.
        while (true) {
            System.out.println("""
                **Consulta de Código ISO de Moneda**
                Seleccione el código de la moneda que desea obtener:
                ..............................................................
                    1. Euro (EUR)
                    2. Dólar Estadounidense (USD)
                    3. Dólar Canadiense (CAD)
                    4. Peso Argentino (ARS)
                    5. Libra Esterlina (GBP)
                    6. Real Brasileño (BRL)
                    7. Peso Mexicano (MXN)
                    8. Crear archivo con historial
                    9. Volver al inicio
                ..............................................................
                """);

            int choice = lectura.nextInt();  // Leer la opción seleccionada por el usuario.
            switch (choice) {
                case 1 -> {
                    nombre = "Euro";
                    divisa = "EUR";
                }
                case 2 -> {
                    nombre = "Dólar";
                    divisa = "USD";
                }
                case 3 -> {
                    nombre = "Dólar Canadiense";
                    divisa = "CAD";
                }
                case 4 -> {
                    nombre = "Peso Argentino";
                    divisa = "ARS";
                }
                case 5 -> {
                    nombre = "Libra Esterlina";
                    divisa = "GBP";
                }
                case 6 -> {
                    nombre = "Real Brasileño";
                    divisa = "BRL";
                }
                case 7 -> {
                    nombre = "Peso Mexicano";
                    divisa = "MXN";
                }
                case 8 -> guardarHistorial(historial, nombreArchivo);  // Guardar el historial de consultas.
                case 9 -> {
                    // Mensaje de salida y terminar el bucle.
                    System.out.println("**¡Hasta pronto! Gracias por usar el Conversor de Monedas Personalizado.**\n");
                    return;
                }
                default -> {
                    // Mensaje de error y continuar el bucle.
                    System.out.println("**Opción no válida. Por favor, seleccione una opción del menú.**\n");
                    continue;
                }
            }

            // Si se seleccionó una opción válida de consulta (1 a 7)
            if (choice >= 1 && choice <= 7) {
                // Crear una nueva instancia para realizar la consulta
                Consulta consulta = new Consulta();
                Moneda moneda = consulta.tazaConversionMoneda(divisa);
                // Resultado de la consulta
                String resultado = String.format("El código ISO de la divisa %s es: %s", nombre, moneda.base_code());
                System.out.println("........................................................................\n"
                        + resultado + "\n"
                        + "........................................................................\n");

                // Agregar el resultado al historial
                historial += indice + "- " + resultado + "\n";
                indice++;
            }
        }
    }

    /*
     * Método para guardar el historial en un archivo.
     * @param historial Contenido del historial a guardar.
     * @param nombreArchivo Nombre del archivo donde se guardará el historial.
     * @throws IOException si ocurre un error al escribir en el archivo.
     */
    private void guardarHistorial(String historial, String nombreArchivo) throws IOException {
        // Crear una instancia de Gson con formato bonito.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Crear un objeto FileWriter para escribir en el archivo.
        FileWriter escritura = new FileWriter(nombreArchivo);
        // Convertir el historial a JSON y escribirlo en el archivo.
        escritura.write(gson.toJson(historial));
        // Cerrar el archivo.
        escritura.close();
        // Mensaje de confirmación.
        System.out.println("**¡Historial guardado exitosamente en el archivo " + nombreArchivo + "!**");
    }
}