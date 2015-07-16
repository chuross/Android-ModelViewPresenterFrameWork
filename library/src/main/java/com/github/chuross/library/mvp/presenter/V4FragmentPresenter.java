package com.github.chuross.library.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.github.chuross.library.mvp.view.template.Template;

public class V4FragmentPresenter<FRAGMENT extends Fragment, TEMPLATE extends Template> implements Presenter<FRAGMENT> {

    private FRAGMENT fragment;
    private TEMPLATE template;
    private boolean destroyed = false;

    public V4FragmentPresenter(FRAGMENT fragment) {
        this.fragment = fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    public View onCreateView(@NonNull TEMPLATE template) {
        this.template = template;
        return template.getView();
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        destroyed = true;
        fragment = null;
        template = null;
    }

    @Override
    @NonNull
    public FRAGMENT getView() {
        return fragment;
    }

    public TEMPLATE getTemplate() {
        return template;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
