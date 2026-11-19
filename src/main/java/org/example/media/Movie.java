package org.example.media;

import java.time.LocalDate;

public class Movie extends Media{
    private int runtime; //runtime in minutes

    public Movie(int id, String title, LocalDate release, String genre, int rating, int runtime) {
        super(id, title, release, genre, rating);
        this.runtime = runtime;
    }

    @Override

    public String toString() {
        String media = String.format("%s;%d", super.toString(), runtime);
        return String.format(media, getClass().getSimpleName());
    }
}