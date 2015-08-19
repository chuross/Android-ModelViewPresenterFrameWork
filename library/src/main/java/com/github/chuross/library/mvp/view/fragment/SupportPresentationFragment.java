package com.github.chuross.library.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter;
import com.github.chuross.library.mvp.view.template.Template;

public abstract class SupportPresentationFragment<PRESENTER extends SupportFragmentPresenter<?, TEMPLATE>, TEMPLATE extends Template> extends Fragment {

    private PRESENTER presenter;

    @NonNull
    public abstract PRESENTER createPresenter();

    @NonNull
    public abstract TEMPLATE createTemplate(@NonNull final ViewGroup container, @NonNull final Bundle savedInstanceState);

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return presenter.onCreateView(createTemplate(container, savedInstanceState));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    public PRESENTER getPresenter() {
        return presenter;
    }
}
