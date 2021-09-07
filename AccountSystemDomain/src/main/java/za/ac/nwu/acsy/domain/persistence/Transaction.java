package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable
{

    private Long transactionId;
    private MemberAccount memberAccount;
    private LocalDate txDate;
    private static final long serialVersionUID = -3327187215620680474L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ID_SEQ")
    @SequenceGenerator(name = "TRANSACTION_ID_SEQ", sequenceName = "TRANSACTION_ID_SEQ", allocationSize = 1)
    @Column(name = "TRANSACTION_ID", nullable = false)
    public Long getTransactionId() {
        return transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    public MemberAccount getMemberAccount() {
        return memberAccount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTxDate() {
        return txDate;
    }

    public void setMemberAccount(MemberAccount memberAccount) {
        this.memberAccount = memberAccount;
    }

    public void setTxDate(LocalDate txDate) {
        this.txDate = txDate;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
