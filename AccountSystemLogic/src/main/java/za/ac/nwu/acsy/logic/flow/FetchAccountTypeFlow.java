package za.ac.nwu.acsy.logic.flow;

import za.ac.nwu.acsy.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();
}
