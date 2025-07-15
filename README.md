# ✅ API de Tópicos - Spring Boot

Esta es una API RESTful construida con **Spring Boot** que permite a los usuarios registrarse, iniciar sesión mediante **JWT** y gestionar **tópicos** (temas).  
Cada usuario puede crear y eliminar sus propios tópicos. La base de datos utilizada es **PostgreSQL** y se implementan migraciones automáticas con **Flyway**.

---

## ⚙️ Tecnologías utilizadas

- Spring Boot Web: para construir la API REST.
- Spring Security: para la autenticación y autorización basada en tokens JWT.
- Spring Data JPA: para interactuar con la base de datos de forma sencilla.
- PostgreSQL: base de datos relacional utilizada en el proyecto.
- Flyway: para el versionado y migraciones automáticas de la base de datos.
- Lombok: para reducir el código repetitivo como getters, setters, y constructores.
- Java JWT (Auth0): para generar y validar tokens JWT de autenticación.
- Spring Validation: para validar automáticamente los datos que llegan en las solicitudes.
- Spring DevTools: para mejorar la experiencia de desarrollo con recarga automática.


---

## 📥 Endpoints principales

- `POST /registrar`: Registro de nuevos usuarios.
- `POST /login`: Autenticación y generación de JWT.
- `GET /topicos`: Listado de tópicos del usuario autenticado.
- `POST /topicos`: Crear un nuevo tópico.
- `DELETE /topicos/{id}`: Eliminar un tópico (solo si pertenece al usuario).

---
