package libraries;

public class Library {
    private static final int OPEN_TIME = 9;
    private static final int CLOSE_TIME = 17;
    private static final int CAPACITY = 100;
    private final String address;
    private Book[] books;
    private int bookCnt;

    /**
     * Creates a new library
     *
     * @param address the address of the new library
     */
    public Library(String address) {
        this.address = address;
        books = new Book[CAPACITY];
        bookCnt = 0;
    }

    /**
     * Prints the opening hours of the library
     */
    public static void printOpeningHours() {
        System.out.printf("Libraries are open daily from %d:00 to %d:00.%n", OPEN_TIME, CLOSE_TIME);
    }

    /**
     * Prints the address of the library
     */
    public void printAddress() {
        System.out.println("address: " + address);
    }

    /**
     * Prints the available books in the library
     */
    public void printAvailableBooks() {
        if (bookCnt == 0) {
            System.out.println("Sorry, no book in catalog.");
            return;
        }
        System.out.println("Available Books:");
        for (int i = 0; i < bookCnt; i++) {
            System.out.println(books[i].getTitle());
        }
    }

    /**
     * Adds a book to the library
     *
     * @param book the book to be added
     */
    public void addBook(Book book) {
        books[bookCnt++] = book;
    }

    /**
     * Finds s book by title
     *
     * @param title the title of the wanted book
     * @return index of the book, -1 when not found
     */
    public int findBookByTitle(String title) {
        for (int i = 0; i < bookCnt; i++) {
            if (books[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Borrows a book by title
     *
     * @param title the title of the book to be borrowed
     */
    public void borrowBook(String title) {
        int idx = findBookByTitle(title);
        if (idx == -1) {
            System.out.printf("Sorry, book %s not found.%n", title);
            return;
        }
        for (int i = idx; i < bookCnt; i++) {
            books[i] = books[i + 1];
        }
        books[bookCnt] = null;
        bookCnt--;
        System.out.printf("You successfully borrowed book %s.%n", title);
    }

    /**
     * Returns a book by title
     *
     * @param title the title of the book to be returned
     */
    public void returnBook(String title) {
        addBook(new Book(title));
        System.out.printf("You successfully returned book %s.%n", title);
    }

    // Small test of the library class
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petite Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        System.out.print("Library 1 ");
        firstLibrary.printAddress();
        System.out.print("Library 2 ");
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
