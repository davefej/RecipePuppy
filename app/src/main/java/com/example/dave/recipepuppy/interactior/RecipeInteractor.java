package com.example.dave.recipepuppy.interactior;

import android.util.Log;

import com.example.dave.recipepuppy.RecipeApp;
import com.example.dave.recipepuppy.model.Recipe;
import com.example.dave.recipepuppy.network.NetworkRecipe;
import com.example.dave.recipepuppy.network.NetworkRecipeResult;
import com.example.dave.recipepuppy.network.RecipeApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
            loadedRecipes = mapRecipeModel(list);
            for(Recipe r : loadedRecipes){
                if(isFavorite(r.getHref())){
                    r.setFavorite(true);
                }
            }
            return loadedRecipes;
        }
    }


    public List<Recipe> mapRecipeModel(List<NetworkRecipe> list){
        List<Recipe> list2 = new ArrayList<Recipe>();
        for (NetworkRecipe item: list) {
            boolean favorite = false;
            list2.add(new Recipe(
                    item.getTitle(),
                    item.getHref(),
                    item.getIngredients(),
                    item.getThumbnail(),
                    favorite
            ));
        }
        return list2;
    }



    public List<Recipe> listFavorites() {
        Iterator<Recipe> iter = Recipe.findAll(Recipe.class);
        List<Recipe> copy = new ArrayList<Recipe>();
        while (iter.hasNext()){
            copy.add(iter.next());
        }
        return copy;
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
        List<Recipe> favorites =  recipesByHref(url);
        for (Recipe recipe: favorites) {
            recipe.delete();
        }
    }

    public void changeFavorites(String href) {
        if(isFavorite(href)){
            removeFromFavorites(href);
        }else{
            addToFavorites(href);
        }
    }

    public boolean isFavorite(String href) {
        List<Recipe> favorites =  recipesByHref(href);
        return !(favorites == null || favorites.size() == 0);
    }

    private List<Recipe> recipesByHref(String href){
        return Recipe.find(Recipe.class,"href = ?",href);
    }

}
