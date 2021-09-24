package za.ac.nwu.acsy.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.acsy.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@ApiModel(value = "AccountType",
            description = "A dto that represents the AccountType")
public class AccountTypeDto implements Serializable
{
    private String accountTypeName;
    private LocalDate CreationDate;

    private static final long serialVersionUID = 5166221633267636500L;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String accountTypeName, LocalDate creationDate) {
        this.accountTypeName = accountTypeName;
        this.CreationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "The CreationDate of the account type",
            dataType = "java.lang.String",
            example = "2020-01-02",
            allowEmptyValue = true)
    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(getAccountTypeName(),getCreationDate());
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
