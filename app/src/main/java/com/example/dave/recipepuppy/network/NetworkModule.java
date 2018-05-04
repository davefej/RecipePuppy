package com.example.dave.recipepuppy.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static String HOST = "http://www.recipepuppy.com/";

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public RecipeApi provideRecipeApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(HOST).build().create(RecipeApi.class);
    }

}
