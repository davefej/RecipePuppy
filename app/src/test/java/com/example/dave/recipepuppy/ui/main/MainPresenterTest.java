package com.example.dave.recipepuppy.ui.main;

import com.example.dave.recipepuppy.TestRecipeApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestRecipeApp.class)
public class MainPresenterTest {

    @Test
    public void showFavirotes(){
        MainPresenter mpresenter = mock(MainPresenter.class);
        MainScreen mscreen = mock(MainScreen.class);
        Mockito.doCallRealMethod().when(mpresenter).attachScreen(mscreen);
        Mockito.doCallRealMethod().when(mpresenter).showFavorites();
        mpresenter.attachScreen(mscreen);
        mpresenter.showFavorites();
        verify(mpresenter, times(1)).showFavorites();
    }


    @Test
    public void showRecipes(){
        MainPresenter mpresenter = mock(MainPresenter.class);
        MainScreen mscreen = mock(MainScreen.class);
        Mockito.doCallRealMethod().when(mpresenter).attachScreen(mscreen);
        Mockito.doCallRealMethod().when(mpresenter).showRecipes("pizza");
        mpresenter.attachScreen(mscreen);
        mpresenter.showRecipes("pizza");
        verify(mpresenter, times(1)).showRecipes("pizza");
    }
}
