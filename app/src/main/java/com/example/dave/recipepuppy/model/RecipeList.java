package com.example.dave.recipepuppy.model;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.util.List;

import retrofit.client.OkClient;

public class RecipeList {

    List<Recipe> favorites;
    List<Recipe> searchResult;


    public void getByKeyWord(String keyword){


        /*
        List<Recipe> list = Recipe.listAll(Recipe.class);
        for (Recipe r: list) {
            if(r.title.contains(keyword)){
                favorites.add(r);
            }
        }
        */
    }

}
