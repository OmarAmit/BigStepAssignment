package com.assignment.bigstep.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.assignment.bigstep.model.Video;
import com.assignment.bigstep.model.VideoResponse;
import com.assignment.bigstep.retrofit.RetrofitApiInterface;
import com.assignment.bigstep.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicRepository {
    private ArrayList<Video> music = new ArrayList<>();
    private MutableLiveData<List<Video>> mutableLiveData = new MutableLiveData<>();


    public MusicRepository() {

    }

    public MutableLiveData<List<Video>> getMutableLiveData() {

        RetrofitApiInterface movieDataService = RetrofitInstance.getService();

        Call<VideoResponse> call = movieDataService.getMusicRecord("Michael+jackson", "musicVideo");

        call.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                Log.e("response", response.toString());
                VideoResponse movieDBResponse = response.body();


                if (movieDBResponse != null && movieDBResponse.getMusic() != null) {

                    music = (ArrayList<Video>) movieDBResponse.getMusic();
                    mutableLiveData.setValue(music);
                }
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {


            }
        });

        return mutableLiveData;
    }
}
