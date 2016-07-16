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
    private int resourceId;

    public BindableArrayAdapter(final Context context, int resourceId) {
        this(context, new ArrayList<T>(), resourceId);
    }

    public BindableArrayAdapter(Context context, T[] items, int resourceId) {
        this(context, Arrays.asList(items), resourceId);
    }

    public BindableArrayAdapter(Context context, List<T> items, int resourceId) {
        super(context, 0, items);
        this.items = items;
        this.resourceId = resourceId;
    }

    protected abstract void bind(int position, T item, BINDING binding);

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final BINDING binding = bindMap.containsKey(convertView) ? bindMap.get(convertView) : createTemplate(parent);
        bind(position, getItem(position), binding);
        return binding.getRoot();
    }

    private BINDING createTemplate(ViewGroup parent) {
        BINDING binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), resourceId, parent, false);
        bindMap.put(binding.getRoot(), binding);
        return binding;
    }

    public List<T> getAll() {
        return items;
    }
}
