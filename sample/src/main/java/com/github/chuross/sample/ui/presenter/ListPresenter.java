package com.github.chuross.sample.ui.presenter;

import android.app.Application;
import android.widget.Toast;
import com.github.chuross.library.mvp.presenter.V4FragmentPresenter;
import com.github.chuross.sample.domain.Item;
import com.github.chuross.sample.domain.ItemRepository;
import com.github.chuross.sample.ui.view.fragment.ListFragment;
import com.github.chuross.sample.ui.view.template.ListTemplate;
import rx.Observable;

import java.util.List;

public class ListPresenter extends V4FragmentPresenter<ListFragment, ListTemplate> {

    private ItemRepository itemRepository = new ItemRepository();

    public ListPresenter(final ListFragment fragment) {
        super(fragment);
    }

    public Observable<List<Item>> getItems() {
        return itemRepository.getItems();
    }

    public void onListItemClicked(int position) {
        Toast.makeText(getApplication(), "position=" + position, Toast.LENGTH_SHORT).show();
    }

    private Application getApplication() {
        return getView().getActivity().getApplication();
    }
}
