package com.github.chuross.library.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

public abstract class SupportFragmentPresenter<FRAGMENT extends Fragment> implements Presenter<FRAGMENT> {

    private FRAGMENT fragment;
    private boolean viewDestroyed;
    private boolean destroyed;

    public SupportFragmentPresenter(@NonNull FRAGMENT fragment) {
        this.fragment = fragment;
    }

    public void create(@Nullable Bundle savedInstanceState) {
        destroyed = false;
    }

    public void createView(@NonNull ViewGroup parent, @Nullable Bundle savedInstanceState) {
        viewDestroyed = false;
    }

    public void viewCreated(@Nullable Bundle savedInstanceState) {
    }

    public void start() {
    }

    public void resume() {
    }

    public void pause() {
    }

    public void stop() {
    }

    public void destroyView() {
        viewDestroyed = true;
    }

    public void destroy() {
        destroyed = true;
    }

    @NonNull
    @Override
    public FRAGMENT getView() {
        return fragment;
    }

    public boolean isViewDestroyed() {
        return viewDestroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
