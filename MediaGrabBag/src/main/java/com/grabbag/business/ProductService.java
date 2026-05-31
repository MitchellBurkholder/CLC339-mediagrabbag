package com.grabbag.business;

import com.grabbag.model.products.ProductModel;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements com.grabbag.business.ProductInterface
{
    @Override
    public void addProduct(ProductModel product)
    {
        System.out.println("Adding product " + product.getTitle());
    }
}