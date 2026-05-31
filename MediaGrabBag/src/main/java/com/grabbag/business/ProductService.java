package com.grabbag.business;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductInterface
{
    @Override
    public void addProduct(Product product)
    {
        System.out.println("Adding product " + product.Title);
    }
}