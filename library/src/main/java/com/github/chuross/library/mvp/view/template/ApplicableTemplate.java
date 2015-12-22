package com.github.chuross.library.mvp.view.template;

public interface ApplicableTemplate<SOURCE> extends Template {

    void apply(SOURCE source);
}
