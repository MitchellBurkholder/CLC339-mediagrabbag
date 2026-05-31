package com.grabbag.model.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VideoGameModel extends ProductModel
{
    @NotNull(message="Number of Players is required field")
    @Size(min=1, max=10, message="Minimum players is one, max is unlimited")
    String numPlayers;

    @NotNull(message="Please input any required equipment (or N/A if nonapplicable")
    ArrayList<String> RequiredEquipment;
}