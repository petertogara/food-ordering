package com.brilliantminds.foodordering.order.service.business.entity;

import com.brilliantminds.foodordering.domain.valueobject.BaseId;
import com.brilliantminds.foodordering.domain.valueobject.Money;
import com.brilliantminds.foodordering.domain.valueobject.ProductId;

public class Product extends BaseId<ProductId> {
    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super(productId);
        this.name = name;
        this.price = price;
    }
    public Product(ProductId productId) {
        super(productId);
    }


    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

}
