package com.example.dave.recipepuppy.interactor;

import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.RecipeAppConponent;
import com.example.dave.recipepuppy.TestRecipeApp;
import com.example.dave.recipepuppy.interactior.RecipeInteractor;
import com.example.dave.recipepuppy.model.Recipe;
import com.example.dave.recipepuppy.network.NetworkRecipe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(RobolectricTestRunner.class)
@Config(application = TestRecipeApp.class)
public class RecipeInteractorTest {

    @Before
    public void init(){
        RecipeApp.injector = mock(RecipeAppConponent.class);
    }

    @Test // 4
    public void modelMapping() {
        RecipeInteractor rinteractior = new RecipeInteractor();
        List<NetworkRecipe> list = new ArrayList<NetworkRecipe>();
        list.add(new NetworkRecipe("title","href","ingredients","thumbnail"));
        List<Recipe> res = rinteractior.mapRecipeModel(list);
        Assert.assertEquals(res.get(0).getHref(),"href");
        Assert.assertEquals(res.get(0).getTitle(),"title");
        Assert.assertEquals(res.get(0).getImgurl(),"thumbnail");
        Assert.assertEquals(res.get(0).getIngredients(),"ingredients");
    }

    @Test
    public void changeFavoritesAdd(){
        RecipeInteractor rinteractior = mock(RecipeInteractor.class);
        Mockito.doCallRealMethod().when(rinteractior).changeFavorites("href");
        Mockito.when(rinteractior.isFavorite("href")).thenReturn(false);
        rinteractior.changeFavorites("href");
        verify(rinteractior, times(1)).addToFavorites("href");
    }

    @Test
    public void changeFavoritesRemove(){
        RecipeInteractor rinteractior = mock(RecipeInteractor.class);
        Mockito.doCallRealMethod().when(rinteractior).changeFavorites("href");
        Mockito.when(rinteractior.isFavorite("href")).thenReturn(true);
        rinteractior.changeFavorites("href");
        verify(rinteractior, times(1)).removeFromFavorites("href");
    }

}
