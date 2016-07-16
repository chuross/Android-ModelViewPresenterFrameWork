package com.github.chuross.sample.entity;

import com.chuross.common.library.domain.AbstractEntity;

public class Item extends AbstractEntity<ItemIdentity, Item> {

    public Item(final ItemIdentity identity) {
        super(identity);
    }
}
