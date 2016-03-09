package com.github.chuross.library.mvp.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter;

public abstract class SupportPresentationFragment<PRESENTER extends SupportFragmentPresenter<?>, BINDING extends ViewDataBinding> extends Fragment {

    private PRESENTER presenter;
    private BINDING binding;

    @NonNull
    protected abstract PRESENTER createPresenter();

    protected abstract int getLayoutResourceId();

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.create(savedInstanceState);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        presenter.createView(container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, getLayoutResourceId(), container, false);
        return binding.getRoot();
    }

    /**
     * use onViewCreated(TEMPLATE template, Bundle savedInstanceState)
     */
    @Override
    @Deprecated
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.viewCreated(savedInstanceState);
        onViewCreated(savedInstanceState);
    }

    public void onViewCreated(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    public void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        presenter.destroyView();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @NonNull
    public PRESENTER getPresenter() {
        return presenter;
    }

    @NonNull
    public BINDING getBinding() {
        return binding;
    }
}
