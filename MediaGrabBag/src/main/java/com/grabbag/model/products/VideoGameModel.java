package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.relational.core.mapping.Column;

public class VideoGameModel extends SmallModel
{
    @Size(min=1, max=20, message="Minimum players is one, max is unlimited")
    String numPlayers;

    String requiredEquipment;

    public VideoGameModel(int id, String type, String title, String numPlayers, String requiredEquipment, String ageRating, String genre, String date, String publisherOrStudio)
    {
        super(id, type, title, ageRating, genre, date, publisherOrStudio);
        this.numPlayers = numPlayers;
        this.requiredEquipment = requiredEquipment;
    }

    public String getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(String numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getRequiredEquipment() {
        return requiredEquipment;
    }

    public void setRequiredEquipment(String requiredEquipment) {
        this.requiredEquipment = requiredEquipment;
    }
}