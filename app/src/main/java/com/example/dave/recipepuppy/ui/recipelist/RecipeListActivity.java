package com.example.dave.recipepuppy.ui.recipelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.ui.main.MainActivity;
import com.example.dave.recipepuppy.ui.recipe.RecipeActivity;

import javax.inject.Inject;

public class RecipeListActivity extends AppCompatActivity implements RecipeListScreen{

    public static String RECIPE_URL_KEY = "RECIPE_URL_KEY";

    @Inject
    RecipeListPresenter recipeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        RecipeApp.injector.inject(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        recipeListPresenter.attachScreen(this);
        String key = getIntent().getStringExtra(MainActivity.KEY_WORD);
        if(key.equals(MainActivity.FAVORITES)){
            recipeListPresenter.loadFavorites();
        }else{
            recipeListPresenter.loadRecipes(key);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        recipeListPresenter.detachScreen();
    }


    @Override
    public void addToFavorites() {
        //TODO
    }

    @Override
    public void showRecipe(String recipeUrl) {
        Intent intent = new Intent(RecipeListActivity.this, RecipeActivity.class);
        intent.putExtra(RECIPE_URL_KEY, recipeUrl);
        startActivity(intent);
    }
}
