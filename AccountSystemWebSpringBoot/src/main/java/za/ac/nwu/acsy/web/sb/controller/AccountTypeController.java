package za.ac.nwu.acsy.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.acsy.domain.dto.AccountTypeDto;
import za.ac.nwu.acsy.domain.service.GeneralResponse;
import za.ac.nwu.acsy.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController
{
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    @Autowired
    public AccountTypeController (FetchAccountTypeFlow fetchAccountTypeFlow)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all configured accounts",notes = "Returns a list of accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Accounts Returned", response = GeneralResponse.class),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true,accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
