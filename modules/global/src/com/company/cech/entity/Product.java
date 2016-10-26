package com.company.cech.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s (%s)|name,category")
@Table(name = "CECH_PRODUCT")
@Entity(name = "cech$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = 310712898328192450L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CATEGORY_ID")
    protected ProductCategory category;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}