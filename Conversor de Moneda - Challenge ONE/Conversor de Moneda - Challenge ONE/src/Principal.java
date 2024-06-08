import java.io.IOException; // Clase para manejar errores de entrada/salida.
import java.util.Scanner; // Clase para leer la entrada del usuario.

// Clase principal del programa que contiene el método main.
public class Principal {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario desde la consola.
        Scanner lectura = new Scanner(System.in);

        // Mostrar un mensaje de bienvenida al usuario.
        System.out.println("""
                ....................................................
                ¡BIENVENIDO A TU CONVERSOR DE MONEDAS PERSONALIZADO!
                ....................................................
                """);

        // Mostrar un mensaje de introducción.
        System.out.printf(("¡Hola! Estamos encantados de tenerte aquí. " +
                           "\nDisfruta de tu experiencia en nuestro Conversor de Monedas de una manera fácil de usar. " +
                           "\n**¿Estás listo para empezar a convertir tus monedas?** " +
                           "\nPara comenzar, selecciona una opción del menú principal.%%n\n").formatted());

        // Bucle infinito para mostrar y procesar las opciones del menú principal.
        while (true) {
            // Crea una instancia de la clase Menu para mostrar y manejar las opciones del menú.
            Menu miMenu = new Menu();
            miMenu.inicio(); // Muestra el menú principal.

            try {
                int menu = lectura.nextInt(); // Lee la opción seleccionada por el usuario.

                // Procesa la opción seleccionada por el usuario.
                switch (menu) {
                    case 1 -> miMenu.firstMenu();  // Consultar tasa de conversión.
                    case 2 -> miMenu.secondMenu(); // Realizar conversión de moneda.
                    case 3 -> miMenu.thirdMenu();  // Consultar código ISO de una moneda.
                    case 4 -> {
                        // Muestra un mensaje de despedida y cierra el programa.
                        System.out.println("""
                                **¡Muchas gracias por su confianza!**\s
                                Esperamos que haya disfrutado de su experiencia con nosotros.\s
                                Atentamente,\s
                                Samantha Munguía.""");
                        lectura.close(); // Cierra el objeto Scanner.
                        return; // Termina el programa.
                    }
                    default -> System.out.println("**Opción no válida:** Por favor, seleccione una opción válida del menú.");
                }
            } catch (RuntimeException e) {
                // Maneja errores de tiempo de ejecución, como una opción de moneda no válida.
                System.out.println("**Error de divisa no encontrada:** Por favor, seleccione una divisa válida de la lista disponible.");
                break; // Sale del bucle en caso de error.
            } catch (IOException e) {
                // Maneja errores de entrada/salida, como problemas al conectarse a la API.
                System.out.println("**Error al leer datos de la API:** Se produjo un error de red al intentar conectar con la API.");
                System.out.println("**Verifique su conexión a internet y vuelva a intentarlo más tarde.**");
                System.out.println("Error de E/S en la comunicación con la API: " + e);
                throw new RuntimeException(e); // Lanza una excepción para detener el programa en caso de error grave.
            }
        }
    }
}