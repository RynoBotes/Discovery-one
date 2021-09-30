package za.ac.nwu.acsy.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.acsy.translator.AccountTypeTranslator;

import java.time.LocalDate;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow
{
    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator)
    {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType)
    {
        if(null == accountType.getCreationDate())
        {
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }


}
