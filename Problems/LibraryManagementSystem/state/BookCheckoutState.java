package Problems.LibraryManagementSystem.state;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.Member;

public class BookCheckoutState implements BookState {

    BookCopy bookCopy;

    public BookCheckoutState(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
    
    @Override
    public void returnBook(Member member) {
        System.out.println("Returning the book...");
        if(bookCopy.getBookRecord().hasWaitlist()) {
            System.out.println("Book has waitlist, reserving for next member...");
            bookCopy.setState(bookCopy.getReservedState());
            bookCopy.getBookRecord().notifyMembers();
        } else {
            System.out.println("No waitlist, making book available...");
            bookCopy.setState(bookCopy.getAvailableState());
        }
    }

    @Override
    public void checkOut(Member member) {
        System.out.println("Invalid: Book is already checked out.");
    }

    @Override
    public void reserve(Member member) {
        System.out.println("Book not available, joining waitlist...");
        bookCopy.getBookRecord().joinWaitlist(member);
    }

}
