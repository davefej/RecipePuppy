package com.example.dave.recipepuppy.ui.recipelist;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dave.recipepuppy.R;
import com.example.dave.recipepuppy.model.Recipe;

import java.util.List;

public class RecipeListAdapter  extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    RecipeListActivity activity;
    List<Recipe> recipes;
    private RecyclerView rw;

    public RecipeListAdapter(List<Recipe> recipes, RecipeListActivity activity, RecyclerView rw){
        this.recipes = recipes;
        this.activity = activity;
        this.rw = rw;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_view, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = rw.getChildLayoutPosition(v);
                activity.recipeListPresenter.showRecipe(recipes.get(itemPosition));
            }
        });

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Recipe r = recipes.get(position);
        holder.recipeName.setText(r.getTitle());

        holder.recipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recipes.get(position).isFavorite()){
                    activity.recipeListPresenter.removeFromFavorites(r);
                    holder.recipeImage.setImageResource(R.drawable.addtofavorites);
                }else{
                    activity.recipeListPresenter.addToFavorites(r);
                    holder.recipeImage.setImageResource(R.drawable.favorites);
                }

            }
        });

        if(r.isFavorite()){
            holder.recipeImage.setImageResource(R.drawable.favorites);

        }else{
            holder.recipeImage.setImageResource(R.drawable.addtofavorites);
        }

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView recipeName;
        public ImageView recipeImage;
        public ViewHolder(View v) {
            super(v);
            recipeImage = (ImageView) v.findViewById(R.id.recipeImage);
            recipeName = (TextView) v.findViewById(R.id.recipeName);
        }
    }
}
