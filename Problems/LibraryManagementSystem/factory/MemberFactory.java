package Problems.LibraryManagementSystem.factory;

import Problems.LibraryManagementSystem.entities.Member;

public class MemberFactory {
    
    public Member createMember(String memberId, String name, String email) {
        return new Member(memberId, name, email);
    }
    
}
