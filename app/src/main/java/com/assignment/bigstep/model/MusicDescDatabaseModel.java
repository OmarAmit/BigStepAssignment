package com.assignment.bigstep.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "MusicDescDatabaseModel")
public class MusicDescDatabaseModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")

    private int id;
    @ColumnInfo(name = "imageUrl")

    private String imageUrl;
    @ColumnInfo(name = "track")

    private String trackName;
    @ColumnInfo(name = "artist")

    private String artistName;

    @ColumnInfo(name = "price")

    private Double price;
    @ColumnInfo(name = "genere")

    private String genere;


    public MusicDescDatabaseModel(int id, String imageUrl, String trackName, String artistName, Double price, String genere) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.trackName = trackName;
        this.artistName = artistName;
        this.price = price;
        this.genere = genere;
    }

    @NonNull
    public Double getPrice() {
        return price;
    }

    public void setPrice(@NonNull Double price) {
        this.price = price;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(@NonNull String trackName) {
        this.trackName = trackName;
    }

    @NonNull
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(@NonNull String artistName) {
        this.artistName = artistName;
    }


    @NonNull
    public String getGenere() {
        return genere;
    }

    public void setGenere(@NonNull String genere) {
        this.genere = genere;
    }
}
