package com.github.chuross.library.mvp.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.github.chuross.library.mvp.view.template.ListAdapterTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public abstract class TemplateArrayAdapter<T, TEMPLATE extends ListAdapterTemplate<T>> extends ArrayAdapter<T> {

    private List<T> items;
    private final WeakHashMap<View, TEMPLATE> templateMap = new WeakHashMap<>();

    public TemplateArrayAdapter(final Context context) {
        this(context, new ArrayList<T>());
    }

    public TemplateArrayAdapter(Context context, T[] items) {
        this(context, Arrays.asList(items));
    }

    public TemplateArrayAdapter(Context context, List<T> items) {
        super(context, 0, items);
        this.items = items;
    }

    protected abstract TEMPLATE onCreateTemplate(ViewGroup parent);

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final TEMPLATE template = templateMap.containsKey(convertView) ? templateMap.get(convertView) : createTemplate(parent);
        template.apply(getItem(position));
        return template.getView();
    }

    private TEMPLATE createTemplate(ViewGroup parent) {
        final TEMPLATE template = onCreateTemplate(parent);
        templateMap.put(template.getView(), template);
        return template;
    }

    public List<T> getAll() {
        return items;
    }
}
