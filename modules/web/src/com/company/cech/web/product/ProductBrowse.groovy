package com.company.cech.web.product

import com.company.cech.entity.Product
import com.company.cech.entity.ProductCategory
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.Table
import com.haulmont.cuba.gui.data.CollectionDatasource

import javax.inject.Inject;

public class ProductBrowse extends AbstractLookup {

    @WindowParam
    ProductCategory productCategory

    @Inject
    CollectionDatasource<Product, UUID> productsDs

    @Override
    void init(Map<String, Object> params) {
        super.init(params)

        if (productCategory) {
            productsDs.setQuery('select e from cech$Product e where e.category.id = :param$productCategory')
        }
    }
}