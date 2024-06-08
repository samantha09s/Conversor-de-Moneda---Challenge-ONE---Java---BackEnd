<div align="center">
  <h1 align="center">
    Conversor de Moneda Java
    <br />
    <br />
    <a href="https://github.com/samantha09s/Conversor-de-Moneda---Challenge-ONE---Java---BackEnd">
      <img src="https://github.com/samantha09s/Conversor-de-Moneda---Challenge-ONE---Java---BackEnd/assets/140031528/52d80c08-0eed-4e18-92fb-3971271fe0ac" alt="Conversor de Moneda">
    </a>
  </h1>
</div>

<p align="center">
  
  ![Releasea](https://img.shields.io/badge/Release%20Date:-Junio/2024-white)
  ![JAVA](https://img.shields.io/badge/JAVA-red)
  ![API](https://img.shields.io/badge/API-ExchangeRateAPI-blue)  
  ![Finalizado](https://img.shields.io/badge/Status:-Demo-white)
</p>

## **Índice**
- [Descripción del Proyecto](#descripción-del-proyecto)
- [Características](#características)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Instalación](#instalación)
- [Uso](#uso)
- [API Utilizada](#api-utilizada)
- [Créditos](#créditos)

## **Descripción del Proyecto**
Este proyecto es una app de un conversor de monedas, desarrollado en Java e implementando el uso de una API para obtener información actualizada sobre las tasas de cambio de varias monedas del mundo.

## **Características**
- **Conversión de Monedas:** Permite convertir cantidades entre diferentes monedas utilizando tasas de cambio actualizadas obtenidas de una API.
- **Submenús Funcionales:** Ofrece tres funciones diferentes a elegir en el menú principal, cada una con submenús específicos para seleccionar las monedas sobre las que se desea operar.
- **Guardado de Consultas:** Opción para guardar las consultas realizadas en un archivo nuevo, para futuras referencias.
- **Navegación Intuitiva:** En cualquier momento, el usuario puede optar por retornar al menú principal.

## **Requisitos del Sistema**
- Java 8 o superior.
- Conexión a internet para acceder a la API de tasas de cambio.
- Biblioteca Gson para parsear JSON.
- Un IDE de desarrollo de Java.

## **Instalación**
1. Clonar el repositorio o descargar los archivos fuente.
   ```bash
   git clone https://github.com/samantha09s/Conversor-de-Moneda-ChallengeONE.git
   ```
2. Asegurarse de tener Java instalado en el sistema.
   ```bash
   java -version
   ```
3. Añadir la biblioteca Gson. Puedes descargarla desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).
   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.8.6</version>
   </dependency>
   ```

## **Uso**
1. Ejecutar el programa.
2. Seleccionar la moneda original y la moneda de destino.
3. Ingresar la cantidad de dinero a convertir.
4. Obtener el resultado de la conversión.

### **Menú Principal**
- **Función 1:** Consultar la tasa de conversión de un par de divisas.
- **Función 2:** Realizar la conversión de una cantidad específica de una divisa a otra.
- **Función 3:** Consultar el código ISO de una moneda.

En cada submenú, el usuario tendrá la opción de guardar en un nuevo archivo el historial de las consultas realizadas. Al finalizar, siempre podrá retornar al menú principal.

## **API Utilizada**
Este proyecto utiliza la ***API ExchangeRate*** para obtener las tasas de cambio actualizadas. Asegúrate de tener una clave de API válida y configurada en el proyecto.

## **Créditos**
Este proyecto fue desarrollado por **Samantha Munguía** como parte del programa educativo de Oracle Next Education y Alura Latam.
