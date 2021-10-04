package za.ac.nwu.acsy.web.sb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.acsy.logic.flow.FetchAccountTypeFlow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTypeControllerTest {

    private static final String  APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL+"/account-type";

    @Mock
    private FetchAccountTypeFlow fetchAccountTypeFlow;

    @Mock
    private CreateAccountTypeFlow createAccountTypeFlow;

    @InjectMocks
    private AccountTypeController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\n\"successful\": true,\"payload\": [" +
                "    {\"accountTypeName\": \"MILES\",\"creationDate\": [2020,01,02]}" +
                "    {\"accountTypeName\": \"PLAY\",\"creationDate\": [2000,10,02]}]}" ;/*+
                "    {\"accountTypeName\": \"ZA RANDS\",\"creationDate\": [2000,01,01]},\n" +
                "    {\"accountTypeName\": \"POMPIES\",\"creationDate\": [2020,01,02]},\n" +
                "    {\"accountTypeName\": \"PIET\",\"creationDate\": [2021,09,29]";*/

        List<AccountTypeDto> accountTypes = new ArrayList<>();
        accountTypes.add(new AccountTypeDto("MILES", LocalDate.parse("2020-01-02")));
        accountTypes.add(new AccountTypeDto("PLAY", LocalDate.parse("2000-10-02")));

        when(fetchAccountTypeFlow.getAllAccountTypes()).thenReturn(accountTypes);

        /*MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",ACCOUNT_TYPE_CONTROLLER_URL,"all")))
                .servletPath(APP_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();*/

        verify(fetchAccountTypeFlow, times(1)).getAllAccountTypes();
        //assertEquals(expectedResponse , mvcResult.getResponse().getContentAsString());

    }

//    private MockHttpServletRequestBuilder get(String all) {
//    }

    @Test
    public void create() {
    }

    @Test
    public void getAccountType() {
    }
}