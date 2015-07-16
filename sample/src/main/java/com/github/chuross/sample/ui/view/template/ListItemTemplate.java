package com.github.chuross.sample.ui.view.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.github.chuross.library.mvp.view.template.AbstractListAdapterTemplate;
import com.github.chuross.sample.R;
import com.github.chuross.sample.domain.Item;

public class ListItemTemplate extends AbstractListAdapterTemplate<Item> {

    private String title;
    @Bind(R.id.txt_title)
    TextView titleText;

    public ListItemTemplate(@NonNull final Context context, final ViewGroup parent, String title) {
        super(context, R.layout.template_adapter_list_item, parent);
        ButterKnife.bind(this, getView());
        this.title = title;
    }

    @Override
    public void apply(final Item item) {
        titleText.setText(String.format("title=%s : position=%d", title, Item.getIdentityValue(item)));
    }
}
