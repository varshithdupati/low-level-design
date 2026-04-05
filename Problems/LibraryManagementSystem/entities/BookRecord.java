package Problems.LibraryManagementSystem.entities;

import java.util.ArrayList;
import java.util.List;

public class BookRecord {
    
    private String title;
    private String author;
    private String isbn;
    private String publicationYear;
    private List<BookCopy> copies;
    private List<Member> waitlist; // List of reservations for this book

    public BookRecord(String title, String author, String isbn, String publicationYear, int totalCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.copies = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        initializeCopies(totalCopies);
    }

    private void initializeCopies(int totalCopies) {
        for (int i = 0; i < totalCopies; i++) {
            copies.add(new BookCopy(isbn + "-" + (i + 1), this));
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public int getTotalCopies() {
        return copies.size();
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public List<Member> getWaitlist() {
        return waitlist;
    }

    public void joinWaitlist(Member member) {
        waitlist.add(member);
    }

    public void leaveWaitlist(Member member) {
        waitlist.remove(member);
    }

    public boolean hasWaitlist() {
        return !waitlist.isEmpty();
    }

    public boolean isMemberInWaitlist(Member member) {
        return waitlist.contains(member);
    }

    public void notifyMembers() {
        waitlist.forEach(member -> member.update(this));
    }

}
