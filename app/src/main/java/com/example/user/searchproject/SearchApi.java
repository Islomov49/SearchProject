package com.example.user.searchproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 03.07.17.
 */

public interface SearchApi {
    @GET("customsearch/v1")
    Call<String> searchQuery(@Query("q") String query,
                             @Query("key") String apiKey,
                             @Query("cx") String searchEngineId,
                             @Query("alt") String resultFormat,
                             @Query("count") int resultCount);
}
