package com.example.dave.recipepuppy.ui.recipe;

import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.interactior.RecipeInteractor;
import com.example.dave.recipepuppy.ui.Presenter;
import com.example.dave.recipepuppy.ui.main.MainScreen;

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
        RecipeApp.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void changeFavorites(String href) {
        recipeInteractor.changeFavorites(href);
    }

}
