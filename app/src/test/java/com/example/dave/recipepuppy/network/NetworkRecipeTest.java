package com.example.dave.recipepuppy.network;

import com.example.dave.recipepuppy.TestRecipeApp;
import com.example.dave.recipepuppy.model.Recipe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestRecipeApp.class)
public class NetworkRecipeTest {

    @Test
    public void testNetworkRecipe(){
        NetworkRecipe r = new NetworkRecipe("title","href","ingredients","imgurl");
        Assert.assertEquals("title",r.getTitle());
        Assert.assertEquals("href",r.getHref());
        Assert.assertEquals("ingredients",r.getIngredients());
        Assert.assertEquals("imgurl",r.getThumbnail());
    }
}
