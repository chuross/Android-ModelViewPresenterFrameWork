package com.github.chuross.library.mvp.view.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractTemplate implements Template {

    private View view;

    /**
     * use layout resource id
     */
    @Deprecated
    public AbstractTemplate(@NonNull View view) {
        this.view = view;
    }

    public AbstractTemplate(@NonNull Context context, int layoutResourceId) {
        this(context, layoutResourceId, null);
    }

    public AbstractTemplate(@NonNull Context context, int layoutResourceId, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
    }

    @Override
    @NonNull
    public View getView() {
        return view;
    }
}
