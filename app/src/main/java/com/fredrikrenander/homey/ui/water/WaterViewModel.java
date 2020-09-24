package com.fredrikrenander.homey.ui.water;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WaterViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public WaterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is water fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}