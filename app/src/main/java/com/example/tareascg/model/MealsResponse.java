package com.example.tareascg.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MealsResponse {
    @SerializedName("meals")
    private List<Meal> meals;

    public MealsResponse() {}

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
