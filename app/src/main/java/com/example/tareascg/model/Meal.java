package com.example.tareascg.model;

import com.google.gson.annotations.SerializedName;

public class Meal {
    @SerializedName("idMeal")
    private String idMeal;
    
    @SerializedName("strMeal")
    private String strMeal;
    
    @SerializedName("strDrinkAlternate")
    private String strDrinkAlternate;
    
    @SerializedName("strCategory")
    private String strCategory;
    
    @SerializedName("strArea")
    private String strArea;
    
    @SerializedName("strInstructions")
    private String strInstructions;
    
    @SerializedName("strMealThumb")
    private String strMealThumb;
    
    @SerializedName("strTags")
    private String strTags;
    
    @SerializedName("strYoutube")
    private String strYoutube;
    
    // Ingredientes (hasta 20)
    @SerializedName("strIngredient1")
    private String strIngredient1;
    @SerializedName("strIngredient2")
    private String strIngredient2;
    @SerializedName("strIngredient3")
    private String strIngredient3;
    @SerializedName("strIngredient4")
    private String strIngredient4;
    @SerializedName("strIngredient5")
    private String strIngredient5;
    
    // Medidas (hasta 20)
    @SerializedName("strMeasure1")
    private String strMeasure1;
    @SerializedName("strMeasure2")
    private String strMeasure2;
    @SerializedName("strMeasure3")
    private String strMeasure3;
    @SerializedName("strMeasure4")
    private String strMeasure4;
    @SerializedName("strMeasure5")
    private String strMeasure5;
    
    @SerializedName("strSource")
    private String strSource;
    
    @SerializedName("strImageSource")
    private String strImageSource;
    
    @SerializedName("strCreativeCommonsConfirmed")
    private String strCreativeCommonsConfirmed;
    
    @SerializedName("dateModified")
    private String dateModified;

    // Constructor vacío
    public Meal() {}

    // Getters y Setters
    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public void setStrImageSource(String strImageSource) {
        this.strImageSource = strImageSource;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
