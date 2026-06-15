package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.relational.core.mapping.Column;

public class MovieAndShowModel extends ProductModel
{
    @Column("DURATION")
    int durationInHours;

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }
}