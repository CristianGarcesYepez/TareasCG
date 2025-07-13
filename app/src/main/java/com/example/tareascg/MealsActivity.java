package com.example.tareascg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tareascg.adapter.MealsAdapter;
import com.example.tareascg.api.RetrofitClient;
import com.example.tareascg.model.Meal;
import com.example.tareascg.model.MealsResponse;
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

public class MealsActivity extends AppCompatActivity implements MealsAdapter.OnMealClickListener {

    private TextInputEditText editTextSearch;
    private Button buttonSearch, buttonRandom, buttonDessert, buttonChicken, buttonBack;
    private RecyclerView recyclerViewMeals;
    private ProgressBar progressBar;
    private TextView textViewMessage;
    
    private MealsAdapter mealsAdapter;
    private List<Meal> mealsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        initViews();
        setupRecyclerView();
        setupClickListeners();
    }

    private void initViews() {
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonRandom = findViewById(R.id.buttonRandom);
        buttonDessert = findViewById(R.id.buttonDessert);
        buttonChicken = findViewById(R.id.buttonChicken);
        buttonBack = findViewById(R.id.buttonBack);
        recyclerViewMeals = findViewById(R.id.recyclerViewMeals);
        progressBar = findViewById(R.id.progressBar);
        textViewMessage = findViewById(R.id.textViewMessage);
    }

    private void setupRecyclerView() {
        mealsList = new ArrayList<>();
        mealsAdapter = new MealsAdapter(this, mealsList);
        mealsAdapter.setOnMealClickListener(this);
        recyclerViewMeals.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMeals.setAdapter(mealsAdapter);
    }

    private void setupClickListeners() {
        buttonSearch.setOnClickListener(v -> {
            String searchQuery = editTextSearch.getText().toString().trim();
            if (!TextUtils.isEmpty(searchQuery)) {
                searchMealsByName(searchQuery);
            } else {
                Toast.makeText(this, "Por favor ingresa un nombre para buscar", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRandom.setOnClickListener(v -> getRandomMeal());
        
        buttonDessert.setOnClickListener(v -> getMealsByCategory("Dessert"));
        
        buttonChicken.setOnClickListener(v -> getMealsByIngredient("chicken"));

        buttonBack.setOnClickListener(v -> finish());
    }

    private void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        textViewMessage.setVisibility(show ? View.GONE : View.VISIBLE);
        
        if (show) {
            textViewMessage.setText("Cargando recetas...");
        }
    }

    private void searchMealsByName(String mealName) {
        showLoading(true);
        
        Call<MealsResponse> call = RetrofitClient.getMealApiService().searchMealsByName(mealName);
        call.enqueue(new Callback<MealsResponse>() {
            @Override
            public void onResponse(Call<MealsResponse> call, Response<MealsResponse> response) {
                showLoading(false);
                
                if (response.isSuccessful() && response.body() != null) {
                    List<Meal> meals = response.body().getMeals();
                    if (meals != null && !meals.isEmpty()) {
                        updateMealsList(meals);
                        textViewMessage.setVisibility(View.GONE);
                    } else {
                        showNoResultsMessage("No se encontraron recetas con ese nombre");
                    }
                } else {
                    showErrorMessage("Error al buscar recetas");
                }
            }

            @Override
            public void onFailure(Call<MealsResponse> call, Throwable t) {
                showLoading(false);
                showErrorMessage("Error de conexión: " + t.getMessage());
            }
        });
    }

    private void getRandomMeal() {
        showLoading(true);
        
        Call<MealsResponse> call = RetrofitClient.getMealApiService().getRandomMeal();
        call.enqueue(new Callback<MealsResponse>() {
            @Override
            public void onResponse(Call<MealsResponse> call, Response<MealsResponse> response) {
                showLoading(false);
                
                if (response.isSuccessful() && response.body() != null) {
                    List<Meal> meals = response.body().getMeals();
                    if (meals != null && !meals.isEmpty()) {
                        updateMealsList(meals);
                        textViewMessage.setVisibility(View.GONE);
                    } else {
                        showNoResultsMessage("No se pudo obtener una receta aleatoria");
                    }
                } else {
                    showErrorMessage("Error al obtener receta aleatoria");
                }
            }

            @Override
            public void onFailure(Call<MealsResponse> call, Throwable t) {
                showLoading(false);
                showErrorMessage("Error de conexión: " + t.getMessage());
            }
        });
    }

    private void getMealsByCategory(String category) {
        showLoading(true);
        
        Call<MealsResponse> call = RetrofitClient.getMealApiService().getMealsByCategory(category);
        call.enqueue(new Callback<MealsResponse>() {
            @Override
            public void onResponse(Call<MealsResponse> call, Response<MealsResponse> response) {
                showLoading(false);
                
                if (response.isSuccessful() && response.body() != null) {
                    List<Meal> meals = response.body().getMeals();
                    if (meals != null && !meals.isEmpty()) {
                        updateMealsList(meals);
                        textViewMessage.setVisibility(View.GONE);
                    } else {
                        showNoResultsMessage("No se encontraron " + category.toLowerCase());
                    }
                } else {
                    showErrorMessage("Error al buscar " + category.toLowerCase());
                }
            }

            @Override
            public void onFailure(Call<MealsResponse> call, Throwable t) {
                showLoading(false);
                showErrorMessage("Error de conexión: " + t.getMessage());
            }
        });
    }

    private void getMealsByIngredient(String ingredient) {
        showLoading(true);
        
        Call<MealsResponse> call = RetrofitClient.getMealApiService().getMealsByIngredient(ingredient);
        call.enqueue(new Callback<MealsResponse>() {
            @Override
            public void onResponse(Call<MealsResponse> call, Response<MealsResponse> response) {
                showLoading(false);
                
                if (response.isSuccessful() && response.body() != null) {
                    List<Meal> meals = response.body().getMeals();
                    if (meals != null && !meals.isEmpty()) {
                        updateMealsList(meals);
                        textViewMessage.setVisibility(View.GONE);
                    } else {
                        showNoResultsMessage("No se encontraron recetas con " + ingredient);
                    }
                } else {
                    showErrorMessage("Error al buscar recetas con " + ingredient);
                }
            }

            @Override
            public void onFailure(Call<MealsResponse> call, Throwable t) {
                showLoading(false);
                showErrorMessage("Error de conexión: " + t.getMessage());
            }
        });
    }

    private void updateMealsList(List<Meal> meals) {
        mealsList.clear();
        mealsList.addAll(meals);
        mealsAdapter.notifyDataSetChanged();
    }

    private void showNoResultsMessage(String message) {
        textViewMessage.setText(message);
        textViewMessage.setVisibility(View.VISIBLE);
        mealsList.clear();
        mealsAdapter.notifyDataSetChanged();
    }

    private void showErrorMessage(String message) {
        textViewMessage.setText(message);
        textViewMessage.setVisibility(View.VISIBLE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMealClick(Meal meal) {
        showMealDetails(meal);
    }

    private void showMealDetails(Meal meal) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(meal.getStrMeal());
        
        StringBuilder details = new StringBuilder();
        details.append("Categoría: ").append(meal.getStrCategory()).append("\n\n");
        details.append("Área: ").append(meal.getStrArea()).append("\n\n");
        
        if (meal.getStrInstructions() != null && !meal.getStrInstructions().isEmpty()) {
            details.append("Instrucciones:\n").append(meal.getStrInstructions().substring(0, 
                Math.min(200, meal.getStrInstructions().length()))).append("...");
        }
        
        builder.setMessage(details.toString());
        
        builder.setPositiveButton("Ver Completa", (dialog, which) -> {
            // Aquí podrías abrir una nueva actividad con todos los detalles
            Toast.makeText(this, "Funcionalidad de detalles completos pendiente", Toast.LENGTH_SHORT).show();
        });
        
        builder.setNeutralButton("Ver Video", (dialog, which) -> {
            if (meal.getStrYoutube() != null && !meal.getStrYoutube().isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(meal.getStrYoutube()));
                startActivity(intent);
            } else {
                Toast.makeText(this, "No hay video disponible", Toast.LENGTH_SHORT).show();
            }
        });
        
        builder.setNegativeButton("Cerrar", null);
        
        builder.show();
    }
}
