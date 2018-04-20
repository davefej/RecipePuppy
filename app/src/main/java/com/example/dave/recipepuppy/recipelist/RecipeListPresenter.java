package com.example.dave.recipepuppy.recipelist;

public interface RecipeListPresenter {

    public void showRecipe(int recipeId);

    public void addToFavorites(int recipeId);

    public void removeFromFavorites(int recipeId);
}
