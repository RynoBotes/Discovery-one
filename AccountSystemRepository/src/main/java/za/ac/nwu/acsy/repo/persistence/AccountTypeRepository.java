package za.ac.nwu.acsy.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.acsy.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long>
{

    @Query(value = "SELECT "+
            "       at "+
            "       FROM "+
            "       AccountType at "+
            "   WHERE at.accountTypeName = :accountTypeName ")
    AccountType getAccountTypeByName(String accountTypeName);
}
