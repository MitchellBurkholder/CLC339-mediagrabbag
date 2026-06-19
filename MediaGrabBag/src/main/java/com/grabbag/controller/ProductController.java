package com.grabbag.controller;

import com.grabbag.data.ProductDataInterface;
import com.grabbag.model.products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductDataInterface productService;

    @GetMapping("/allProducts")
    public String allProducts(Model model)
    {
        model.addAttribute("products", productService.findAll());
        return "Products";
    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model)
    {
        model.addAttribute("title", "Add Product Form");
        model.addAttribute("productModel", new ProductModel());
        return "AddProduct";
    }

    @PostMapping("/doAddProduct")
    public String addProduct(
            @Valid @ModelAttribute("productModel") ProductModel productModel,
            BindingResult bindingResult,
            Model model
    )
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Product Form");
            return "AddProduct";
        }

        switch(productModel.getType())
        {
            case Book:
                productService.create(productModel);
                return allProducts(model);
            case MovieOrShow:
                productService.create(productModel);
                return allProducts(model);
            case VideoGame:
                productService.create(productModel);
                return allProducts(model);
            default:
                return allProducts(model);
        }
    }

    @GetMapping("/editProduct/{id}")
    public String editProductForm(@PathVariable int id, Model model)
    {
        ProductModel product = productService.findById(id);

        model.addAttribute("title", "Edit Product Form");
        model.addAttribute("productModel", product);

        return "EditProduct";
    }

    @PostMapping("/doUpdateProduct")
    public String updateProduct(
        @Valid @ModelAttribute("productModel") ProductModel productModel,
        BindingResult bindingResult,
        Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Edit Product Form");
            return "EditProduct";
        }
        productService.update(productModel);
        return "redirect:/product/allProducts";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        ProductModel product = productService.findById(id);

        if(product != null)
        {
            productService.delete(product);
        }

        return "redirect:/product/allProducts";
    }
}
