package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_INFO")
public class MemberInfo implements Serializable
{
    private Long memberInfoId;
    private Long memberID;
    private String name;
    private String surname;
    private LocalDate joinedDate;
    private AccountType accountType;
    private Long currAmount;

    private static final long serialVersionUID = -6632562936635239413L;


    public MemberInfo() {
    }

    public MemberInfo(Long memberID,String name, String surname, LocalDate joinDate, Long currAmount) //JSON CONSTR
    {
        this.memberID = memberID;
        this.name = name;
        this.surname = surname;
        this.joinedDate = joinDate;
        this.currAmount = currAmount;
    }

    public MemberInfo(Long memberInfoId, AccountType accountType,Long memberID, String name, String surname, LocalDate joinDate, Long currAmount) {
        this.memberInfoId = memberInfoId;
        this.accountType = accountType;
        this.memberID = memberID;
        this.name = name;
        this.surname = surname;
        this.joinedDate = joinDate;
        this.currAmount = currAmount;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @SequenceGenerator(name = "MEMBER_SEQ", sequenceName = "MEMBER_INFO_ID_SEQ", allocationSize = 1)
    @Column(name = "MEMBER_INFO_ID")
    public Long getMemberInfoId() {
        return memberInfoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

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
        return joinedDate;
    }

    @Column(name = "CURR_AMOUNT")
    public Long getCurrAmount() {
        return currAmount;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMemberInfoId(Long memberInfoId) {
        this.memberInfoId = memberInfoId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJoinedDate(LocalDate joinedDate){this.joinedDate = joinedDate;
    }

    public void setCurrAmount(Long currAmount) {
        this.currAmount = currAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfo that = (MemberInfo) o;
        return Objects.equals(memberInfoId, that.memberInfoId) && Objects.equals(memberID, that.memberID) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(joinedDate, that.joinedDate) && Objects.equals(accountType, that.accountType) && Objects.equals(currAmount, that.currAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberInfoId, memberID, name, surname, joinedDate, accountType, currAmount);
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "memberInfoId=" + memberInfoId +
                ", memberID=" + memberID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", joinedDate=" + joinedDate +
                ", accountType=" + accountType +
                ", currAmount=" + currAmount +
                '}';
    }
}
