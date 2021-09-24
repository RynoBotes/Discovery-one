package za.ac.nwu.acsy.translator;

import za.ac.nwu.acsy.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator
{
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeByName(String accountTypeName);
}
