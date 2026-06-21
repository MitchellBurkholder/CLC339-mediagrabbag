package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import org.jspecify.annotations.Nullable;
import org.springframework.data.relational.core.mapping.Column;

public class MovieAndShowModel extends SmallModel
{
    @Column("DURATION")
    int durationInHours;

    public MovieAndShowModel(int id, String type, String title, int durationInHours, String ageRating, String genre, String date, String publisherOrStudio)
    {
        super(id, type, title, ageRating, genre, date, publisherOrStudio);
        this.durationInHours = durationInHours;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}