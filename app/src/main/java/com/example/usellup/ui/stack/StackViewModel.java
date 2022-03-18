package com.example.usellup.ui.stack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StackViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public StackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is stack fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}