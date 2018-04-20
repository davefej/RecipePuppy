package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.recipe.RecipePresenter;
import com.example.dave.recipepuppy.recipe.RecipePresenterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RecipeModule {
    @Binds
    public abstract RecipePresenter bindHomePresenter(RecipePresenterImpl
                                                                  recipePresenter);
}

