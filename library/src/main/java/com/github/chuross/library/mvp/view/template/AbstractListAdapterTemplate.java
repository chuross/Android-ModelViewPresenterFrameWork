package com.github.chuross.library.mvp.view.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractListAdapterTemplate<SOURCE> extends AbstractTemplate implements SourceTemplate<SOURCE> {

    private SOURCE defaultSource;

    public AbstractListAdapterTemplate(@NonNull final View view) {
        super(view);
    }

    public AbstractListAdapterTemplate(@NonNull View view, SOURCE defaultSource) {
        super(view);
        this.defaultSource = defaultSource;
    }

    public AbstractListAdapterTemplate(@NonNull final Context context, final int layoutResourceId) {
        super(context, layoutResourceId);
    }

    public AbstractListAdapterTemplate(@NonNull Context context, int layoutResourceId, SOURCE defaultSource) {
        super(context, layoutResourceId);
        this.defaultSource = defaultSource;
    }

    public AbstractListAdapterTemplate(@NonNull final Context context, final int layoutResourceId, final ViewGroup parent) {
        super(context, layoutResourceId, parent);
    }

    public AbstractListAdapterTemplate(@NonNull Context context, int layoutResourceId, ViewGroup parent, SOURCE defaultSource) {
        super(context, layoutResourceId, parent);
        this.defaultSource = defaultSource;
    }

    public SOURCE getDefaultSource() {
        return defaultSource;
    }

    @Override
    public void apply() {
        apply(defaultSource);
    }
}
