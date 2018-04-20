package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.recipelist.RecipeListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = RecipeListModule.class)
@Singleton
public interface RecipeListComponent {
    void inject(RecipeListActivity activity);
}