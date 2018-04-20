package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.main.MainPresenter;
import com.example.dave.recipepuppy.main.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {

    @Provides
    MainPresenter mainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }
}
