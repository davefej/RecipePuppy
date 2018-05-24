package com.example.dave.recipepuppy;

import com.example.dave.recipepuppy.interactior.InteractorModule;
import com.example.dave.recipepuppy.interactior.RecipeInteractor;
import com.example.dave.recipepuppy.ui.UIModule;
import com.example.dave.recipepuppy.ui.main.MainActivity;
import com.example.dave.recipepuppy.network.NetworkModule;
import com.example.dave.recipepuppy.ui.recipe.RecipeActivity;
import com.example.dave.recipepuppy.ui.recipe.RecipePresenter;
import com.example.dave.recipepuppy.ui.recipelist.RecipeListActivity;
import com.example.dave.recipepuppy.ui.recipelist.RecipeListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,InteractorModule.class})
public interface RecipeAppConponent {
    void inject(MainActivity mainActivity);

    void inject(RecipeInteractor recipeInteractor);

    void inject(RecipeListPresenter recipeListPresenter);

    void inject(RecipePresenter recipePresenter);

    void inject(RecipeActivity recipeActivity);

    void inject(RecipeListActivity recipeListActivity);

}
