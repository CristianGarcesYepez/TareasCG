# Integración de API REST - TheMealDB

## 🌐 Descripción

Se ha integrado exitosamente el consumo de la API REST de **TheMealDB** (https://www.themealdb.com/api.php) en el proyecto TareasCG. La funcionalidad está disponible a través del botón 3 "Recetas de Cocina" en el menú principal.

## 📱 Nuevas Clases Creadas

### Modelos (model/)
1. **`Meal.java`** - Clase modelo que representa una receta de cocina con todos sus atributos
2. **`MealsResponse.java`** - Clase wrapper para la respuesta de la API que contiene una lista de recetas

### API (api/)
1. **`MealApiService.java`** - Interfaz de Retrofit que define los endpoints disponibles
2. **`RetrofitClient.java`** - Cliente singleton de Retrofit para realizar las peticiones HTTP

### Adapter (adapter/)
1. **`MealsAdapter.java`** - Adaptador del RecyclerView para mostrar las recetas en una lista

### Actividades
1. **`MealsActivity.java`** - Actividad principal para mostrar y gestionar las recetas

### Layouts
1. **`activity_meals.xml`** - Layout principal de la actividad de recetas
2. **`item_meal.xml`** - Layout para cada item de receta en la lista

## 🔧 Dependencias Agregadas

```gradle
// Retrofit para API REST
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.google.code.gson:gson:2.10.1'

// RecyclerView
implementation 'androidx.recyclerview:recyclerview:1.3.1'

// Glide para cargar imágenes
implementation 'com.github.bumptech.glide:glide:4.15.1'
```

## 🔑 Permisos Agregados

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

## 🚀 Funcionalidades Implementadas

### Búsqueda de Recetas
- **Por nombre**: Busca recetas específicas por nombre
- **Receta aleatoria**: Obtiene una receta aleatoria de la API
- **Por categoría**: Busca postres específicamente
- **Por ingrediente**: Busca recetas que contengan pollo

### Visualización
- **Lista de recetas**: Muestra las recetas en un RecyclerView con imagen, nombre, categoría y área
- **Detalles emergentes**: Al tocar una receta, muestra información detallada en un diálogo
- **Carga de imágenes**: Las imágenes se cargan automáticamente usando Glide
- **Estados de carga**: Indicador de progreso durante las peticiones

### Interacción
- **Ver video**: Acceso directo al video de YouTube de la receta (si está disponible)
- **Navegación**: Botón de regreso al menú principal

## 📋 Endpoints de API Utilizados

| Funcionalidad | Endpoint | Parámetro |
|---------------|----------|-----------|
| Buscar por nombre | `search.php` | `s=nombre` |
| Receta aleatoria | `random.php` | - |
| Buscar por categoría | `filter.php` | `c=categoria` |
| Buscar por ingrediente | `filter.php` | `i=ingrediente` |
| Detalles por ID | `lookup.php` | `i=id` |

## 🎯 Cómo Usar

1. **Acceder**: Desde el menú principal, toca el botón "Recetas de Cocina"
2. **Buscar**: 
   - Escribe el nombre de una receta y presiona "Buscar"
   - O usa los botones rápidos: "🎲 Aleatoria", "🍰 Postres", "🐔 Pollo"
3. **Ver detalles**: Toca cualquier receta para ver más información
4. **Ver video**: En el diálogo de detalles, presiona "Ver Video" (si está disponible)
5. **Regresar**: Usa el botón "← Regresar al Menú Principal"

## 🔄 Flujo de Datos

1. **Usuario interactúa** → MealsActivity
2. **MealsActivity hace petición** → RetrofitClient
3. **RetrofitClient llama** → MealApiService
4. **API responde** → MealsResponse (con lista de Meal)
5. **Datos se muestran** → MealsAdapter en RecyclerView

## ⚠️ Manejo de Errores

- **Sin conexión**: Muestra mensaje de error de conexión
- **Sin resultados**: Informa cuando no se encuentran recetas
- **Error de API**: Maneja errores del servidor
- **Carga de imágenes**: Imagen por defecto si falla la carga

## 🎨 Características de UI/UX

- **Diseño moderno**: Cards con bordes redondeados y sombras
- **Colores consistentes**: Mantiene la paleta del proyecto
- **Feedback visual**: Loading spinner y mensajes informativos
- **Responsivo**: Se adapta a diferentes tamaños de pantalla
- **Iconos descriptivos**: Emojis para mejor identificación

## 🔮 Posibles Mejoras Futuras

1. **Favoritos**: Guardar recetas favoritas en SQLite
2. **Detalles completos**: Actividad dedicada para mostrar todos los detalles
3. **Filtros avanzados**: Más opciones de búsqueda y filtrado
4. **Offline**: Cache de recetas para uso sin conexión
5. **Compartir**: Función para compartir recetas
6. **Lista de compras**: Generar lista de ingredientes

La integración está completamente funcional y lista para usar. Los usuarios pueden ahora explorar miles de recetas de cocina directamente desde la aplicación.
