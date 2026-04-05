package Problems.LibraryManagementSystem.entities;

import Problems.LibraryManagementSystem.state.BookAvailableState;
import Problems.LibraryManagementSystem.state.BookCheckoutState;
import Problems.LibraryManagementSystem.state.BookReserveState;
import Problems.LibraryManagementSystem.state.BookState;

public class BookCopy {
    
    private String copyId;
    private BookState state;
    private BookRecord bookRecord;

    private BookState availableState;
    private BookState checkOutState;
    private BookState reservedState;

    public BookCopy(String copyId, BookRecord bookRecord) {
        this.copyId = copyId;
        this.bookRecord = bookRecord;
        this.availableState = new BookAvailableState(this);
        this.checkOutState = new BookCheckoutState(this);
        this.reservedState = new BookReserveState(this);
        this.state = availableState; // Initial state
    }

    public String getCopyId() {
        return copyId;
    }

    public BookRecord getBookRecord() {
        return bookRecord;
    }

    public void returnBook(Member member) {
        state.returnBook(member);
    }

    public void checkOut(Member member) {
        state.checkOut(member);
    }

    public void reserve(Member member) {
        state.reserve(member);
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public BookState getState() {
        return state;
    }

    public BookState getAvailableState() {
        return availableState;
    }

    public BookState getCheckOutState() {
        return checkOutState;
    }

    public BookState getReservedState() {
        return reservedState;
    }

    public boolean isAvailable() {
        return state == availableState;
    }

    public boolean isReservable() {
        return state == checkOutState;
    }

}
