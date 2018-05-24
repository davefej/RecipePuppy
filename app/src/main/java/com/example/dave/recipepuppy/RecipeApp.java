package com.example.dave.recipepuppy;

import android.app.Application;

import com.example.dave.recipepuppy.ui.UIModule;
import com.orm.SugarApp;

public class RecipeApp extends SugarApp{

    public static RecipeAppConponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerRecipeAppConponent.builder().uIModule(new UIModule(this)).build();

    }
}
