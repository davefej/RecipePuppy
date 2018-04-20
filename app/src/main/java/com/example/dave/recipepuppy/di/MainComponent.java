package com.example.dave.recipepuppy.di;

import com.example.dave.recipepuppy.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = MainModule.class)
@Singleton
public interface MainComponent {

    void inject(MainActivity activity);
}
