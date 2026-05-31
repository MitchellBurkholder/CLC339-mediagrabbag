package com.grabbag.business;

import org.springframework.stereotype.Service;

import com.grabbag.model.products*;

@Service
public class ProductService implements ProductInterface
{
    @Override
    public void addProduct(Product product)
    {
        System.out.println("Adding product " + product.Title);
    }
}