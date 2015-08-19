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
    private boolean destroyed = false;

    public SupportFragmentPresenter(@NonNull FRAGMENT fragment) {
        this.fragment = fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    public View onCreateView(@NonNull TEMPLATE template) {
        this.template = template;
        return template.getView();
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        destroyed = true;
        fragment = null;
        template = null;
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

    public boolean isDestroyed() {
        return destroyed;
    }
}
