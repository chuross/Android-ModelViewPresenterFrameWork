package com.github.chuross.sample.entity;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static List<com.github.chuross.sample.entity.Item> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new com.github.chuross.sample.entity.Item(1L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(2L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(3L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(4L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(5L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(6L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(7L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(8L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(9L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(10L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(11L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(12L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(13L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(14L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(15L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(16L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(17L));
        ITEMS.add(new com.github.chuross.sample.entity.Item(18L));
    }

    public Observable<List<com.github.chuross.sample.entity.Item>> getItems() {
        return Observable.from(ITEMS).toList();
    }
}