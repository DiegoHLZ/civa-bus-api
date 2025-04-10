# 🚌 CIVA Bus API

API REST desarrollada para la empresa CIVA utilizando **Java 17**, **Spring Boot 3** y **MySQL**.

## 📋 Descripción

Esta API permite gestionar una lista de buses de la empresa CIVA. Incluye la creación, consulta y seguridad básica para proteger los endpoints.

---

## ✅ Requisitos

Antes de ejecutar este proyecto, asegúrate de tener instalado:

- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/) (puedes usar [MySQL Workbench](https://dev.mysql.com/downloads/workbench/))
- Un editor como IntelliJ IDEA (recomendado)

---

## 🛠️ Configuración inicial

### 1. Clonar el repositorio

```bash
git clone https://github.com/DiegoHLZ/civa-bus-api.git
cd civa-bus-api

### 2. Crear la base de datos

En tu cliente MySQL:

```sql
CREATE DATABASE civa_db;
```

---

### 3. Configurar conexión en `application.properties`

Ubicado en: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/civa_db?useSSL=false&serverTimezone=UTC  (cambiar el puerto del mysql, yo uso el 3307, normalmente usan el 3306)
spring.datasource.username=TU_USUARIO_MYSQL
spring.datasource.password=TU_CONTRASENA_MYSQL

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 🚀 Fase 4: Ejecutar la aplicación

1. Ejecuta la clase `CivaBackendApplication.java` como una aplicación Spring Boot.
2. Verifica en la consola que la aplicación se haya iniciado correctamente (mensaje `Started CivaBackendApplication`).
3. Accede a la documentación Swagger para probar los endpoints:

```
http://localhost:8080/swagger-ui/index.html
```

---

### 🔐 Seguridad

Esta API utiliza **autenticación básica HTTP** para proteger los endpoints `/bus/**`.

- Usuario configurado: `admin`
- Contraseña configurada: `admin123`

Si intentas acceder a `/bus`, `/bus/{id}` o `/bus/paginado` sin autenticarte, el sistema te pedirá usuario y contraseña.

Puedes modificar estas credenciales en el archivo `InMemoryUserConfig.java`.

---

### 👤 Autor

- **DiegoHLZ**  
  Desarrollador de software  
  GitHub: [@DiegoHLZ](https://github.com/DiegoHLZ)
