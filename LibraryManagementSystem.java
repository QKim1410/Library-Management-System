import java.util.Scanner;

public class LibraryManagementSystem {
    private String[] books;
    private int bookCount;

    public LibraryManagementSystem(int capacity) {
        books = new String[capacity];
        bookCount = 0;

        // Pre-existing books
        books[bookCount++] = "Puta ka";
        books[bookCount++] = "Fuck You Bitch";
        books[bookCount++] = "Dumb ass";
        books[bookCount++] = "Bitch ass";
        books[bookCount++] = "Tanga";
        books[bookCount++] = "Bobo";
        books[bookCount++] = "Siraulo Ka!";
        books[bookCount++] = "Gago ka ba Boss";
    }

    public void add(String book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Book \"" + book + "\" added to the end of the list.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void insert(int index, String book) {
        if (index < 0 || index > bookCount) {
            System.out.println("Index out of range. Cannot insert book.");
            return;
        }
        if (bookCount < books.length) {
            // Shift elements to the right to make space for the new book
            for (int i = bookCount; i > index; i--) {
                books[i] = books[i - 1];
            }
            books[index] = book;
            bookCount++;
            System.out.println("Book \"" + book + "\" inserted at position " + index + ".");
        } else {
            System.out.println("Library is full. Cannot insert book.");
        }
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < bookCount; i++) {
                System.out.println(i + ": " + books[i]);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10); // Capacity of 10 books
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            library.displayBooks();

            System.out.print("\nEnter a new book to add: ");
            String newBook = scanner.nextLine();

            System.out.print("Enter the index to insert a book: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            library.insert(index, newBook);

            library.displayBooks();
            System.out.println("");

            System.out.print("Enter another book? (Y/N): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("\nExiting the library management system.");
        scanner.close();
    }
}
