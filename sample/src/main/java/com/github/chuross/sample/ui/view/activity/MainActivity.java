package com.github.chuross.sample.ui.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.github.chuross.library.mvp.view.activity.PresentationActivity;
import com.github.chuross.sample.R;
import com.github.chuross.sample.databinding.MainActivityBinding;
import com.github.chuross.sample.ui.presenter.MainPresenter;
import com.github.chuross.sample.ui.view.fragment.ListFragment;

import java.util.List;

public class MainActivity extends PresentationActivity<MainPresenter, MainActivityBinding> {

    @Override
    @NonNull
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.main_activity;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding binding = getBinding();

        setSupportActionBar(binding.toolbar);

        final List<String> titles = getPresenter().getTitles();

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                return ListFragment.create(titles.get(position));
            }

            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public CharSequence getPageTitle(final int position) {
                return titles.get(position);
            }
        };

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = binding.tabLayout;
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
