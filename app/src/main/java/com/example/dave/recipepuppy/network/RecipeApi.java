package com.example.dave.recipepuppy.network;


import retrofit.Callback;
import retrofit.http.*;
import retrofit.mime.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RecipeApi {
  /**
   * 
   * Sync method
   * 
   * @param q  (required)
   * @return Void
   */
  
  @GET("/api")
  Void listRecipes(
          @retrofit.http.Query("q") String q
  );

  /**
   * 
   * Async method
   * @param q  (required)
   * @param cb callback method
   */
  
  @GET("/api")
  void listRecipes(
          @retrofit.http.Query("q") String q, Callback<Void> cb
  );
}
