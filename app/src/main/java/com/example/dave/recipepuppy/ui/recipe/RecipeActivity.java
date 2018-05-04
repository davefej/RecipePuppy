package com.example.dave.recipepuppy.ui.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.RecipeApp;

import javax.inject.Inject;

public class RecipeActivity extends AppCompatActivity implements RecipeScreen {

    @Inject
    RecipePresenter recipePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        RecipeApp.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        recipePresenter.detachScreen();
    }


    @Override
    public void addToFavorites() {
        //TODO
    }

    @Override
    public void loadRecipe(String url) {
        //TODO WEBVIEw LOAD URL
    }


}
