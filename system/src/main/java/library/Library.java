package library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;

    public Library() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    // to add books and view books
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.toString());
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books added yet.");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    // to add borrowers, view borrowers, and view books borrowed
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println(borrower.toString());
    }

    public void viewBorrowers() {
        if (borrowers.isEmpty()) {
            System.out.println("No one has borrowed books yet.");
        } else {
            for (Borrower borrower : borrowers) {
                System.out.println(borrower.toString());
            }
        }
    }

    public void borrowBook(String borrowerId, String bookId) {
        Borrower foundBorrower = null;
        Book foundBook = null;

        for (Borrower borrower : borrowers) {
            if (borrower.getId().equals(borrowerId)) {
                foundBorrower = borrower;
                break;
            }
        }

        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                foundBook = book;
                break;
            }
        }

        if (foundBorrower == null) {
            System.out.println("Borrower not found.");
        } else if (foundBook == null) {
            System.out.println("Book not found.");
        } else if (foundBook.isBorrowed()) {
            System.out.println("Book is unavailable at this time.");
        } else {
            foundBorrower.borrowBook(foundBook);
            System.out.println(borrowerId + " is borrowing " + bookId);
        }
    }
}
