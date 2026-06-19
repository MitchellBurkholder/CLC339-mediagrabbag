package com.grabbag.model.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.relational.core.mapping.Column;

public class VideoGameModel extends ProductModel
{
    @Size(min=1, max=10, message="Minimum players is one, max is unlimited")
    @Column("NUM_PLAYERS")
    String numPlayers;

    @Column("REQUIRED_EQUIPMENT")
    String requiredEquipment;

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