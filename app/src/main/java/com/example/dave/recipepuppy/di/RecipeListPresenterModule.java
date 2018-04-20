package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.recipe.RecipePresenter;
import com.example.dave.recipepuppy.recipe.RecipePresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RecipeListPresenterModule {

    @Provides
    RecipePresenter recipePresenter(RecipePresenterImpl presenter){
        return presenter;
    }
}
