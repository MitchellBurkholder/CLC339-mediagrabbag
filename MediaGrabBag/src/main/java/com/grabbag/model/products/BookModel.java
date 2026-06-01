package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookModel extends ProductModel
{
    @NotNull(message="Author is required field")
    @Size(min=1, max=64, message="Author's full name must be between 1 and 64 characters")
    String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}