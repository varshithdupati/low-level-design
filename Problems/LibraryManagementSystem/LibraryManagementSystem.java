package Problems.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

import Problems.LibraryManagementSystem.entities.BookCopy;
import Problems.LibraryManagementSystem.entities.BookRecord;
import Problems.LibraryManagementSystem.entities.Member;
import Problems.LibraryManagementSystem.factory.BookRecordFactory;
import Problems.LibraryManagementSystem.factory.MemberFactory;
import Problems.LibraryManagementSystem.strategy.Borrow;
import Problems.LibraryManagementSystem.strategy.SimpleBorrowStrategy;

public class LibraryManagementSystem {
    
    private static volatile LibraryManagementSystem INSTANCE;
    private BookRecordFactory bookRecordFactory;
    private MemberFactory memberFactory;
    private Borrow borrowStrategy;
    private List<BookRecord> bookRecords;
    private List<Member> members;

    private LibraryManagementSystem() {
        this.bookRecordFactory = new BookRecordFactory();
        this.memberFactory = new MemberFactory();
        this.borrowStrategy = new SimpleBorrowStrategy();
        this.bookRecords = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public static LibraryManagementSystem getInstance() {
        if (INSTANCE == null) {
            synchronized (LibraryManagementSystem.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LibraryManagementSystem();
                }
            }
        }
        return INSTANCE;
    }

    public void addBookRecord(String title, String author, String isbn, String publicationYear, int totalCopies) {
        BookRecord bookRecord = bookRecordFactory.createBookRecord(title, author, isbn, publicationYear, totalCopies);
        bookRecords.add(bookRecord);
    }

    public void addMember(String memberId, String name, String email) {
        Member member = memberFactory.createMember(memberId, name, email);
        members.add(member);
    }

    public void borrowBook(Member member, BookCopy bookCopy) {
        borrowStrategy.borrowBook(member, bookCopy);
    }

    public void returnBook(Member member, BookCopy bookCopy) {
        borrowStrategy.returnBook(member, bookCopy);
    }

    public void reserveBook(Member member, BookCopy bookCopy) {
        borrowStrategy.reserveBook(member, bookCopy);
    }

    public BookCopy findAvailableCopy(BookRecord bookRecord) {
        for (BookCopy copy : bookRecord.getCopies()) {
            if (copy.isAvailable()) {
                return copy;
            }
        }
        return null; // No available copy found
    }

    public BookCopy findReservableCopy(BookRecord bookRecord) {
        for (BookCopy copy : bookRecord.getCopies()) {
            if (copy.isReservable()) {
                return copy;
            }
        }
        return null; // No reservable copy found
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null; // No member found with the given ID
    }

    public BookRecord findBookRecordByIsbn(String isbn) {
        for (BookRecord bookRecord : bookRecords) {
            if (bookRecord.getIsbn().equals(isbn)) {
                return bookRecord;
            }
        }
        return null; // No book record found with the given ISBN
    }

    public void getBorrowHistory(Member member) {
        System.out.println("Borrow history for " + member.getName() + ":");
        for (BookCopy copy : member.getBorrowedBooks()) {
            System.out.println("- " + copy.getBookRecord().getTitle() + " (Copy ID: " + copy.getCopyId() + ")");
        }
    }

}
