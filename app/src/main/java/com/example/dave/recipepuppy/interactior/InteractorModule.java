package com.example.dave.recipepuppy.interactior;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public RecipeInteractor provideArtistsInteractor() {
        return new RecipeInteractor();
    }
}
