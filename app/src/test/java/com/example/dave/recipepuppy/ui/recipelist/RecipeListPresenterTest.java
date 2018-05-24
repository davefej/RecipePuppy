package com.example.dave.recipepuppy.ui.recipelist;


import com.example.dave.recipepuppy.TestRecipeApp;
import com.example.dave.recipepuppy.model.Recipe;

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
public class RecipeListPresenterTest {

    @Test
    public void showRecipe(){
        RecipeListPresenter mpresenter = mock(RecipeListPresenter.class);
        RecipeListScreen mscreen = mock(RecipeListScreen.class);
        Mockito.doCallRealMethod().when(mpresenter).attachScreen(mscreen);
        Recipe r = new Recipe();
        Mockito.doCallRealMethod().when(mpresenter).showRecipe(r);
        mpresenter.attachScreen(mscreen);
        mpresenter.showRecipe(r);
        verify(mpresenter, times(1)).showRecipe(r);
    }
}
