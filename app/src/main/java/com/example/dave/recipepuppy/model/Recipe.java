package com.example.dave.recipepuppy.model;

import com.orm.SugarRecord;

public class Recipe extends SugarRecord<Recipe> {

    String title;
    String href;
    String ingredients;
    String imgurl;
    boolean favorite;

    Recipe(){

    }

    Recipe(String title, String href, String ingredients, String imgurl, boolean favorite){
        this.title = title;
        this.href = href;
        this.ingredients = ingredients;
        this.imgurl = imgurl;
        this.favorite = favorite;
    }

    public void setFavorite(boolean favorite){
        this.favorite = favorite;
        if(favorite == true){
            this.save();
        }else{
            this.delete();
        }
    }

}
