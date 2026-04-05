package Problems.LibraryManagementSystem.strategy;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.Member;

public class SimpleBorrowStrategy implements Borrow {

    @Override
    public void borrowBook(Member member, BookCopy bookCopy) {
        bookCopy.checkOut(member);
        member.getBorrowedBooks().add(bookCopy);
    }

    @Override
    public void returnBook(Member member, BookCopy bookCopy) {
        bookCopy.returnBook(member);
        member.getBorrowedBooks().remove(bookCopy);
    }

    @Override
    public void reserveBook(Member member, BookCopy bookCopy) {
        bookCopy.reserve(member);
    }

    @Override
    public void borrowHistory(Member member) {
        System.out.println("Borrow history for member " + member.getName() + ":");
        for(BookCopy bookCopy : member.getBorrowedBooks()) {
            System.out.println("- " + bookCopy.getBookRecord().getTitle());
        }
    }
    
}
