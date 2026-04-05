package Problems.LibraryManagementSystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Member {
    
    private String memberId;
    private String name;
    private String email;
    private List<BookCopy> borrowedBooks;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void update(BookRecord bookRecord) {
        System.out.println("The book " + bookRecord.getTitle() + " is now available. Notifying member " + name);
    }

    public List<BookCopy> getBorrowedBooks() {
        return borrowedBooks;
    }

}
