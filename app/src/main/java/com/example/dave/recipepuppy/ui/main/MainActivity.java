package com.example.dave.recipepuppy.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        Button b = (Button) findViewById(R.id.button);
        final EditText tw = (EditText) findViewById(R.id.textView);
        tw.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    showRecipes(tw.getText().toString());
                    return true;
                }
                return false;
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRecipes(tw.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_favorites:
                showFavorites();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
