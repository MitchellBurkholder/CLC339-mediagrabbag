package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class ProductModel
{
    //Can be null; just assigned after product is created
    @Id
    int id;

    @NotNull(message="Type is required field")
    @Column("TYPE")
    ProductType type;

    @NotNull(message="Title is required field")
    @Column("TITLE")
    String title;

    @NotNull(message="Age Rating is required field")
    @Size(min=1, max=7, message="Not Rated can be abbrieviated to 'NR'")
    @Column("AGE_RATING")
    String ageRating;

    @NotNull(message="Genre is required field")
    @Size(min=1, max=32, message="Please put the main genre")
    @Column("GENRE")
    String genre;

    @NotNull(message="Date is required field")
    @Size(min=4, max=13, message="Minimum requirement is the year")
    @Column("DATE")
    String date;

    @NotNull(message="Publisher or Studio is required field")
    @Size(min=1, max=32, message="Name of publisher or studio must be less than 32 characters")
    @Column("PUBLISHER_OR_STUDIO")
    String publisherOrStudio;

    public ProductModel(int id, @Nullable String type, @Nullable String title, @Nullable String ageRating,
                        @Nullable String genre, @Nullable String date, @Nullable String publisherOrStudio) {}

    public ProductModel() {}

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPublisherOrStudio() {
        return publisherOrStudio;
    }

    public void setPublisherOrStudio(String publisherOrStudio) {
        this.publisherOrStudio = publisherOrStudio;
    }
}