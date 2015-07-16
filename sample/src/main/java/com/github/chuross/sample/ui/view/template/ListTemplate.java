package com.github.chuross.sample.ui.view.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.github.chuross.library.mvp.view.template.NonApplyTemplate;
import com.github.chuross.sample.R;

public class ListTemplate extends NonApplyTemplate {

    @Bind(R.id.list)
    ListView list;

    public ListTemplate(@NonNull final Context context, @Nullable final ViewGroup parent) {
        super(context, R.layout.template_fragment_list, parent);
        ButterKnife.bind(this, getView());
    }

    public ListView getList() {
        return list;
    }
}
