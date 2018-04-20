package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.main.MainPresenter;
import com.example.dave.recipepuppy.main.MainPresenterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

    @Binds
    public abstract MainPresenter bindHomePresenter(MainPresenterImpl
                                                            homePresenterImp);
}
