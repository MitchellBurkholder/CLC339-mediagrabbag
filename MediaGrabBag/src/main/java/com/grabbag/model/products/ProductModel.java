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

    @Size(min=1, max=64, message="Author's full name must be between 1 and 64 characters")
    @Column("AUTHOR")
    String author;

    @Column("DURATION")
    int durationInHours;

    @Column("NUM_PLAYERS")
    String numPlayers;

    @Column("REQUIRED_EQUIPMENT")
    String requiredEquipment;

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
    public ProductModel() {}

    public ProductModel(int id, String type, String title, @Nullable String author, int duration, @Nullable String numPlayers, @Nullable String requiredEquipment, String ageRating, String genre, String date, String publisherOrStudio) {
        this.id = id;
        this.type = ProductType.valueOf(type);
        this.title = title;
        this.author = author;
        this.durationInHours = duration;
        this.numPlayers = numPlayers;
        this.requiredEquipment = requiredEquipment;
        this.ageRating = ageRating;
        this.genre = genre;
        this.date = date;
        this.publisherOrStudio = publisherOrStudio;
    }

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

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public int getDurationInHours() {return durationInHours;}
    public void setDurationInHours(int durationInHours) {this.durationInHours = durationInHours;}

    public String getNumPlayers() {return numPlayers;}
    public void setNumPlayers(String numPlayers) {this.numPlayers = numPlayers;}

    public String getRequiredEquipment() {return requiredEquipment;}
    public void setRequiredEquipment(String requiredEquipment) {this.requiredEquipment = requiredEquipment;}


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