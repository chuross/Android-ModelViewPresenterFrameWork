package com.github.chuross.library.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import com.github.chuross.library.mvp.view.activity.PresentationActivity;

public abstract class ActivityPresenter<ACTIVITY extends PresentationActivity<?, ?>> implements Presenter<ACTIVITY> {

    private ACTIVITY activity;
    private boolean destroyed = false;

    public ActivityPresenter(@NonNull ACTIVITY activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ACTIVITY getView() {
        return activity;
    }

    public void create(@Nullable Bundle savedInstanceState) {
    }

    public void start() {
    }

    public void resume() {
    }

    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        return false;
    }

    public boolean backPress() {
        return false;
    }

    public void pause() {
    }

    public void stop() {
    }

    public void destroy() {
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}