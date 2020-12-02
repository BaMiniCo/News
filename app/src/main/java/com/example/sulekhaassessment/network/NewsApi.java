package com.example.sulekhaassessment.network;

import com.example.sulekhaassessment.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsResponse> getNewsList(@Query("sources") String newsSource,
                                   @Query("apiKey") String apiKey);
}
