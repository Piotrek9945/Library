package model;

public class Book {

    private int id;
    private String title;
    private Integer year;
    private String author;

    public Book(int id, String title, Integer year, String author) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }
}
