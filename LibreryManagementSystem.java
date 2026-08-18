// Interface
interface Issuable {

    void issueItem();

    void returnItem();
}


// Abstract class
abstract class LibraryItem {

    // Protected fields
    protected String title;
    protected int itemId;
    protected boolean isIssued;

    // Constructor
    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isIssued = false;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter
    public int getItemId() {
        return itemId;
    }

    // Setter
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    // Getter
    public boolean isIssued() {
        return isIssued;
    }

    // Setter
    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    // Abstract method
    public abstract int calculateFine(int daysLate);

    // Concrete method
    public void displayInfo() {
        System.out.println(
                "Title : " + title +
                " | ID : " + itemId +
                " | Issued : " + isIssued
        );
    }
}


// Book class
class Book extends LibraryItem implements Issuable {

    public Book(String title, int itemId) {
        super(title, itemId);
    }

    // Book fine = Rs.5 per day
    @Override
    public int calculateFine(int daysLate) {
        return daysLate * 5;
    }

    @Override
    public void issueItem() {

        if (!isIssued) {
            isIssued = true;
            System.out.println(title + " issued.");
        } else {
            System.out.println(title + " is already issued.");
        }
    }

    @Override
    public void returnItem() {

        if (isIssued) {
            isIssued = false;
            System.out.println(title + " returned.");
        } else {
            System.out.println(title + " was not issued.");
        }
    }

    // Method overriding
    @Override
    public String toString() {
        return "Item : " + title + " (Book)";
    }
}


// Magazine class
class Magazine extends LibraryItem implements Issuable {

    public Magazine(String title, int itemId) {
        super(title, itemId);
    }

    // Magazine fine = Rs.2 per day
    @Override
    public int calculateFine(int daysLate) {
        return daysLate * 2;
    }

    @Override
    public void issueItem() {

        if (!isIssued) {
            isIssued = true;
            System.out.println(title + " issued.");
        } else {
            System.out.println(title + " is already issued.");
        }
    }

    @Override
    public void returnItem() {

        if (isIssued) {
            isIssued = false;
            System.out.println(title + " returned.");
        } else {
            System.out.println(title + " was not issued.");
        }
    }

    // Method overriding
    @Override
    public String toString() {
        return "Item : " + title + " (Magazine)";
    }
}


// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Create 2 Books
        Book book1 = new Book("Java Programming", 101);
        Book book2 = new Book("Clean Code", 102);

        // Create 2 Magazines
        Magazine magazine1 =
                new Magazine("National Geographic", 201);

        Magazine magazine2 =
                new Magazine("Time Magazine", 202);


        // Issue all items
        book1.issueItem();
        book2.issueItem();
        magazine1.issueItem();
        magazine2.issueItem();

        System.out.println();


        // Polymorphic array
        LibraryItem[] items = {
                book1,
                magazine1,
                book2,
                magazine2
        };

        // Late days
        int[] lateDays = {
                4,
                4,
                2,
                2
        };


        // Runtime polymorphism
        for (int i = 0; i < items.length; i++) {

            LibraryItem item = items[i];

            int fine = item.calculateFine(lateDays[i]);

            System.out.println(
                    item +
                    " | Fine for " +
                    lateDays[i] +
                    " days late : Rs." +
                    fine
            );
        }


        System.out.println();

        // Return items
        book1.returnItem();
        book2.returnItem();
        magazine1.returnItem();
        magazine2.returnItem();

        System.out.println();

        // Display information
        book1.displayInfo();
        magazine1.displayInfo();
    }
}