package com.example.dave.recipepuppy.ui.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.ui.main.MainActivity;

import javax.inject.Inject;

import static com.example.dave.recipepuppy.ui.recipelist.RecipeListActivity.RECIPE_FAVIROTE;
import static com.example.dave.recipepuppy.ui.recipelist.RecipeListActivity.RECIPE_URL_KEY;

public class RecipeActivity extends AppCompatActivity implements RecipeScreen {

    @Inject
    RecipePresenter recipePresenter;
    WebView myWebView;
    String href = "";
    boolean favorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecipeApp.injector.inject(this);

        setContentView(R.layout.activity_recipe);
        myWebView = (WebView) findViewById(R.id.webView);
        href = getIntent().getStringExtra(RECIPE_URL_KEY);
        favorite  = getIntent().getBooleanExtra(RECIPE_FAVIROTE,false);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(href);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if(favorite){
            inflater.inflate(R.menu.menu, menu);
        }else{
            inflater.inflate(R.menu.menu2, menu);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_favorites:
                if(favorite){
                    item.setIcon(R.drawable.addtofavorites);
                }else{
                    item.setIcon(R.drawable.favorites);
                }
                favorite = ! favorite;
                recipePresenter.changeFavorites(href);

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
