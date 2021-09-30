package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 6768375643820438880L;
    private Long accountTypeId;
    private String accountTypeName;
    private LocalDate creationDate;
    List<MemberInfo> memberInfoSet;

    public AccountType() {
    }

    public AccountType(Long accountTypeId, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountType(String accountTypeName, LocalDate creationDate)
    {
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "ACCOUNT_TYPE_ID_SEQ", allocationSize = 1)
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @OneToMany(targetEntity = MemberInfo.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public List<MemberInfo> getMemberInfoSet() {
        return memberInfoSet;
    }

    public void setMemberInfoSet(List<MemberInfo> memberInfoSet) {
        this.memberInfoSet = memberInfoSet;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate) && Objects.equals(memberInfoSet, that.memberInfoSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, accountTypeName, creationDate, memberInfoSet);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                ", memberInfoSet=" + memberInfoSet +
                '}';
    }
}
