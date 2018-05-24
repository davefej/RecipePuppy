package com.example.dave.recipepuppy.interactior;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Singleton
    @Provides
    public RecipeInteractor provideArtistsInteractor() {
        return new RecipeInteractor();
    }
}
