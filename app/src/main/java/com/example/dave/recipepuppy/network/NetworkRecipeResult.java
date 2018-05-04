package com.example.dave.recipepuppy.network;

import com.example.dave.recipepuppy.model.Recipe;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkRecipeResult {

    @SerializedName("results")
    private List<NetworkRecipe> recipes;

    private int verison;

    public List<NetworkRecipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<NetworkRecipe> recipes) {
        this.recipes = recipes;
    }
}
