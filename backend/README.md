# 🛠️ Guía Rápida del Proyecto (ProjectLoki)

Este proyecto está configurado para ejecutarse en contenedores Docker, utilizando Spring Boot (Java 25) y PostgreSQL para la persistencia.

---

## 1️⃣ Requisitos previos

### Asegúrate de tener instalado y funcionando:
- Docker & Docker Compose: Necesarios para construir las imágenes y orquestar los contenedores.
- Java 25 (JDK): Necesario para compilar el código fuera de Docker (opcional, pero recomendado).
- Maven: Para gestionar dependencias y la compilación.

---

## 2️⃣ Configuración de Credenciales de Entorno

IMPORTANTE: Las credenciales de la base de datos se manejan mediante variables de entorno para mantenerlas fuera del control de versiones (Git).
- Asegúrate de tener el archivo .env en la raíz del proyecto.
- Verifica que las variables contengan tus credenciales actuales:

### Archivos de ejemplo

#### `.env`
```dotenv
DB_NAME=devdb
DB_USER=devuser
DB_PASS=devpass
```

## 3️⃣ Ejecución del Proyecto (Docker Compose)
El archivo docker-compose.yml inicia dos servicios: postgres_db (la base de datos) y mi_app_spring_boot (la aplicación Java).

### Iniciar por Primera Vez o Reconstruir
Usa este comando para construir la imagen de Spring Boot (Java 25) y levantar ambos contenedores:

```docker compose up --build```

### Iniciar y Limpiar Contenedores Huérfanos
Si encuentras advertencias sobre contenedores huérfanos de ejecuciones anteriores, usa el flag de limpieza:

```docker compose up --remove-orphans```

### Ejecución en Segundo Plano
Para liberar tu terminal, usa el modo detached y revisa los logs por separado:

```docker compose up -d```

```docker compose logs -f # Para ver los logs después de iniciar en detached```

## 4️⃣Conexión a la Base de Datos
Puedes acceder a la base de datos PostgreSQL usando cualquier cliente SQL (como el Database Tool Window de IntelliJ o DBeaver).

| Parámetro | Valor             |
| --------- |-------------------|
| Host      | localhost         |
| Port      | 5432              |
| Database  | base_datos (.env) |
| User      | DB_USER (.env)    |
| Password  | DB_PASS (.env)    |

## 5️⃣ Detener y Limpiar

### Detener Contenedores

Detiene los contenedores sin eliminar los datos persistentes:

```docker compose down```

### Eliminar Datos de la Base de Datos

ADVERTENCIA: Si necesitas eliminar permanentemente todos los datos de PostgreSQL y forzar una inicialización limpia (ej., al cambiar el usuario principal), usa:

```docker compose down -v```