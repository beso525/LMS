package library;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    Book(String title, String author, String id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void borrow() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: "
                + (isBorrowed ? "Borrowed" : "Available");
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
