package com.github.chuross.library.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.github.chuross.library.mvp.presenter.ActivityPresenter;

public abstract class PresentationActivity<PRESENTER extends ActivityPresenter<?, ?>> extends AppCompatActivity {

    private PRESENTER presenter;

    @NonNull
    public abstract PRESENTER createPresenter();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        return presenter.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(!presenter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    public PRESENTER getPresenter() {
        return presenter;
    }
}
