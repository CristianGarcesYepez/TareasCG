package com.example.tareascg.api;

import com.example.tareascg.model.MealsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealApiService {
    
    // Base URL: https://www.themealdb.com/api/json/v1/1/
    
    /**
     * Buscar comidas por nombre
     */
    @GET("search.php")
    Call<MealsResponse> searchMealsByName(@Query("s") String mealName);
    
    /**
     * Buscar una comida aleatoria
     */
    @GET("random.php")
    Call<MealsResponse> getRandomMeal();
    
    /**
     * Buscar comidas por categoría
     */
    @GET("filter.php")
    Call<MealsResponse> getMealsByCategory(@Query("c") String category);
    
    /**
     * Buscar comidas por área/país
     */
    @GET("filter.php")
    Call<MealsResponse> getMealsByArea(@Query("a") String area);
    
    /**
     * Buscar comidas por ingrediente principal
     */
    @GET("filter.php")
    Call<MealsResponse> getMealsByIngredient(@Query("i") String ingredient);
    
    /**
     * Obtener detalles de una comida por ID
     */
    @GET("lookup.php")
    Call<MealsResponse> getMealById(@Query("i") String mealId);
}
