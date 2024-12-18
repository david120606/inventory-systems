# Proyecto Inventario de sistemas

## Descripción

El proyecto **Inventario de sistemas** es una práctica diseñada para explorar y aplicar tecnologías clave del ecosistema de Spring Boot y otras herramientas relacionadas con el desarrollo de servicios web y APIs. Este proyecto incluye la implementación de una API REST que utiliza un enfoque basado en Hibernate y JPA para interactuar con una base de datos PostgreSQL.

## Características principales

### Backend con Spring Boot y Hibernate
- Uso del `spring-boot-starter-web` para construir servicios web RESTful.
- Gestión de datos mediante `spring-boot-starter-data-jpa`, integrando Hibernate como proveedor de JPA para mapear y persistir entidades en PostgreSQL.
- Validación de datos robusta mediante `validation-api` y `hibernate-validator`.

### Documentación de la API
- Documentación automática generada con `springdoc-openapi-ui`, proporcionando una interfaz interactiva para probar los endpoints.

### Pruebas y calidad del código
- Implementación de pruebas unitarias y de integración utilizando `spring-boot-starter-test` y `mockito-core`.

### Gestión del servicio Eureka (en un proyecto relacionado)
- Exploración del ecosistema Spring Cloud mediante la configuración de un cliente Eureka (`spring-cloud-starter-netflix-eureka-client`) para el descubrimiento de servicios. Esta implementación se encuentra en un proyecto separado.

## Objetivo

El principal objetivo de esta práctica fue familiarizarse con las dependencias y herramientas mencionadas, desarrollando un proyecto funcional que integre estas tecnologías de manera efectiva. Adicionalmente, se buscó construir una base para proyectos futuros más complejos que aprovechen la arquitectura basada en microservicios.

## Tecnologías y herramientas utilizadas

- **Framework**: Spring Boot
- **ORM**: Hibernate
- **Base de datos**: PostgreSQL
- **Gestión de dependencias**: Maven
- **Documentación**: OpenAPI (Swagger)
- **Pruebas**: JUnit, Mockito
- **Otros**: Eureka para descubrimiento de servicios (en proyecto relacionado)

## Configuración del Proyecto

### Variables de entorno
El proyecto utiliza variables de entorno para almacenar credenciales sensibles y configuraciones clave. Asegúrate de configurarlas en tu sistema:

```bash
export DB_URL="jdbc:postgresql://localhost:5432/inventory"
export DB_USERNAME="tu_usuario"
export DB_PASSWORD="tu_contraseña"
export SERVER_PORT="5000"
export EUREKA_SERVER_URL="http://localhost:8761/eureka"
export EUREKA_INSTANCE_HOSTNAME="localhost"
```

### Archivo `application.properties`
El archivo `application.properties` está configurado para usar estas variables de entorno. Ejemplo:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true

server.port=${SERVER_PORT}

spring.application.name=escuela-service
eureka.client.service-url.defaultZone=${EUREKA_SERVER_URL}
eureka.instance.hostname=${EUREKA_INSTANCE_HOSTNAME}
```

## Ejecución del Proyecto

1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Configura las variables de entorno necesarias.

3. Compila y ejecuta el proyecto:
   ```bash
   mvn spring-boot:run
   ```

4. Accede a la documentación de la API en:
   ```
   http://localhost:5000/swagger-ui.html
   ```

## Notas finales

Este proyecto se presenta como un punto de partida para aprender, experimentar y construir servicios robustos utilizando herramientas ampliamente adoptadas en el desarrollo moderno de software. Síguelo como referencia para futuros proyectos que integren arquitecturas basadas en microservicios.

