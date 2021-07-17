package com.assignment.bigstep.view.fragment;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assignment.bigstep.R;
import com.assignment.bigstep.adapter.VideoAdapter;
import com.assignment.bigstep.databinding.FragmentVideoBinding;
import com.assignment.bigstep.model.Video;
import com.assignment.bigstep.viewModel.HomeFragmentViewModel;

import java.util.ArrayList;

public class VideoFragment extends Fragment {

    private TextView tv_noData;
    private FragmentVideoBinding fragmentVideoBinding;
    private ArrayList<Video> music;
    private RecyclerView recyclerView;
    private VideoAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    public HomeFragmentViewModel homeFragmentViewModel;


    public VideoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fragmentVideoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_video, container, false);

        homeFragmentViewModel = new ViewModelProvider(getActivity()).get(HomeFragmentViewModel.class);


        swipeRefreshLayout = fragmentVideoBinding.swipeLayout;
        tv_noData = fragmentVideoBinding.tvNoData;
        getPopularMovies();
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(() -> getPopularMovies());

        return fragmentVideoBinding.getRoot();

    }

    public void getPopularMovies() {
// set Refresh layout false
        swipeRefreshLayout.setRefreshing(false);
        homeFragmentViewModel.getAllMovies().observe(getActivity(), moviesFromLiveData -> {
            music = (ArrayList<Video>) moviesFromLiveData;
            showOnRecyclerView();
        });
    }

    private void showOnRecyclerView() {

        recyclerView = fragmentVideoBinding.rvSongs;
        movieAdapter = new VideoAdapter(getContext(), music);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();

        if (music.isEmpty()) {
            tv_noData.setVisibility(View.VISIBLE);
        } else {
            tv_noData.setVisibility(View.GONE);
        }

    }
}