package com.company.cech.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("No. %s|orderNr")
@Table(name = "CECH_ORDER")
@Entity(name = "cech$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -4440376983831286754L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    protected Date orderDate;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected Set<LineItem> lineItems;

    @Column(name = "ORDER_NR", nullable = false, unique = true)
    protected Integer orderNr;

    public void setOrderNr(Integer orderNr) {
        this.orderNr = orderNr;
    }

    public Integer getOrderNr() {
        return orderNr;
    }


    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }


    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }


}