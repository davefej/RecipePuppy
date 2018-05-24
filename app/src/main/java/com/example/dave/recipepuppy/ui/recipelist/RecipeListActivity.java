package com.example.dave.recipepuppy.ui.recipelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.model.Recipe;
import com.example.dave.recipepuppy.ui.main.MainActivity;
import com.example.dave.recipepuppy.ui.recipe.RecipeActivity;

import java.util.List;

import javax.inject.Inject;

public class RecipeListActivity extends AppCompatActivity implements RecipeListScreen{

    public static String RECIPE_URL_KEY = "RECIPE_URL_KEY";
    public static String RECIPE_FAVIROTE = "RECIPE_FAVIROTE";
    RecyclerView mRecyclerView;

    @Inject
    RecipeListPresenter recipeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        RecipeApp.injector.inject(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recipe_list_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

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
    public void showRecipe(Recipe recipe) {
        Intent intent = new Intent(RecipeListActivity.this, RecipeActivity.class);
        intent.putExtra(RECIPE_URL_KEY, recipe.getHref());
        intent.putExtra(RECIPE_FAVIROTE, recipe.isFavorite());
        startActivity(intent);
    }

    @Override
    public void listRecipes(final List<Recipe> recipes) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecipeListAdapter mAdapter = new RecipeListAdapter(recipes,RecipeListActivity.this,mRecyclerView);
                mRecyclerView.setAdapter(mAdapter);
            }
        });

    }

}
