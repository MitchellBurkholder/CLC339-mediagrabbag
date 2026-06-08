package com.grabbag.controller;

import com.grabbag.business.ProductInterface;
import com.grabbag.data.ProductDataInterface;
import com.grabbag.model.products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductDataInterface productService;

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
        productService.create(productModel);
        return "redirect:/";
    }
}