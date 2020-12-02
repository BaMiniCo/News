package com.example.sulekhaassessment.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sulekhaassessment.network.NewsRepository;
import com.example.sulekhaassessment.model.NewsResponse;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews("google-news", "97597c3b3593428fbb109a01240654a9");

    }

    public LiveData<NewsResponse> getNewsRepository() {
        return mutableLiveData;
    }

}
