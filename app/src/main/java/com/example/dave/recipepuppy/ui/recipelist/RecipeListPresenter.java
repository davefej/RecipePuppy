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

    public void addToFavorites(Recipe r){
        r.setFavorite(true);
        recipeInteractor.addToFavorites(r.getHref());
    }

    public void showRecipe(Recipe recipe){
        screen.showRecipe(recipe);
    }

    public void loadRecipes(final String keyword){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<Recipe> list = recipeInteractor.listRecipes(keyword);
                screen.listRecipes(list);

            }
        });
    }

    public void loadFavorites() {
        screen.listRecipes(recipeInteractor.listFavorites());
    }

    public void removeFromFavorites(Recipe r) {
        r.setFavorite(false);
        recipeInteractor.removeFromFavorites(r.getHref());
    }
}
