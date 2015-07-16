package com.github.chuross.library.mvp.view.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public class NonApplyTemplate extends AbstractTemplate {

    @Deprecated
    public NonApplyTemplate(@NonNull final View view) {
        super(view);
    }

    public NonApplyTemplate(@NonNull final Context context, final int layoutResourceId) {
        super(context, layoutResourceId);
    }

    public NonApplyTemplate(@NonNull final Context context, final int layoutResourceId, final ViewGroup parent) {
        super(context, layoutResourceId, parent);
    }

    @Override
    public void apply() {
        throw new UnsupportedOperationException("apply is no supported.");
    }
}
