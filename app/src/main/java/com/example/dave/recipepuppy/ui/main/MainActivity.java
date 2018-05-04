package com.example.dave.recipepuppy.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.ui.recipelist.RecipeListActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen{

    public static final String KEY_WORD = "KEY_WORD";
    public static final String FAVORITES = "FAVORITES";

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecipeApp.injector.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.showRecipes("Pizza");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showRecipes(String keyword) {
        Intent intent = new Intent(MainActivity.this, RecipeListActivity.class);
        intent.putExtra(KEY_WORD, keyword);
        startActivity(intent);
    }

    @Override
    public void showFavorites() {
        Intent intent = new Intent(MainActivity.this, RecipeListActivity.class);
        intent.putExtra(KEY_WORD, FAVORITES);
        startActivity(intent);
    }
}
