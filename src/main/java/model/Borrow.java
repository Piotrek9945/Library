package model;

public class Borrow {

    private int bookId;
    private String borrowerName;

    public Borrow(int bookId, String name) {
        this.bookId = bookId;
        this.borrowerName = name;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

}
