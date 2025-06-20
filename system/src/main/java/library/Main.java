package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Add Borrower");
            System.out.println("4. Lend book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();

                    Book newBook = new Book(title, author, bookId);
                    library.addBook(newBook);

                    break;

                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter borrower name: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("Enter borrower ID: ");
                    String borrowerId = scanner.nextLine();

                    Borrower newBorrower = new Borrower(borrowerName, borrowerId);
                    library.addBorrower(newBorrower);
                    break;

                case 4:
                    System.out.print("Enter borrower ID: ");
                    borrowerId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextLine();

                    library.borrowBook(borrowerId, bookId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (input != 5);

        scanner.close();
    }
}