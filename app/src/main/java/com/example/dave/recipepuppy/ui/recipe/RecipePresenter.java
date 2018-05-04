package com.example.dave.recipepuppy.ui.recipe;

import com.example.dave.recipepuppy.interactior.RecipeInteractor;
import com.example.dave.recipepuppy.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class RecipePresenter extends Presenter<RecipeScreen> {

    @Inject
    Executor networkExecutor;

    @Inject
    RecipeInteractor recipeInteractor;

    @Override
    public void attachScreen(RecipeScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void addToFavorites(){
        screen.addToFavorites();
    }

    public void loadRecipe(String recipeUrl){
        screen.loadRecipe(recipeUrl);
    }

}
