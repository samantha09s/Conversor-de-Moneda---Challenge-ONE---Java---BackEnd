import com.google.gson.Gson; // Librería para manejar formato JSON.
import com.google.gson.GsonBuilder; // Clase para personalizar la configuración de Gson.

import java.io.FileWriter; // Escribe datos en archivos de texto.
import java.io.IOException; // Maneja errores al escribir en archivos o acceder al sistema operativo.

// La clase maneja la creación y escritura de archivos JSON.
public class GeneradorArchivo {
    public void guardarJson(Moneda moneda, String resultado, String nombreArchivo) throws IOException {

        /*
         * @param moneda        Objeto Moneda que contiene la información de la conversión.
         * @param resultado     Cadena con el resultado de la conversión en formato JSON.
         * @param nombreArchivo Nombre del archivo donde se guardará la información.
         * @throws IOException  Si ocurre un error durante la escritura del archivo.
         */
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Crea un objeto Gson con configuración para imprimir el JSON de manera legible.

        // Establece un FileWriter para escribir en el archivo especificado.
        try (FileWriter escritura = new FileWriter(nombreArchivo)) {
            // Escribe el resultado JSON en el archivo.
            escritura.write(resultado);
        }
    }
}