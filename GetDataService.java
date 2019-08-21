package com.example.javaretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/json/movies.json")
    Call<List<RetroMovies>> getMovie();
}
