package com.github.chuross.sample.ui.presenter;

import android.app.Application;
import android.widget.Toast;
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter;
import com.github.chuross.sample.domain.Item;
import com.github.chuross.sample.domain.ItemRepository;
import com.github.chuross.sample.ui.view.fragment.ListFragment;
import com.github.chuross.sample.ui.view.template.ListTemplate;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.app.AppObservable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

import java.util.List;

public class ListPresenter extends SupportFragmentPresenter<ListFragment, ListTemplate> {

    private ItemRepository itemRepository = new ItemRepository();
    private CompositeSubscription subscriptions = new CompositeSubscription();

    public ListPresenter(final ListFragment fragment) {
        super(fragment);
    }

    @Override
    public void destroyView() {
        super.destroyView();
        subscriptions.unsubscribe();
    }

    public Observable<List<Item>> getItems() {
        return itemRepository.getItems();
    }

    public void subscribeGetItems(Scheduler scheduler, Action1<List<Item>> action) {
        subscriptions.add(subscribe(scheduler, getItems(), action));
    }

    public void onListItemClicked(int position) {
        Toast.makeText(getApplication(), "position=" + position, Toast.LENGTH_SHORT).show();
    }

    private <R> Subscription subscribe(Scheduler scheduler, Observable<R> source, Action1<R> action) {
        return AppObservable.bindSupportFragment(getView(), source)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action);
    }

    private <R> Subscription subscribe(Scheduler scheduler, Observable<R> source, Observer<R> observer) {
        return AppObservable.bindSupportFragment(getView(), source)
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private Application getApplication() {
        return getView().getActivity().getApplication();
    }
}
