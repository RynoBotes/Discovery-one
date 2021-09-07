package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER_INFO")
public class MemberInfo implements Serializable
{
    private Long memberId;
    //private MemberAccount accountId;
    private String name;
    private String surname;
    private LocalDate JoinedDate;
    Set<MemberAccount> memberAccountSet2;

    @OneToMany(targetEntity = MemberAccount.class,fetch = FetchType.LAZY, mappedBy = "memberInfoId",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<MemberAccount> getMemberAccountSet2() {
        return memberAccountSet2;
    }

    public void setMemberAccountSet2(Set<MemberAccount> memberAccountSet2) {
        this.memberAccountSet2 = memberAccountSet2;
    }



    private static final long serialVersionUID = -6632562936635239413L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @SequenceGenerator(name = "MEMBER_SEQ", sequenceName = "MEMBER_ID_SEQ", allocationSize = 1)
    @Column(name = "member_id", nullable = false)
    public Long getMemberId() {
        return memberId;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ACCOUNT_ID")
//    public MemberAccount getAccountId() {
//        return accountId;
//    }

    @Column(name = "MEM_NAME")
    public String getName() {
        return name;
    }

    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @Column(name = "JOINED_DATE")
    public LocalDate getJoinedDate() {
        return JoinedDate;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

//    public void setAccountId(MemberAccount accountId) {
//        this.accountId = accountId;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        JoinedDate = joinedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfo that = (MemberInfo) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(JoinedDate, that.JoinedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name, surname, JoinedDate);
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", JoinedDate=" + JoinedDate +
                '}';
    }
}
