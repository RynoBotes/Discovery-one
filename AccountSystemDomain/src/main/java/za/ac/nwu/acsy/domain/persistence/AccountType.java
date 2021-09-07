package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 6768375643820438880L;
    private Long accountTypeId;
    private String accountTypeName;
    private LocalDate CreationDate;
    Set<MemberAccount> memberAccountSet;

    public AccountType() {
    }

    public AccountType(Long accountTypeId, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
        CreationDate = creationDate;
    }

    @OneToMany(targetEntity = MemberAccount.class,fetch = FetchType.LAZY, mappedBy = "accountTypeId",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<MemberAccount> getMemberAccountSet() {
        return memberAccountSet;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_SEQ")
    @SequenceGenerator(name = "ACCOUNT_TYPE_SEQ", sequenceName = "ACCOUNT_TYPE_ID_SEQ", allocationSize = 1)
    @Column(name = "ACCOUNT_TYPE_ID", nullable = false)
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }
    public void setMemberAccountSet(Set<MemberAccount> memberAccountSet) {
        this.memberAccountSet = memberAccountSet;
    }

}
