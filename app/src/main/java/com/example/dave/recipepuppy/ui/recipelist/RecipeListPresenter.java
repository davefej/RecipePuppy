package com.example.dave.recipepuppy.ui.recipelist;

import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.interactior.RecipeInteractor;
import com.example.dave.recipepuppy.model.Recipe;
import com.example.dave.recipepuppy.ui.Presenter;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class RecipeListPresenter extends Presenter<RecipeListScreen>{

    @Inject
    RecipeInteractor recipeInteractor;

    @Inject
    Executor networkExecutor;

    @Override
    public void attachScreen(RecipeListScreen screen) {
        super.attachScreen(screen);
        RecipeApp.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void addToFavorites(){
        screen.addToFavorites();
    }

    public void showRecipe(String recipeUrl){
        screen.showRecipe(recipeUrl);
    }

    public void loadRecipes(final String keyword){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                recipeInteractor.listRecipes(keyword);
                //TODO
            }
        });

    }

    public void loadFavorites() {
        recipeInteractor.listFavorites();
    }
}
