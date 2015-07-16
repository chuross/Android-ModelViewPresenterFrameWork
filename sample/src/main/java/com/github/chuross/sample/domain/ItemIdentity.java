package com.github.chuross.sample.domain;

import com.chuross.common.library.domain.AbstractIdentity;

public class ItemIdentity extends AbstractIdentity<Long> {

    public ItemIdentity(final Long value) {
        super(value);
    }
}
