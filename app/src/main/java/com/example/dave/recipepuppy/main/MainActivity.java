package com.example.dave.recipepuppy.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.di.DaggerMainComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().build().inject(this);
        mainPresenter.showFavorites();

    }
}
