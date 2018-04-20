package com.example.dave.recipepuppy.recipelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.di.DaggerRecipeListComponent;

import javax.inject.Inject;

public class RecipeListActivity extends AppCompatActivity {

    @Inject
    RecipeListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        DaggerRecipeListComponent.builder().build().inject(this);
    }
}
