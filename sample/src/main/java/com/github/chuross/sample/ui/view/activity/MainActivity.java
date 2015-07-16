package com.github.chuross.sample.ui.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.github.chuross.library.mvp.view.activity.PresentationActivity;
import com.github.chuross.sample.ui.presenter.MainPresenter;
import com.github.chuross.sample.ui.view.fragment.ListFragment;
import com.github.chuross.sample.ui.view.template.MainTemplate;

import java.util.List;

public class MainActivity extends PresentationActivity<MainPresenter> {

    @Override
    @NonNull
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainTemplate template = getPresenter().getTemplate();

        setContentView(template.getView());
        setSupportActionBar(template.getToolbar());

        final List<String> titles = getPresenter().getTitles();

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
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

        ViewPager viewPager = template.getViewPager();
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = template.getTabLayout();
        tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
