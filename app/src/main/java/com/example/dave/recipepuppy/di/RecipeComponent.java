package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.recipe.RecipeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = RecipeModule.class)
@Singleton
public interface RecipeComponent {
    void inject(RecipeActivity activity);
}

