package za.ac.nwu.acsy.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.acsy.domain.dto.MemberInfoDto;
import za.ac.nwu.acsy.domain.service.GeneralResponse;
import za.ac.nwu.acsy.logic.flow.FetchMemberInfoFlow;

import java.util.List;
@RestController
@RequestMapping("member-info")
public class MemberInfoController {


    private final FetchMemberInfoFlow fetchMemberInfoFlow;

    @Autowired
    public MemberInfoController(FetchMemberInfoFlow fetchMemberInfoFlow)
    {
        this.fetchMemberInfoFlow = fetchMemberInfoFlow;

    }

    @GetMapping("/all")
        @ApiOperation(value = "Get all configured Members",notes = "Returns a list of Members")
        @ApiResponses(value = {
                @ApiResponse(code = 200,message = "Members Returned", response = GeneralResponse.class),
                @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
                @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
                @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
        })
        public ResponseEntity<GeneralResponse<List<MemberInfoDto>>> getAll()
        {
            List<MemberInfoDto> memberInfo = fetchMemberInfoFlow.getAllMembers();
            GeneralResponse<List<MemberInfoDto>> response = new GeneralResponse<>(true,memberInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    @GetMapping("{memberID}")
        @ApiOperation(value = "Fetch specified memberID",notes = "Fetch specified account type corresponding to memberID")
        @ApiResponses(value = {
                @ApiResponse(code = 200,message = "Member Returned"),
                @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
                @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
                @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberInfoDto>> getMemberInfo(
            @ApiParam(value = "The ID that uniquely identifies the memberID.",
                    example = "123458",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID) {
        MemberInfoDto memberInfo = fetchMemberInfoFlow.getMemberByNumber(memberID);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true, memberInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("{memberID}/{currency}")
    @ApiOperation(value = "Updates specified memberID currency amount",notes = "Fetch specified account type corresponding to memberID and update currency")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Member altered"),
            @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
            @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberInfoDto>> getMemberCurrencyAdd(
            @ApiParam(value = "The ID that uniquely identifies the memberID.",
                    example = "10110001",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") final Long memberID,
            @ApiParam(value = "currency to be added.",
            example = "200",
            name = "currency",
            required = true)
            @PathVariable("currency") final Long currency){
        MemberInfoDto memberInfo = fetchMemberInfoFlow.addCurrency(memberID, currency);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true, memberInfo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
