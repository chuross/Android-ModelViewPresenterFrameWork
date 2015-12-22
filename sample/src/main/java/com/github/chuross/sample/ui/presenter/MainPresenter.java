package com.github.chuross.sample.ui.presenter;

import android.support.annotation.NonNull;
import com.github.chuross.library.mvp.presenter.ActivityPresenter;
import com.github.chuross.sample.ui.view.activity.MainActivity;
import com.github.chuross.sample.ui.view.template.MainTemplate;

import java.util.Arrays;
import java.util.List;

public class MainPresenter extends ActivityPresenter<MainActivity, MainTemplate> {

    private static final List<String> TITLES = Arrays.asList("one", "two", "three", "four", "five");

    public MainPresenter(@NonNull final MainActivity activity) {
        super(activity);
    }

    @Override
    protected MainTemplate createTemplate(final MainActivity activity) {
        return new MainTemplate(activity);
    }

    public List<String> getTitles() {
        return TITLES;
    }
}
