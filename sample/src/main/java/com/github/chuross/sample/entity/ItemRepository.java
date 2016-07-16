package com.github.chuross.sample.entity;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static List<com.github.chuross.sample.entity.Item> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(1L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(2L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(3L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(4L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(5L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(6L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(7L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(8L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(9L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(10L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(11L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(12L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(13L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(14L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(15L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(16L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(17L)));
        ITEMS.add(new com.github.chuross.sample.entity.Item(new ItemIdentity(18L)));
    }

    public Observable<List<com.github.chuross.sample.entity.Item>> getItems() {
        return Observable.from(ITEMS).toList();
    }
}