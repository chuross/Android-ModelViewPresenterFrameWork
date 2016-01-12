package com.github.chuross.sample.ui.presenter;

import android.support.annotation.NonNull;
import com.github.chuross.library.mvp.presenter.ActivityPresenter;
import com.github.chuross.sample.ui.view.activity.MainActivity;

import java.util.Arrays;
import java.util.List;

public class MainPresenter extends ActivityPresenter<MainActivity> {

    private static final List<String> TITLES = Arrays.asList("one", "two", "three", "four", "five");

    public MainPresenter(@NonNull final MainActivity activity) {
        super(activity);
    }

    public List<String> getTitles() {
        return TITLES;
    }
}
