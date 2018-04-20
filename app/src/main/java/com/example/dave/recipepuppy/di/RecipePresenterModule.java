package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.recipe.RecipePresenter;
import com.example.dave.recipepuppy.recipe.RecipePresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RecipePresenterModule {

    @Provides
    RecipePresenter recipePresenter(RecipePresenterImpl presenter){
        return presenter;
    }
}
