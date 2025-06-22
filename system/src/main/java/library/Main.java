package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int mainInput, adminInput, searchInput;
        String title, author, bookId, borrowerId, borrowerName;

        do {
            // LMS main menu
            System.out.println("====== Library Management System ======");
            System.out.println("============== Main Menu ==============");
            System.out.println("1. Admin options");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. View Borrowed books");
            System.out.println("5. Search books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            mainInput = scanner.nextInt();
            scanner.nextLine();

            switch (mainInput) {
                case 1:
                    do {
                        // Admin options
                        System.out.println("============ Admin Options ============");
                        System.out.println("1. Add Book");
                        System.out.println("2. Add Borrower");
                        System.out.println("3. View Borrowers");
                        System.out.println("0. Back to main menu");
                        System.out.print("Choose an option: ");

                        adminInput = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminInput) {
                            case 1:
                                // Add book
                                System.out.print("Enter book title: ");
                                title = scanner.nextLine();
                                System.out.print("Enter book author: ");
                                author = scanner.nextLine();
                                System.out.print("Enter book ID: ");
                                bookId = scanner.nextLine();

                                Book newBook = new Book(title, author, bookId);
                                library.addBook(newBook);

                                break;

                            case 2:
                                // Add borrower
                                System.out.print("Enter borrower name: ");
                                borrowerName = scanner.nextLine();
                                System.out.print("Enter borrower ID: ");
                                borrowerId = scanner.nextLine();

                                Borrower newBorrower = new Borrower(borrowerName, borrowerId);
                                library.addBorrower(newBorrower);
                                break;
                            case 3:
                                // View all borrowers
                                library.viewBorrowers();
                                break;
                            case 0:
                                // Return to main menu
                                System.out.println("Returning to main menu");
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }
                    } while (adminInput != 0);
                    break;

                case 2:
                    // Borrow/Lend Book
                    System.out.print("Enter borrower ID: ");
                    borrowerId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextLine();

                    library.borrowBook(borrowerId, bookId);
                    break;
                case 3:
                    // Return book
                    System.out.print("Enter borrower ID: ");
                    borrowerId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextLine();

                    library.returnBook(borrowerId, bookId);
                    break;
                case 4:
                    // View all borrowed books
                    library.viewBorrowedBooks();
                    break;

                case 5:
                    // Search Options
                    do {
                        System.out.println("=========== Search Options ============");
                        System.out.println("1. View All Books");
                        System.out.println("2. Search for book by title");
                        System.out.println("3. Search for book by author");
                        System.out.println("4. Search for book by book id");
                        System.out.println("0. Back to main menu");
                        System.out.print("Choose an option: ");

                        searchInput = scanner.nextInt();
                        scanner.nextLine();

                        switch (searchInput) {
                            case 1:
                                // View All books
                                library.viewBooks();
                                break;
                            case 2:
                                // Search for book by title
                                System.out.print("Enter book title: ");
                                title = scanner.nextLine();
                                library.searchBookByTitle(title);
                                break;
                            case 3:
                                // Search for book by author
                                System.out.print("Enter book author: ");
                                author = scanner.nextLine();
                                library.searchBookByAuthor(author);
                                break;
                            case 4:
                                // Search for book by id
                                System.out.print("Enter book id: ");
                                bookId = scanner.nextLine();
                                library.searchBookById(bookId);
                                break;

                            case 0:
                                // Return to main menu
                                System.out.println("Returning to main menu");
                                break;
                            default:
                                System.out.println("Invalid choice, please try again.");
                        }
                    } while (searchInput != 0);
                    break;
                case 0:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (mainInput != 0);

        scanner.close();
    }
}