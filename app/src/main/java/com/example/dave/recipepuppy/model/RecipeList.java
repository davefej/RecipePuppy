package com.example.dave.recipepuppy.model;

import java.util.List;

public class RecipeList {

    List<Recipe> favorites;
    List<Recipe> searchResult;


    public void getByKeyWord(String keyword){
        RecipeDownloader.download(keyword);
        List<Recipe> list = Recipe.listAll(Recipe.class);
        for (Recipe r: list) {
            if(r.title.contains(keyword)){
                favorites.add(r);
            }
        }
    }

}
