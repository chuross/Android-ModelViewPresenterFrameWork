package com.github.chuross.sample.domain;

import com.chuross.common.library.domain.AbstractEntity;

public class Item extends AbstractEntity<ItemIdentity, Item> {

    public Item(final ItemIdentity identity) {
        super(identity);
    }

    public static long getIdentityValue(Item item) {
        return item != null && item.getIdentity() != null ? item.getIdentity().getValue() : -1;
    }
}
