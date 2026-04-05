package Problems.LibraryManagementSystem.state;

import Problems.LibraryManagementSystem.entities.Member;

public interface BookState {
    
    void returnBook(Member member);
    void checkOut(Member member);
    void reserve(Member member);

}
