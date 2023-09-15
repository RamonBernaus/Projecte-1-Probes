package com.example.projecte_1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("auth/{id}")
    Call<QuestionResponse> getQuestion(@Path("id") String id);
}

