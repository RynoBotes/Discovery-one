package za.ac.nwu.acsy.domain.dto;

import za.ac.nwu.acsy.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTypeDto implements Serializable
{
    private String accountTypeName;
    private LocalDate CreationDate;

    private static final long serialVersionUID = 5166221633267636500L;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String accountTypeName, LocalDate creationDate) {
        this.accountTypeName = accountTypeName;
        CreationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
    }



    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(CreationDate, that.CreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeName, CreationDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountTypeName='" + accountTypeName + '\'' +
                ", CreationDate=" + CreationDate +
                '}';
    }
}
