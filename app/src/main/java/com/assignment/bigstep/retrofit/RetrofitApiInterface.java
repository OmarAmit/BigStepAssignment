package com.assignment.bigstep.retrofit;

import com.assignment.bigstep.model.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiInterface {

    @GET("/search")
    Call<VideoResponse> getMusicRecord(@Query("term") String term , @Query("media") String media);


}