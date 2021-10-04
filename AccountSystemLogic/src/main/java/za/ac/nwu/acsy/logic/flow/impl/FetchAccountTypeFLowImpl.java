package za.ac.nwu.acsy.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.acsy.translator.AccountTypeTranslator;

import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFLowImpl implements FetchAccountTypeFlow
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTypeFLowImpl.class);

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

    @Override
    public AccountTypeDto getAccountTypeByName(String accountTypeName)
    {
        LOGGER.info("The returned account type  Name {}",accountTypeName);
        return accountTypeTranslator.getAccountTypeByName(accountTypeName);
    }

//    public boolean methodToTest()
//    {
//        return true;
//    }


}
