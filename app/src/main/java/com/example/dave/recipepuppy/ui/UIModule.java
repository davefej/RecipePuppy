package com.example.dave.recipepuppy.ui;

import android.content.Context;

import com.example.dave.recipepuppy.ui.main.MainPresenter;
import com.example.dave.recipepuppy.ui.recipe.RecipePresenter;
import com.example.dave.recipepuppy.ui.recipelist.RecipeListPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public RecipePresenter provideRecipePresenter() {
        return new RecipePresenter();
    }

    @Provides
    @Singleton
    public RecipeListPresenter provideRecipeListPresenter() {
        return new RecipeListPresenter();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
