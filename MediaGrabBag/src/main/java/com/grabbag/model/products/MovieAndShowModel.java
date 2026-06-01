package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;

public class MovieAndShowModel extends ProductModel
{
    @NotNull(message="Duration in Hours is a required field")
    int durationInHours;

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}