package library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;

    public Library() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    // to add books
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.toString());
    }

    // to view books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books added yet.");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    // to add borrowers
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println(borrower.toString());
    }

    // to view borrowers
    public void viewBorrowers() {
        if (borrowers.isEmpty()) {
            System.out.println("No one has borrowed books yet.");
        } else {
            for (Borrower borrower : borrowers) {
                System.out.println(borrower.toString());
            }
        }
    }

    // To borrow book
    public void borrowBook(String borrowerId, String bookId) {
        Borrower foundBorrower = null;
        Book foundBook = null;

        for (Borrower borrower : borrowers) {
            if (borrower.getId().equalsIgnoreCase(borrowerId)) {
                foundBorrower = borrower;
                break;
            }
        }

        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(bookId)) {
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
            System.out.println(foundBorrower.getName() + " is borrowing " + foundBook.getTitle());
        }
    }

    // To return book
    public void returnBook(String borrowerId, String bookId) {
        Borrower foundBorrower = null;
        Book foundBook = null;

        for (Borrower borrower : borrowers) {
            if (borrower.getId().equalsIgnoreCase(borrowerId)) {
                foundBorrower = borrower;
                break;
            }
        }

        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(bookId)) {
                foundBook = book;
                break;
            }
        }

        if (foundBorrower == null) {
            System.out.println("Borrower not found.");
        } else if (foundBook == null) {
            System.out.println("Book not found.");
        } else if (!foundBook.isBorrowed()) {
            System.out.println("Book is not currently borrowed.");
        } else {
            foundBorrower.returnBook(foundBook);
            System.out.println(foundBorrower.getName() + " is returning " + foundBook.getTitle());
        }
    }

    // To view books borrowed
    public void viewBorrowedBooks() {
        boolean foundBorrowed = false;
        for (Book book : books) {
            if (book.isBorrowed()) {
                System.out.println(book.toString());
                foundBorrowed = true;
            }
        }

        if (!foundBorrowed) {
            System.out.println("No books are currently borrowed.");
        }
    }

    // Search book by title
    public void searchBookByTitle(String title) {

        boolean foundBook = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book.toString());
                foundBook = true;
            }
        }

        if (!foundBook) {
            System.out.println("No book with that title was found.");
        }
    }

    // Search book by author
    public void searchBookByAuthor(String author) {
        boolean foundBook = false;

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBook = true;
            }
        }

        if (!foundBook) {
            System.out.println("No book  with that author was found.");
        }
    }

    // Search book by id
    public void searchBookById(String id) {
        boolean foundBook = false;

        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                foundBook = true;
            }
        }

        if (!foundBook) {
            System.out.println("No book with that id was found.");
        }
    }

}
