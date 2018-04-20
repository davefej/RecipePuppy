package com.example.dave.recipepuppy.recipe;

public interface RecipePresenter {

    public void addToFavorites(int recipeId);

    public void removeFromFavorites(int recipeId);
}
