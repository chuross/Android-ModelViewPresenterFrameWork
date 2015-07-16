package com.github.chuross.sample.ui.view.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.github.chuross.library.mvp.view.template.NonApplyTemplate;
import com.github.chuross.sample.R;

public class MainTemplate extends NonApplyTemplate {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.layout_tab)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    public MainTemplate(@NonNull Context context) {
        super(context, R.layout.template_activity_main);
        ButterKnife.bind(this, getView());
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }
}
