package com.grabbag.controller;

import com.grabbag.data.ProductDataInterface;
import com.grabbag.data.ProductMapper;
import com.grabbag.model.products.BookModel;
import com.grabbag.model.products.MovieAndShowModel;
import com.grabbag.model.products.ProductModel;
import com.grabbag.model.products.VideoGameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductDataInterface productService;
    private ProductMapper productMapper = new ProductMapper();

    @GetMapping("/allProducts")
    public String allProducts(Model model)
    {
        model.addAttribute("products", productService.findAll());
        return "Products";
    }

    @GetMapping("/allBooks")
    public String allBooks(Model model)
    {
        List<ProductModel> products = productService.findAll();
        ArrayList<BookModel> books = new ArrayList<>();

        for (ProductModel product : products)
        {
            books.add(productMapper.productToBook(product));
        }

        model.addAttribute("books", books);
        return "Books";
    }

    @GetMapping("/allMoviesOrShows")
    public String allMoviesOrShows(Model model)
    {
        List<ProductModel> products = productService.findAll();
        ArrayList<MovieAndShowModel> moviesAndShows = new ArrayList<>();

        for (ProductModel product : products)
        {
            moviesAndShows.add(productMapper.productToMovieOrShow(product));
        }

        model.addAttribute("moviesAndShows", moviesAndShows);
        return "MoviesAndShows";
    }

    @GetMapping("/allVideoGames")
    public String allVideoGames(Model model)
    {
        List<ProductModel> products = productService.findAll();
        ArrayList<VideoGameModel> videoGames = new ArrayList<>();

        for (ProductModel product : products)
        {
            videoGames.add(productMapper.productToVideoGame(product));
        }

        model.addAttribute("videoGames", videoGames);
        return "VideoGames";
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
        productService.create(productModel);
        return allProducts(model);
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
        return allProducts(model);
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
