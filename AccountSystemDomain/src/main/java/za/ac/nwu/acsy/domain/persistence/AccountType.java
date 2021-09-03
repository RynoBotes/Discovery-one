package za.ac.nwu.acsy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER_ACCOUNT")
public class AccountType implements Serializable
{
    @Id
    @SequenceGenerator(name="ACCOUNT_ROW_SEQ", sequenceName = "ACCOUNT_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_SEQ")
    @Column(name = "ROW_ID")
    private long rowId;

    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(name = "CURR_AMOUNT")
    private long currAmount;

    @Column(name = "CURRENCY_TYPE")
    private String currencyType;

}
