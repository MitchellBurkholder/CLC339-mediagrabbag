package com.grabbag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grabbag.model.products*;

@Controller
@RequestMapping("/product")
public class ProductController
{
    @GetMapping("/showAdd")
    public String addProductForm(Model model)
    {
        model.addAttribute("title", "Add Product Form");
        model.addAttribute("addProductModel", new ProductModel());
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
        productService.addProduct(productModel);
        return "redirect:/home/";
    }
}