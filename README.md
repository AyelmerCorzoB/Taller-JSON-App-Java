# 🏆 Taller: Manejo de Datos de Equipos de la UEFA con Expresiones Lambda y Streams en Java
Este proyecto es un taller práctico que utiliza expresiones lambda y la API Stream de Java para procesar y analizar datos de equipos de fútbol de la UEFA a partir de un archivo JSON. El objetivo es fortalecer las habilidades en programación funcional y el manejo de datos en Java.

🛠️ Requisitos Previos
- Java JDK 8 o superior instalado.
- Biblioteca Jackson o Gson para la deserialización de JSON.
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse o VS Code.

🚀 Configuración del Proyecto
- Clona este repositorio en tu máquina local:
````bash
git clone https://github.com/AyelmerCorzoB/Taller-UEFA-Expresiones-Lambda-y-Stream_Api.git
````
- Abre el proyecto en tu IDE favorito.
Asegúrate de tener las dependencias necesarias en tu archivo pom.xml (si usas Maven).

- Ejemplo con Maven:

````xml
<dependencies>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.18.2</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.18.2</version>
        </dependency>

</dependencies>
````

🏁 Ejecución del Proyecto
Compila y ejecuta el archivo Main.java desde tu IDE o desde la terminal:
````bash
java -cp src/main/java Main
````
El programa mostrará en la consola los resultados de los retos propuestos.

📊 Retos Implementados
- **A**. Listado de Equipos Fundados Después del Año 2000
Filtrado con Predicate<Equipo> y procesamiento con Stream.

- **B**. Impresión de Nombres de Entrenadores
Uso de Consumer<Equipo> y forEach.

- **C**. Cálculo del Promedio de Edad de Jugadores por Equipo
Uso de BiConsumer<Equipo, List<Jugador>> y Stream.

- **D**. Listado de Equipos con Más de 20 Victorias
Filtrado con Predicate<Equipo> y procesamiento con Stream.

- **E**. Obtención del Jugador Más Alto de Cada Equipo
Uso de Stream y max(Comparator.comparingInt()).

- **F**. Cálculo del Total de Goles por Equipo
Suma de goles a favor (gf) con Stream.

#### Retos Adicionales
1. Listado de equipos con más de 15 puntos.
2. Promedio de goles a favor por equipo.
3. Equipo con más victorias.
4. Jugador más alto de todos los equipos.
5. Conteo de delanteros en la UEFA.
6. Entrenadores de equipos con al menos un empate.
7. Map de equipos con sus goles a favor.
8. Jugadores brasileños ordenados por edad.
9. Equipos cuyo entrenador tiene más de 10 caracteres en su nombre.
10. Verificación de equipos con más de 25 puntos.
11. Agrupación de jugadores por posición.
12. Equipos con más de 20 goles a favor ordenados.

### 📝 Conclusión
Este taller demostró cómo las expresiones lambda y la API Stream de Java pueden simplificar el procesamiento y análisis de datos. Estas herramientas permiten escribir código más limpio, legible y eficiente.

📂 Archivo JSON de Ejemplo
El archivo uefa.json tiene la siguiente estructura:

````json
[
  {
    "nombre": "Real Madrid",
    "fundacion": 1902,
    "entrenador": "Carlo Ancelotti",
    "estadisticas": {
      "pg": 25,
      "pe": 5,
      "pp": 3,
      "gf": 70,
      "gc": 20
    },
    "jugadores": [
      {
        "nombre": "Cristiano Ronaldo",
        "edad": 37,
        "altura": 176,
        "posicion": "Delantero",
        "nacionalidad": "Portugues"
      },
      ...
    ]
  },
  ...
]
````

### 🙌 Contribuciones
¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, abre un issue o envía un pull request.

¡Gracias por revisar este proyecto! Si tienes alguna pregunta, no dudes en contactarme. 😊
