package com.example.dave.recipepuppy.ui.main;

import com.example.dave.recipepuppy.ui.Presenter;

public class MainPresenter extends Presenter<MainScreen> {

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showRecipes(
            String keyword) {
        screen.showRecipes(keyword);
    }

    public void showFavorites() {
        screen.showFavorites();
    }

}
