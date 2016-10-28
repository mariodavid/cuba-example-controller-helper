package com.company.cech.web.lineitem

import com.company.cech.entity.ProductCategory;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.cech.entity.LineItem
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.PickerField

import javax.inject.Named;

public class LineItemEdit extends AbstractEditor<LineItem> {

    @Named("fieldGroup.productCategory")
    PickerField productCategoryPickerField

    @Named("fieldGroup.product")
    PickerField productPickerField

    @Override
    void init(Map<String, Object> params) {
        super.init(params)
        createDependentPickerFieldHelper()
    }

    private createDependentPickerFieldHelper() {
        new DependentPickerFieldHelper(
                parent: productCategoryPickerField,
                child: productPickerField,
                childAttribute: "productCategory"
        ).init()
    }
}