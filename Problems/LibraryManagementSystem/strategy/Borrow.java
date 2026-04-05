package Problems.LibraryManagementSystem.strategy;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.Member;

public interface Borrow {

    void borrowBook(Member member, BookCopy bookCopy);
    void returnBook(Member member, BookCopy bookCopy);
    void reserveBook(Member member, BookCopy bookCopy);
    void borrowHistory(Member member);

}
