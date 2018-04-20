package com.example.dave.recipepuppy.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.di.DaggerRecipeComponent;

import javax.inject.Inject;

public class RecipeActivity extends AppCompatActivity {


    @Inject
    RecipePresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        DaggerRecipeComponent.builder().build().inject(this);
    }
}
