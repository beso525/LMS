package library;

import java.util.ArrayList;

public class Borrower {
    private String name;
    private String id;
    private ArrayList<Book> borrowedBooks;

    Borrower(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrow();
        System.out.println(name + " borrowed: " + book.toString());
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println(name + " returned: " + book.toString());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }

    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
        } else {
            System.out.println(name + " has borrowed: ");
            for (Book books : borrowedBooks) {
                System.out.println(books.toString());
            }
        }
    }

    public String toString() {
        return "Borrower ID: " + id + " | Name: " + name + " | Borrowed Book: " + borrowedBooks;
    }
}
