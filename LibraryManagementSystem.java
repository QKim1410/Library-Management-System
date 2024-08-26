import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private ArrayList<String> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();

        // Pre-existing books
        books.add("Puta ka");
        books.add("Fuck You Bitch");
        books.add("Dumb ass");
        books.add("Bitch ass");
        books.add("Tanga");
        books.add("Bobo");
        books.add("Siraulo Ka!");
        books.add("Gago ka ba Boss");
    }

    public void add(String book) {
        books.add(book);
        System.out.println("Book \"" + book + "\" added to the end of the list.");
    }

    public void insert(int index, String book) {
        if (index < 0 || index > books.size()) {
            System.out.println("Index out of range. Cannot insert book.");
            return;
        }
        books.add(index, book);
        System.out.println("Book \"" + book + "\" inserted at position " + index + ".");
    }

    public void remove(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Index out of range. Cannot remove book.");
            return;
        }
        String removedBook = books.remove(index);
        System.out.println("Book \"" + removedBook + "\" removed from position " + index + ".");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + ": " + books.get(i));
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            library.displayBooks();

            System.out.print("\nEnter a new book to add: ");
            String newBook = scanner.nextLine();

            System.out.print("Would you like to insert the book at a specific index? (Y/N): ");
            String insertChoice = scanner.nextLine();

            if (insertChoice.equalsIgnoreCase("Y")) {
                System.out.print("Enter the index to insert the book: ");
                int index = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                library.insert(index, newBook);
            } else {
                library.add(newBook);
            }

            library.displayBooks();

            System.out.print("\nWould you like to remove a book? (Y/N): ");
            String removeChoice = scanner.nextLine();

            if (removeChoice.equalsIgnoreCase("Y")) {
                System.out.print("Enter the index of the book to remove: ");
                int removeIndex = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                library.remove(removeIndex);
            }

            library.displayBooks();
            System.out.println("");

            System.out.print("Would you like to add another book? (Y/N): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("\nExiting the library management system.");
        scanner.close();
    }
}
