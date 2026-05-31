package com.grabbag.model.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MovieAndShowModel extends ProductModel
{
    @NotNull(message="Duration in Hours is a required field")
    int durationInHours;

    public int getDurationInHours() {
        return DurationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}