package com.grabbag.business;

import com.grabbag.model.products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements com.grabbag.business.ProductInterface
{
    /**
     * Method for adding a product
     * @param product
     */
    @Override
    public void create(ProductModel product)
    {
        System.out.println("Adding product " + product.getTitle());
    }
}