package Problems.LibraryManagementSystem.factory;

import Problems.LibraryManagementSystem.entities.BookRecord;

public class BookRecordFactory {
    
    public BookRecord createBookRecord(String title, String author, String isbn, String publicationYear, int totalCopies) {
        return new BookRecord(title, author, isbn, publicationYear, totalCopies);
    }

}
