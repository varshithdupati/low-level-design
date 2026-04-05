package Problems.LibraryManagementSystem.state;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.Member;

public class BookAvailableState implements BookState {

    BookCopy bookCopy;

    public BookAvailableState(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    @Override
    public void returnBook(Member member) {
        System.out.println("Invalid: Book is already available.");
    }

    @Override
    public void checkOut(Member member) {
        System.out.println("Checking out the book...");
        bookCopy.setState(bookCopy.getCheckOutState());
    }

    @Override
    public void reserve(Member member) {
        System.out.println("Invalid: Book is available, cannot reserve.");
    }

}
