package com.github.chuross.library.mvp.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import com.github.chuross.library.mvp.view.template.Template;

public abstract class ActivityPresenter<ACTIVITY extends Activity, TEMPLATE extends Template> implements TemplatePresenter<ACTIVITY, TEMPLATE> {

    private ACTIVITY activity;
    private TEMPLATE template;
    private boolean destroyed = false;

    public ActivityPresenter(@NonNull ACTIVITY activity) {
        this.activity = activity;
        this.template = createTemplate(activity);
    }

    protected abstract TEMPLATE createTemplate(ACTIVITY activity);

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

    public void create(@Nullable Bundle savedInstanceState) {
    }

    public void start() {
    }

    public void resume() {
    }

    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        return false;
    }

    public boolean backPress() {
        return false;
    }

    public void pause() {
    }

    public void stop() {
    }

    public void destroy() {
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}