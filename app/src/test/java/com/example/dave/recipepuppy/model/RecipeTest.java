package com.example.dave.recipepuppy.model;

import com.example.dave.recipepuppy.TestRecipeApp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestRecipeApp.class)
public class RecipeTest {

    @Test
    public void testRecipe(){
        Recipe r = new Recipe("title","href","ingredients","imgurl",true);
        Assert.assertEquals("title",r.getTitle());
        Assert.assertEquals("href",r.getHref());
        Assert.assertEquals("ingredients",r.getIngredients());
        Assert.assertEquals("imgurl",r.getImgurl());
        Assert.assertTrue(r.isFavorite());

    }
}
