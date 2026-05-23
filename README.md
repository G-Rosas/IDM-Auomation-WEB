Sauce Demo Automation - Playwright + Cucumber

Descripción
Proyecto de automatización QA FrontEnd para la aplicación:
Sauce Demo

El framework fue desarrollado utilizando:
Playwright
Cucumber
Java 17
Maven
Patrón de diseño Page Object Model (POM)

Objetivo
Automatizar los principales flujos de usuario:
Login exitoso
Login fallido
Agregar productos al carrito
Visualizar productos en carrito
Eliminar productos del carrito
Completar checkout

Tecnologías Utilizadas
Tecnología	Versión
Java	    17
Maven	    3+
Playwright	Latest
Cucumber	Latest
JUnit	    4
IntelliJ IDEA	Recomendado

Patrón de Diseño
Se implementó el patrón:
Page Object Model (POM)

La lógica de interacción con la UI fue separada en Page Objects para mejorar:
mantenibilidad
reutilización
legibilidad
escalabilidad

Estructura del Proyecto
src
├── main
│
└── test
    ├── java
    │   ├── hooks
    │   │   └── Hooks.java
    │   │
    │   ├── pages
    │   │   ├── CartPage.java
    │   │   ├── CheckoutPage.java
    │   │   ├── InventoryPage.java
    │   │   └── LoginPage.java
    │   │
    │   ├── runners
    │   │   └── TestRunner.java
    │   │
    │   ├── steps
    │   │   ├── CartSteps.java
    │   │   ├── CheckoutSteps.java
    │   │   └── LoginSteps.java
    │   │
    │   └── utils
    │       ├── ConfigReader.java
    │       ├── DriverFactory.java
    │       └── TestContext.java
    │
    └── resources
        ├── config
        │   └── config.properties
        │
        └── features
        ├── cart.feature
        ├── checkout.feature
        └── login.feature

Configuración
1. Clonar repositorio
   git clone https://github.com/TU-USUARIO/TU-REPO.git
2. Instalar dependencias
   mvn clean install

Ejecución de Pruebas
Ejecutar todos los tests
mvn test
Ejecutar por tags
Smoke Tests
mvn test "-Dcucumber.filter.tags=@smoke-test"
Tests negativos
mvn test "-Dcucumber.filter.tags=@negative"
Excluir tests ignorados
mvn test "-Dcucumber.filter.tags=not @ignore"
Ejecutar múltiples tags
mvn test "-Dcucumber.filter.tags=@smoke-test and not @ignore"

Escenarios Automatizados
Login
Login exitoso con standard_user
Login fallido con locked_out_user

Carrito
Agregar productos al carrito
Validar cantidad de productos
Visualizar productos agregados
Eliminar productos del carrito

Checkout
Completar flujo de compra
Validar mensaje de compra exitosa
Manejo de Datos

El framework soporta:
productos dinámicos
validaciones dinámicas
manejo de múltiples productos en carrito mediante TestContext
Configuración del Navegador

Archivo:
src/test/resources/config.properties

Ejemplo:
browser=chromium
headless=false
slowmo=500

Explicación de Propiedades
Propiedad - Descripción
browser	  - Navegador utilizado
headless  - Ejecutar con UI visible o no
slowmo	  - Agrega demora entre acciones

Buenas Prácticas Aplicadas
Separación de responsabilidades
Reutilización de componentes
Uso de Page Object Model
Uso de waits explícitos
Steps reutilizables
Tags para ejecución selectiva
Framework escalable

Autor
Giancarlo Christopher Rosas Villagra