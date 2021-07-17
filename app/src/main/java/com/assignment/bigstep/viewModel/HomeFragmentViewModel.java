package com.assignment.bigstep.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.assignment.bigstep.model.Video;
import com.assignment.bigstep.repository.MusicRepository;

import java.util.List;

public class HomeFragmentViewModel extends ViewModel {
    private MusicRepository musicRepository;

    public HomeFragmentViewModel() {
        musicRepository=new MusicRepository();
    }

    public LiveData<List<Video>> getAllMovies(){

        return musicRepository.getMutableLiveData();
    }


}
