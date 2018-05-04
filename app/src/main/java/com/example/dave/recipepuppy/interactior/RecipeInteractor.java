package com.example.dave.recipepuppy.interactior;

import android.util.Log;

import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.model.Recipe;
import com.example.dave.recipepuppy.network.NetworkRecipe;
import com.example.dave.recipepuppy.network.NetworkRecipeResult;
import com.example.dave.recipepuppy.network.RecipeApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;


public class RecipeInteractor {

    public static String SUGAR_TRUE = "1";
    public static String SUGAR_FALSE = "0";

    @Inject
    RecipeApi recipeApi;

    List<Recipe> loadedRecipes = null;

    public RecipeInteractor(){
        RecipeApp.injector.inject(this);
    }

    public List<Recipe> listRecipes(String keyword)  {
        Call<NetworkRecipeResult> queryCall = recipeApi.listRecipes(keyword);
        Response<NetworkRecipeResult> response = null;
        try {
            response = queryCall.execute();
        } catch (IOException e) {
            return null;
        }
        if (response.code() != 200) {
            return null;
        }else{
            List<NetworkRecipe> list =  response.body().getRecipes();
            List<Recipe> list2 = new ArrayList<Recipe>();
            for (NetworkRecipe item: list) {
                list2.add(new Recipe(
                        item.getTitle(),
                        item.getHref(),
                        item.getIngredients(),
                        item.getThumbnail(),
                        false
                ));
            }
            loadedRecipes = list2;
            return loadedRecipes;
        }
    }

    public List<Recipe> listFavorites() {
        return Recipe.find(Recipe.class,"favorites = ?",SUGAR_TRUE);
    }

    public void addToFavorites(String url) {
        if(loadedRecipes != null){
            for (Recipe recipe: loadedRecipes) {
                if(recipe.getHref().equals(url)){
                    recipe.setFavorite(true);
                    recipe.save();
                    break;
                }
            }
        }
    }

    public void removeFromFavorites(String url) {
        List<Recipe> favorites =  Recipe.find(Recipe.class,"href = ?",url);
        for (Recipe recipe: favorites) {
            recipe.delete();
        }
    }
}
