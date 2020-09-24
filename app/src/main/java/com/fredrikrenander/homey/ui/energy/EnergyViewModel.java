package com.fredrikrenander.homey.ui.energy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnergyViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public EnergyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is energy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}