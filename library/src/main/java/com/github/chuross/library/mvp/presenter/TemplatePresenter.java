package com.github.chuross.library.mvp.presenter;

import com.github.chuross.library.mvp.view.template.Template;

public interface TemplatePresenter<VIEW, TEMPLATE extends Template> extends Presenter<VIEW> {

    TEMPLATE getTemplate();
}
