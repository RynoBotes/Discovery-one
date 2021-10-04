package za.ac.nwu.acsy.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.translator.AccountTypeTranslator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception
    {
//        translator = Mockito.mock(AccountTypeTranslator.class);
//        flow = new CreateAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void create()
    {
        Mockito.when(translator.create(any(AccountTypeDto.class))).thenReturn(new AccountTypeDto());
        AccountTypeDto result = flow.create(new AccountTypeDto());
        assertNotNull(result);
//        verify(translator, atLeastOnce()).create(new AccountTypeDto());
    }

}