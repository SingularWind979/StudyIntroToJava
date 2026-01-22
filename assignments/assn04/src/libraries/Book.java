package libraries;

public class Book {
    private String title;
    private boolean isBorrowed;

    /**
     * Creates a new book with title
     *
     * @param title the title of the book
     */
    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }

    /**
     * Marks the book as borrowed
     */
    public void borrowed() {
        isBorrowed = true;
    }

    /**
     * Marks the book as not borrowed
     */
    public void returned() {
        isBorrowed = false;
    }

    /**
     * Judges if the book is borrowed
     *
     * @return true if the book is borrowed, false otherwise
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }

    /**
     * Returns the title of the book
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    // Small test of the Book class
    public static void main(String[] arguments) {
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}
