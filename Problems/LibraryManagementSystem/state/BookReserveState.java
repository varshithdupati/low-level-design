package Problems.LibraryManagementSystem.state;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.Member;

public class BookReserveState implements BookState {

    BookCopy bookCopy;

    public BookReserveState(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
    
    @Override
    public void returnBook(Member member) {
        System.out.println("Invalid: Book is reserved, cannot return.");
    }

    @Override
    public void checkOut(Member member) {
        System.out.println("Checking out the reserved book...");
        if(!bookCopy.getBookRecord().isMemberInWaitlist(member)) {
            System.out.println("Invalid: Member is not in waitlist, cannot check out.");
            return;
        }
        bookCopy.setState(bookCopy.getCheckOutState());
    }

    @Override
    public void reserve(Member member) {
        System.out.println("Invalid: Book is already reserved.");
    }

}
