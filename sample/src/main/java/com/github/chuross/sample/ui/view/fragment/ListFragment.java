package com.github.chuross.sample.ui.view.fragment;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.github.chuross.library.mvp.view.adapter.BindableArrayAdapter;
import com.github.chuross.library.mvp.view.fragment.SupportPresentationFragment;
import com.github.chuross.sample.R;
import com.github.chuross.sample.databinding.ListFragmentBinding;
import com.github.chuross.sample.databinding.ListItemAdapterBinding;
import com.github.chuross.sample.entity.Item;
import com.github.chuross.sample.ui.presenter.ListPresenter;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.List;

public class ListFragment extends SupportPresentationFragment<ListPresenter, ListFragmentBinding> {

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

    @Override
    protected int getLayoutResourceId() {
        return R.layout.list_fragment;
    }

    @Override
    public void onViewCreated(@Nullable final Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);

        final ArrayAdapter<Item> adapter = new BindableArrayAdapter<Item, ListItemAdapterBinding>(getActivity().getApplicationContext()) {
            @Override
            protected int getLayoutResourceId() {
                return R.layout.list_item_adapter;
            }

            @Override
            protected void bind(final Item item, final ListItemAdapterBinding binding) {
                binding.setItem(item);
            }
        };

        ListFragmentBinding binding = getBinding();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.list.setNestedScrollingEnabled(true);
        }
        binding.list.setAdapter(adapter);
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
