package com.example.dave.recipepuppy.network;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {

  /**
   * 
   * Sync method
   *
   * @return Void
   */
  
  @GET("api")
  Call<NetworkRecipeResult> listRecipes(
          @Query("q") String keyword

  );

}
