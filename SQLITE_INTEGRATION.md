# Integración de SQLite en TareasCG

## Cambios Realizados

Se ha implementado SQLite en el proyecto para permitir el almacenamiento persistente de los contactos registrados. Los cambios incluyen:

### Nuevas Clases Creadas

1. **ContactoDatabaseHelper.java**
   - Helper para crear y gestionar la base de datos SQLite
   - Define la estructura de la tabla `contactos`
   - Gestiona las versiones y actualizaciones de la base de datos

2. **ContactoDAO.java**
   - Data Access Object que proporciona métodos CRUD (Create, Read, Update, Delete)
   - Métodos disponibles:
     - `insertarContacto(Contacto contacto)` - Inserta un nuevo contacto
     - `obtenerTodosLosContactos()` - Obtiene todos los contactos ordenados por nombre
     - `obtenerContactoPorId(long id)` - Obtiene un contacto específico por ID
     - `actualizarContacto(Contacto contacto)` - Actualiza un contacto existente
     - `eliminarContacto(long id)` - Elimina un contacto por ID
     - `eliminarTodosLosContactos()` - Elimina todos los contactos

3. **ContactoManager.java**
   - Implementa el patrón Singleton para gestionar la conexión a la base de datos
   - Asegura que solo exista una instancia de la base de datos en toda la aplicación
   - Proporciona métodos para cerrar y reabrir la conexión

### Clases Modificadas

1. **Contacto.java**
   - Se añadió un campo `id` de tipo `long` para identificar únicamente cada contacto
   - Se agregaron constructores para manejar contactos con y sin ID
   - Se añadieron getters y setters para el campo ID

2. **ContactsActivity.java**
   - Se reemplazó el ArrayList estático por una implementación que utiliza SQLite
   - Se integró el ContactoManager para gestionar la base de datos
   - Se añadió el método `cargarContactosDesdeDB()` para cargar contactos desde la base de datos
   - Se actualiza la lista automáticamente en `onResume()`

3. **RegisterActivity.java**
   - Se integró el ContactoManager para guardar contactos en la base de datos
   - Se añadieron validaciones adicionales:
     - Validación básica de formato de email
     - Validación de que el celular contenga solo números
   - Se eliminó la dependencia del método estático en ContactsActivity

## Estructura de la Base de Datos

### Tabla: contactos
| Campo     | Tipo    | Descripción              |
|-----------|---------|--------------------------|
| _id       | INTEGER | Clave primaria autoincremental |
| nombre    | TEXT    | Nombre del contacto      |
| apellido  | TEXT    | Apellido del contacto    |
| correo    | TEXT    | Correo electrónico       |
| celular   | TEXT    | Número de celular        |

## Características de la Implementación

- **Persistencia**: Los contactos se guardan automáticamente en la base de datos SQLite
- **Gestión automática**: La base de datos se crea automáticamente la primera vez que se ejecuta la aplicación
- **Patrón Singleton**: Solo existe una instancia de la conexión a la base de datos
- **Validaciones**: Se añadieron validaciones para email y número de celular
- **Ordenamiento**: Los contactos se muestran ordenados alfabéticamente por nombre
- **Eficiencia**: La lista se actualiza automáticamente al regresar de otras actividades

## Ventajas de la Implementación

1. **Datos persistentes**: Los contactos no se pierden al cerrar la aplicación
2. **Rendimiento**: SQLite es rápido y eficiente para aplicaciones móviles
3. **Escalabilidad**: Fácil de expandir con nuevas funcionalidades (búsqueda, filtros, etc.)
4. **Mantenimiento**: Código organizado y fácil de mantener
5. **Validaciones**: Mejor integridad de datos con validaciones implementadas

## Uso

1. Los contactos se guardan automáticamente al presionar "Registrar"
2. La lista se actualiza automáticamente al regresar a la pantalla de contactos
3. Los datos persisten entre sesiones de la aplicación
4. No se requiere configuración adicional por parte del usuario
