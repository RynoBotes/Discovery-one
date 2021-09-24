package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.acsy.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFLowImpl implements FetchAccountTypeFlow
{

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFLowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator =  accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes()
    {
        return accountTypeTranslator.getAllAccountTypes();
    }
}
