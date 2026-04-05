package Problems.LibraryManagementSystem;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.Member;

public class LibraryManagementDemo {
    
    public static void main(String[] args) {

        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        
        // Create book records
        library.addBookRecord("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", "1925", 3);
        library.addBookRecord("To Kill a Mockingbird", "Harper Lee", "978-0061120084", "1960", 2);
        
        // Create members
        library.addMember("m-001", "Alice", "alice@example.com");
        library.addMember("m-002", "Bob", "bob@example.com");

        // Simulate borrowing and returning books
        Member alice = library.findMemberById("m-001");
        Member bob = library.findMemberById("m-002");
        BookCopy gatsbyCopy1 = library.findAvailableCopy(library.findBookRecordByIsbn("978-0743273565"));
        BookCopy mockingbirdCopy1 = library.findAvailableCopy(library.findBookRecordByIsbn("978-0061120084"));

        library.borrowBook(alice, gatsbyCopy1);
        library.borrowBook(bob, mockingbirdCopy1);
        library.getBorrowHistory(alice);
        library.returnBook(alice, gatsbyCopy1);
        library.getBorrowHistory(alice);

    }

}
