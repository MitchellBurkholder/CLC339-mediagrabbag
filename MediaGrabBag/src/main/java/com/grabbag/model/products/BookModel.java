package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.relational.core.mapping.Column;

public class BookModel extends ProductModel
{
    @Size(min=1, max=64, message="Author's full name must be between 1 and 64 characters")
    @Column("AUTHOR")
    String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}