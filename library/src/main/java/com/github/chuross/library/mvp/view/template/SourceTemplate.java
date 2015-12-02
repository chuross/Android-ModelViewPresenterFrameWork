package com.github.chuross.library.mvp.view.template;

public interface SourceTemplate<SOURCE> extends Template {

    void apply(SOURCE source);
}
