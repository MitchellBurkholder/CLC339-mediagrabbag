package com.grabbag.data;

import com.grabbag.model.products.ProductModel;
import java.util.List;

public interface ProductDataInterface
{
    public List<ProductModel> findAll();
    public ProductModel findById(int Id);
    public int create(ProductModel product);
    public int update(ProductModel productModel);
    public void delete(ProductModel productModel);
}
