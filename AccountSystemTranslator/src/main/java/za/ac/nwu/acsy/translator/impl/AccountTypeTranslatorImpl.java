package za.ac.nwu.acsy.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.domain.persistence.AccountType;
import za.ac.nwu.acsy.repo.persistence.AccountTypeRepository;
import za.ac.nwu.acsy.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeTranslatorImpl implements AccountTypeTranslator {
    AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository)
    {
        this.accountTypeRepository = accountTypeRepository;
    }


    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for(AccountType accountType : accountTypeRepository.findAll())
            {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        }catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return accountTypeDtos;
    }
}
