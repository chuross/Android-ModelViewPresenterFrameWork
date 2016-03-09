package com.github.chuross.library.mvp.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public abstract class BindableArrayAdapter<T, BINDING extends ViewDataBinding> extends ArrayAdapter<T> {

    private List<T> items;
    private final WeakHashMap<View, BINDING> bindMap = new WeakHashMap<>();

    public BindableArrayAdapter(final Context context) {
        this(context, new ArrayList<T>());
    }

    public BindableArrayAdapter(Context context, T[] items) {
        this(context, Arrays.asList(items));
    }

    public BindableArrayAdapter(Context context, List<T> items) {
        super(context, 0, items);
        this.items = items;
    }

    protected abstract int getLayoutResourceId();

    protected abstract void bind(T item, BINDING binding);

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final BINDING binding = bindMap.containsKey(convertView) ? bindMap.get(convertView) : createTemplate(parent);
        bind(getItem(position), binding);
        return binding.getRoot();
    }

    private BINDING createTemplate(ViewGroup parent) {
        BINDING binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), getLayoutResourceId(), parent, false);
        bindMap.put(binding.getRoot(), binding);
        return binding;
    }

    public List<T> getAll() {
        return items;
    }
}
