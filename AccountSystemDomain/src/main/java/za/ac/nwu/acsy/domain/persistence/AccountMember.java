package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER_INFO")
public class AccountMember implements Serializable
{
    @Id
    @SequenceGenerator(name="MEMBER_ID_SEQ", sequenceName = "MEMBER_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ID_SEQ")
    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(name = "MEM_NAME")
    private String memberName;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "JOINED_DATE")
    private LocalDate joinedDate;

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }
}