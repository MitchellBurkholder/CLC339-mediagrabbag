package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.Nullable;
import org.springframework.data.relational.core.mapping.Column;

public class BookModel extends SmallModel
{
    @Size(min=1, max=64, message="Author's full name must be between 1 and 64 characters")
    @Column("AUTHOR")
    String author;

    public BookModel(int id, String type, String title, String author, String ageRating, String genre, String date, String publisherOrStudio)
    {
        super(id, type, title, ageRating, genre, date, publisherOrStudio);
        this.author = author;
    }

    public BookModel(){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}