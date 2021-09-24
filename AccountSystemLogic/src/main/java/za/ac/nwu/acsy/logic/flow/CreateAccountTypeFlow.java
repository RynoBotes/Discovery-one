package za.ac.nwu.acsy.logic.flow;

import za.ac.nwu.acsy.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow
{
    AccountTypeDto create(AccountTypeDto accountType);

}
