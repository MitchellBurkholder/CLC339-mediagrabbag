package com.grabbag.business;

import com.grabbag.model.products.ProductModel;

import java.util.ArrayList;

public interface ProductInterface
{
    public void create(ProductModel product);
    public void update(ProductModel product);
    public void delete(ProductModel product);
}
