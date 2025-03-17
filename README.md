## Proyecto Hexagonal-App-Java
**Entidad** : CampusLands

#### Descripción del Proyecto
Este proyecto es una aplicación de gestión de clientes desarrollada con Java Maven y MySQL. La aplicación está diseñada para facilitar la administración de diferentes aspectos de un negocio, como la gestión de clientes y productos.

La aplicación implementa una arquitectura hexagonal, lo que significa que está estructurada de acuerdo con los conceptos y procesos del negocio. Esto no solo mejora la claridad y mantenibilidad del código, sino que también permite una fácil extensión y escalabilidad de la aplicación en el futuro.

#### Funcionalidades Principales
- Menús Interactivos: El usuario tiene la opción de escoger entre diferentes menús interactivos que facilitan la navegación y operación dentro de la aplicación.

- Gestión de Clientes:
Administrar información detallada de los clientes, incluyendo contactos y detalles de facturación. 
    - Crear, leer, actualizar y eliminar (CRUD) registros de clientes.

- Gestión de Productos:

- Crear y gestionar productos, incluyendo nombre, descripción y stock disponible.

Realizar operaciones CRUD sobre los productos.

### Tecnologías Utilizadas
- **Java Maven**: Para la gestión de dependencias y construcción del proyecto.

- **MySQL**: Como sistema de gestión de bases de datos relacional.

Estructura del Proyecto
El proyecto está organizado siguiendo los principios de la arquitectura hexagonal, lo que facilita la separación de preocupaciones y la escalabilidad. A continuación, se describe la estructura básica del proyecto:

````bash
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.campuslands.hexagonalapp/
│   │   │   │   ├── domain/              # Lógica de negocio
│   │   │   │   ├── application/         # Casos de uso
│   │   │   │   ├── infrastructure/      # Adaptadores y configuraciones
│   │   │   │   ├── ports/               # Interfaces para puertos
│   │   │   │   └── Main.java            # Punto de entrada de la aplicación
│   │   └── resources/                   # Archivos de configuración y recursos
│   └── test/                            # Pruebas unitarias y de integración
│
├── pom.xml                              # Archivo de configuración de Maven
└── README.md                            # Documentación del proyecto

````

### Requisitos del Sistema
- **Java JDK 11** o superior

- **Maven 3.6.3** o superior

- **MySQL 8.0** o superior

### Instalación y Configuración
Clonar el Repositorio:

````bash
git clone https://github.com/tu-usuario/hexagonal-app-java.git
cd hexagonal-app-java
````

### Configurar la Base de Datos:

Crear una base de datos en MySQL llamada directorio.
Configurar las credenciales de la base de datos en el archivo ***src/main/resources/config.properties***.

### Compilar y Ejecutar el Proyecto:

````bash
run main
````

### Contribución
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:
- *****Haz un fork del repositorio.*****
- *****Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).*****
- *****Realiza tus cambios y haz commit (git commit -am 'Añade nueva funcionalidad').*****
- *****Haz push a la rama (git push origin feature/nueva-funcionalidad).*****
- *****Abre un Pull Request.*****


¡Gracias por tu interés en este proyecto! Esperamos que te sea de utilidad y que puedas contribuir a su mejora.