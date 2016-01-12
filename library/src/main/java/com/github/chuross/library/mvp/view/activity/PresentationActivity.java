package com.github.chuross.library.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.github.chuross.library.mvp.presenter.ActivityPresenter;
import com.github.chuross.library.mvp.view.template.Template;

public abstract class PresentationActivity<PRESENTER extends ActivityPresenter<?>, TEMPLATE extends Template> extends AppCompatActivity {

    private PRESENTER presenter;
    private TEMPLATE template;

    @NonNull
    public abstract PRESENTER createPresenter();

    @NonNull
    protected abstract TEMPLATE createTemplate();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.create(savedInstanceState);
        template = createTemplate();
        setContentView(template.getView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        return presenter.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(!presenter.backPress()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    public PRESENTER getPresenter() {
        return presenter;
    }

    public TEMPLATE getTemplate() {
        return template;
    }
}
