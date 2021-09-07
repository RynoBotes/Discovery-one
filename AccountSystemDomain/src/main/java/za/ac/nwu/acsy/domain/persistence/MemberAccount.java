package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "MEMBER_ACCOUNT")
public class MemberAccount implements Serializable {

    private static final long serialVersionUID = -6585018513626046103L;
    private Long accountId;
    private MemberInfo memberInfoId;
    private AccountType accountTypeId;
    private Long currAmount;
    Set<Transaction> transactionSet;

    @OneToMany(targetEntity = Transaction.class,fetch = FetchType.LAZY, mappedBy = "memberAccount",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<Transaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
    }

    public MemberAccount() {
    }

    public MemberAccount(Long accountId, AccountType accountTypeId, Long currAmount) {
        this.accountId = accountId;
        this.accountTypeId = accountTypeId;
        this.currAmount = currAmount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_SEQUENCE")
    @SequenceGenerator(name = "ACCOUNT_ID_SEQUENCE", sequenceName = "ACCOUNT_ID_SEQ", allocationSize = 1)
    @Column(name = "account_id", nullable = false)
    public Long getAccountId() {
        return accountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public MemberInfo getMemberInfoId() {
        return memberInfoId;
    }

    @Column(name = "CURR_AMOUNT")
    public Long getCurrAmount() {
        return currAmount;
    }

    public void setMemberInfoId(MemberInfo memberInfoId) {
        this.memberInfoId = memberInfoId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public void setCurrAmount(Long currAmount) {
        this.currAmount = currAmount;
    }
}
