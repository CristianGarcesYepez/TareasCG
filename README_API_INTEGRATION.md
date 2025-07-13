# 🍽️ Integración API REST con Retrofit - TheMealDB

## 📋 Descripción General

Este proyecto integra la API pública **TheMealDB** utilizando **Retrofit** para consumir datos de recetas de cocina. La implementación permite buscar, visualizar y explorar diferentes recetas con imágenes y detalles completos.

## 🔧 Tecnologías Utilizadas

- **Retrofit 2.9.0** - Cliente HTTP para Android
- **Gson 2.10.1** - Conversión JSON a objetos Java
- **Glide 4.16.0** - Carga de imágenes optimizada
- **RecyclerView** - Lista eficiente de elementos
- **CardView** - Diseño moderno de tarjetas

## 📡 API Utilizada

**TheMealDB API**: https://www.themealdb.com/api.php

### Endpoints Implementados:
- `GET /api/json/v1/1/search.php?s={query}` - Búsqueda de recetas por nombre
- `GET /api/json/v1/1/categories.php` - Lista de categorías
- `GET /api/json/v1/1/filter.php?c={category}` - Filtrar por categoría

## 🏗️ Arquitectura de la Integración

### 1. **Modelos de Datos**

#### `Meal.java`
```java
public class Meal {
    private String idMeal;
    private String strMeal;          // Nombre de la receta
    private String strCategory;      // Categoría (Beef, Chicken, etc.)
    private String strArea;          // Región (Italian, Mexican, etc.)
    private String strInstructions;  // Instrucciones de preparación
    private String strMealThumb;     // URL de la imagen
    private String strYoutube;       // Video de YouTube
    // ... getters y setters
}
```

#### `MealsResponse.java`
```java
public class MealsResponse {
    private List<Meal> meals;
    // Wrapper para la respuesta de la API
}
```

### 2. **Cliente Retrofit**

#### `RetrofitClient.java`
```java
public class RetrofitClient {
    private static final String BASE_URL = "https://www.themealdb.com/";
    private static Retrofit retrofit = null;
    
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
```

#### `MealApiService.java`
```java
public interface MealApiService {
    @GET("api/json/v1/1/search.php")
    Call<MealsResponse> searchMeals(@Query("s") String query);
    
    @GET("api/json/v1/1/filter.php")
    Call<MealsResponse> getMealsByCategory(@Query("c") String category);
    
    @GET("api/json/v1/1/categories.php")
    Call<CategoriesResponse> getCategories();
}
```

### 3. **Adaptador RecyclerView**

#### `MealsAdapter.java`
- Implementa ViewHolder pattern para rendimiento óptimo
- Usa Glide para carga asíncrona de imágenes
- Incluye click listener para navegación a detalles
- Método `updateMeals()` para actualizar datos dinámicamente

### 4. **Activity Principal**

#### `MealsActivity.java`
```java
public class MealsActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMeals;
    private MealsAdapter mealsAdapter;
    private MealApiService apiService;
    private SearchView searchView;
    
    // Implementación de búsqueda en tiempo real
    // Manejo de estados de carga y errores
    // Integración con adapter
}
```

## 🎨 Interfaz de Usuario

### Layouts Implementados:

#### `activity_meals.xml`
- SearchView para búsqueda en tiempo real
- RecyclerView con GridLayoutManager (2 columnas)
- ProgressBar para estados de carga
- Diseño responsivo y moderno

#### `item_meal.xml`
- CardView con esquinas redondeadas
- ImageView para foto de la receta
- TextViews para nombre, categoría y región
- Fondo con color personalizado `#e3e4e5`

## 🚀 Características Implementadas

### ✅ **Funcionalidades Básicas**
- [x] Búsqueda de recetas por nombre
- [x] Visualización en grid de 2 columnas
- [x] Carga de imágenes optimizada
- [x] Interfaz responsiva

### ✅ **Funcionalidades Avanzadas**
- [x] Búsqueda en tiempo real
- [x] Manejo de estados (carga, éxito, error)
- [x] Navegación a detalles de receta
- [x] Diseño Material Design
- [x] Optimización de memoria con Glide

### ✅ **Manejo de Errores**
- [x] Timeout de conexión
- [x] Errores de red
- [x] Respuestas vacías
- [x] Imágenes faltantes

## 📦 Dependencias Agregadas

### `app/build.gradle`
```gradle
dependencies {
    // Retrofit para API REST
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    // Glide para carga de imágenes
    implementation 'com.github.bumptech.glide:glide:4.16.0'
    
    // RecyclerView y CardView
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    
    // Material Design
    implementation 'com.google.android.material:material:1.11.0'
}
```

### `AndroidManifest.xml`
```xml
<!-- Permisos requeridos -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<!-- Actividad registrada -->
<activity
    android:name=".MealsActivity"
    android:exported="false" />
```

## 🔧 Configuración de Red

### Configuración de Seguridad de Red
- Permite conexiones HTTP para compatibilidad con la API
- Configuración de timeouts apropiados
- Manejo de certificados SSL

## 📱 Flujo de Usuario

1. **Acceso**: Usuario toca "🍽️ Recetas" en el menú principal
2. **Carga Inicial**: Se muestran recetas populares por defecto
3. **Búsqueda**: Usuario puede buscar recetas específicas
4. **Visualización**: Grid de tarjetas con imágenes y datos
5. **Interacción**: Click en receta para ver detalles completos

## 🔍 Ejemplos de Uso

### Búsqueda de Recetas
```java
// En MealsActivity.java
private void searchMeals(String query) {
    Call<MealsResponse> call = apiService.searchMeals(query);
    call.enqueue(new Callback<MealsResponse>() {
        @Override
        public void onResponse(Call<MealsResponse> call, Response<MealsResponse> response) {
            if (response.isSuccessful() && response.body() != null) {
                List<Meal> meals = response.body().getMeals();
                mealsAdapter.updateMeals(meals);
            }
        }
        
        @Override
        public void onFailure(Call<MealsResponse> call, Throwable t) {
            // Manejo de errores
        }
    });
}
```

## 📊 Rendimiento

### Optimizaciones Implementadas:
- **Glide**: Caché automática de imágenes
- **RecyclerView**: Reciclaje eficiente de vistas
- **Retrofit**: Conexiones HTTP optimizadas
- **Gson**: Parsing JSON eficiente

## 🐛 Manejo de Errores Comunes

| Error | Causa | Solución |
|-------|-------|----------|
| Network timeout | Conexión lenta | Retry automático |
| 404 Not Found | Receta no existe | Mensaje usuario amigable |
| JSON Parse Error | Respuesta malformada | Fallback a datos locales |
| Image Load Error | URL inválida | Placeholder por defecto |

## 🔮 Futuras Mejoras

- [ ] Caché offline con Room Database
- [ ] Favoritos de usuario
- [ ] Compartir recetas
- [ ] Modo offline
- [ ] Notificaciones push
- [ ] Filtros avanzados

## 📁 Estructura de Archivos

```
app/src/main/java/com/example/tareascg/
├── adapter/
│   └── MealsAdapter.java
├── api/
│   ├── MealApiService.java
│   └── RetrofitClient.java
├── model/
│   ├── Meal.java
│   └── MealsResponse.java
└── MealsActivity.java

app/src/main/res/layout/
├── activity_meals.xml
└── item_meal.xml
```

## ✅ Estado del Proyecto

- ✅ **Integración completa** - API funcionando correctamente
- ✅ **UI implementada** - Interfaz moderna y responsiva
- ✅ **Testing realizado** - Búsquedas y navegación funcionales
- ✅ **Optimización** - Rendimiento y memoria optimizados
- ✅ **Documentación** - Código bien documentado

---

### 👨‍💻 Desarrollado por: Cristian G
### 📅 Fecha: Enero 2025
### 🎯 Proyecto: TareasCG - Programación Móvil 4B

**API utilizada**: [TheMealDB](https://www.themealdb.com/) - Free meal database API
