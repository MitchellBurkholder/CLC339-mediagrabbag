package com.grabbag.business;

import java.util.List;
import com.grabbag.model.products.*;

public interface ProductBusinessServiceInterface {
    List<ProductModel> getProducts();
    List<ProductModel> searchProducts(String name);
}
