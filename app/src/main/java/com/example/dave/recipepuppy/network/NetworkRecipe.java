package com.example.dave.recipepuppy.network;

import com.example.dave.recipepuppy.model.Recipe;


import java.util.List;

public class NetworkRecipe {

    private String title;
    private String href;
    private String ingredients;
    private String thumbnail;

    NetworkRecipe(String title, String href, String ingredients, String thumbnail){
        this.title = title;
        this.href = href;
        this.ingredients = ingredients;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}