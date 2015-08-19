package com.github.chuross.library.mvp.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import com.github.chuross.library.mvp.view.template.Template;

public class ActivityPresenter<ACTIVITY extends Activity, TEMPLATE extends Template> implements TemplatePresenter<ACTIVITY, TEMPLATE> {

    private ACTIVITY activity;
    private TEMPLATE template;
    private boolean destroyed = false;

    public ActivityPresenter(@NonNull ACTIVITY activity, @NonNull TEMPLATE template) {
        this.activity = activity;
        this.template = template;
    }

    @NonNull
    @Override
    public ACTIVITY getView() {
        return activity;
    }

    @NonNull
    @Override
    public TEMPLATE getTemplate() {
        return template;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        return false;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void destroy() {
        destroyed = true;
        activity = null;
        template = null;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}