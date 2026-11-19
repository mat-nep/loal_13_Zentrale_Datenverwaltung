package media;

import java.time.LocalDate;

public class Book extends Media{
    private String autor;
    private int pages;

    public Book(int id, String title, LocalDate release, String genre, int rating, String author, int pages) {
        super(id, title, release, genre, rating);
        this.autor = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        String media = String.format("%s;%s;%d", super.toString(), autor, pages);
        return String.format(media, getClass().getSimpleName());
    }
}