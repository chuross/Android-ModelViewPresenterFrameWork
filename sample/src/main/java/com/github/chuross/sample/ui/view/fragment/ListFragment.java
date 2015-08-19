package com.github.chuross.sample.ui.view.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.github.chuross.library.mvp.view.adapter.TemplateArrayAdapter;
import com.github.chuross.library.mvp.view.fragment.SupportPresentationFragment;
import com.github.chuross.sample.domain.Item;
import com.github.chuross.sample.ui.presenter.ListPresenter;
import com.github.chuross.sample.ui.view.template.ListItemTemplate;
import com.github.chuross.sample.ui.view.template.ListTemplate;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.List;

public class ListFragment extends SupportPresentationFragment<ListPresenter, ListTemplate> {

    private static final String ARGUMENT_KEY_TITLE = "argument_key_title";

    public static ListFragment create(String title) {
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_KEY_TITLE, title);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @NonNull
    @Override
    public ListPresenter createPresenter() {
        return new ListPresenter(this);
    }

    @NonNull
    @Override
    public ListTemplate createTemplate(@NonNull final ViewGroup container, @NonNull final Bundle savedInstanceState) {
        return new ListTemplate(getActivity(), container);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String title = getArguments().getString(ARGUMENT_KEY_TITLE);

        final ArrayAdapter<Item> adapter = new TemplateArrayAdapter<Item, ListItemTemplate>(getActivity().getApplicationContext()) {
            @Override
            protected ListItemTemplate onCreateTemplate(ViewGroup parent) {
                return new ListItemTemplate(getContext(), parent, title);
            }
        };

        final ListTemplate template = getPresenter().getTemplate();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            template.getList().setNestedScrollingEnabled(true);
        }
        template.getList().setAdapter(adapter);
        template.getList().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                getPresenter().onListItemClicked(position);
            }
        });

        getPresenter().subscribeGetItems(Schedulers.from(AsyncTask.SERIAL_EXECUTOR), new Action1<List<Item>>() {
            @Override
            public void call(final List<Item> items) {
                adapter.addAll(items);
            }
        });
    }
}
