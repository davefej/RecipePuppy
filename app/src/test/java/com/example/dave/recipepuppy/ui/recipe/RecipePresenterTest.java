package com.example.dave.recipepuppy.ui.recipe;


import com.example.dave.recipepuppy.TestRecipeApp;
import com.example.dave.recipepuppy.interactior.RecipeInteractor;

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


public class RecipePresenterTest {

    @Test
    public void changeFavorites(){
        RecipePresenter mpresenter = mock(RecipePresenter.class);
        RecipeScreen mscreen = mock(RecipeScreen.class);
        RecipeInteractor rInteractor =  mock(RecipeInteractor.class);
        mpresenter.recipeInteractor = rInteractor;
        Mockito.doCallRealMethod().when(mpresenter).attachScreen(mscreen);
        Mockito.doCallRealMethod().when(mpresenter).changeFavorites("href");
        mpresenter.attachScreen(mscreen);
        mpresenter.changeFavorites("href");
        verify(rInteractor, times(1)).changeFavorites("href");
    }
}
