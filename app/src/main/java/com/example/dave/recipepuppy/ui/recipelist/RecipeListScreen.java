package com.example.dave.recipepuppy.ui.recipelist;

import com.example.dave.recipepuppy.model.Recipe;

import java.util.List;

public interface RecipeListScreen {


    void showRecipe(Recipe recipe);

    void listRecipes(List<Recipe> recipes);
}
