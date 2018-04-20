package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.recipelist.RecipeListPresenter;
import com.example.dave.recipepuppy.recipelist.RecipeListPresenterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RecipeListModule {

    @Binds
    public abstract RecipeListPresenter bindHomePresenter(RecipeListPresenterImpl
                                                            recipeListPresenter);
}
