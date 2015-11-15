package com.github.chuross.library.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.github.chuross.library.mvp.view.template.Template;

public class SupportFragmentPresenter<FRAGMENT extends Fragment, TEMPLATE extends Template> implements TemplatePresenter<FRAGMENT, TEMPLATE> {

    private FRAGMENT fragment;
    private TEMPLATE template;
    private boolean viewDestroyed;
    private boolean destroyed;

    public SupportFragmentPresenter(@NonNull FRAGMENT fragment) {
        this.fragment = fragment;
    }

    public void create(@Nullable Bundle savedInstanceState) {
        destroyed = false;
    }

    public View createView(@NonNull TEMPLATE template) {
        viewDestroyed = false;

        this.template = template;
        return template.getView();
    }

    public void viewCreated(@NonNull TEMPLATE template, @Nullable Bundle savedInstanceState) {
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

    @Override
    public TEMPLATE getTemplate() {
        return template;
    }

    public boolean isViewDestroyed() {
        return viewDestroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
