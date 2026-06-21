package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public abstract class SmallModel
{
    //Can be null; just assigned after product is created
    @Id
    public int id;

    @NotNull(message="Type is required field")
    @Column("TYPE")
    public ProductType type;

    @NotNull(message="Title is required field")
    @Column("TITLE")
    public String title;

    @NotNull(message="Age Rating is required field")
    @Size(min=1, max=7, message="Not Rated can be abbrieviated to 'NR'")
    @Column("AGE_RATING")
    public String ageRating;

    @NotNull(message="Genre is required field")
    @Size(min=1, max=32, message="Please put the main genre")
    @Column("GENRE")
    public String genre;

    @NotNull(message="Date is required field")
    @Size(min=4, max=13, message="Minimum requirement is the year")
    @Column("DATE")
    public String date;

    @NotNull(message="Publisher or Studio is required field")
    @Size(min=1, max=32, message="Name of publisher or studio must be less than 32 characters")
    @Column("PUBLISHER_OR_STUDIO")
    public String publisherOrStudio;
    public SmallModel() {}

    public SmallModel(int id, String type, String title, String ageRating, String genre, String date, String publisherOrStudio) {
        this.id = id;
        this.type = ProductType.valueOf(type);
        this.title = title;
        this.ageRating = ageRating;
        this.genre = genre;
        this.date = date;
        this.publisherOrStudio = publisherOrStudio;
    }

    public ProductType getType() {
        return type;
    }

    public String getTypeString(){return type.toString();}

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