package com.grabbag.data;

import com.grabbag.model.products.*;

import java.awt.print.Book;

public class ProductMapper
{
    public BookModel productToBook(ProductModel productModel)
    {
        return new BookModel(
                productModel.id,
                productModel.type.toString(),
                productModel.title,
                productModel.author,
                productModel.ageRating,
                productModel.genre,
                productModel.date,
                productModel.publisherOrStudio
        );
    }

    public MovieAndShowModel productToMovieOrShow(ProductModel productModel)
    {
        return new MovieAndShowModel(
                productModel.id,
                productModel.type.toString(),
                productModel.title,
                productModel.durationInHours,
                productModel.ageRating,
                productModel.genre,
                productModel.date,
                productModel.publisherOrStudio
        );
    }

    public VideoGameModel productToVideoGame(ProductModel productModel)
    {
        return new VideoGameModel(
                productModel.id,
                productModel.type.toString(),
                productModel.title,
                productModel.numPlayers,
                productModel.requiredEquipment,
                productModel.ageRating,
                productModel.genre,
                productModel.date,
                productModel.publisherOrStudio
        );
    }
}
