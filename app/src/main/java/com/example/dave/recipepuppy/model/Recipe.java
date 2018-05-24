package com.example.dave.recipepuppy.model;

import com.orm.SugarRecord;

public class Recipe extends SugarRecord<Recipe> {

    private String title;
    private String href;
    private String ingredients;
    private String imgurl;
    private boolean favorite;

    public Recipe(){

    }

    public Recipe(String title, String href, String ingredients, String imgurl, boolean favorite){
        this.title = title;
        this.href = href;
        this.ingredients = ingredients;
        this.imgurl = imgurl;
        this.favorite = favorite;
    }

    public void setFavorite(boolean favorite){
        this.favorite = favorite;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
