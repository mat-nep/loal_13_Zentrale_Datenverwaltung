package media;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Media {
    protected int id;
    protected String title;
    protected LocalDate release;
    protected int rating;
    protected String genre;
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Media(int id, String title, LocalDate release, String genre, int rating) {
        this.id = id;
        this.title = title;
        this.release = release;
        this.rating = rating;
        this.genre = genre;
    }

    //ID;Type;Title;ReleaseDate;Genre;Rating;Author;Pages;RuntimeMinutes;Studio
    @Override
    public String toString() {
        return String.format("%d;%s;%s;%s;%s;%s", id, "%s" /*Type*/, title, release.toString(), rating, genre);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getRelease() {
        return release;
    }

    public int getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }
}
