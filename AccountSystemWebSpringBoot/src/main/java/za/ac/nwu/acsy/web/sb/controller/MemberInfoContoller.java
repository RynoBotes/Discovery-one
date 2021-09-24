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
import za.ac.nwu.acsy.logic.flow.CreateMemberInfoFlow;
import za.ac.nwu.acsy.logic.flow.FetchMemberInfoFlow;

import java.util.List;
@RestController
@RequestMapping("member-info")
public class MemberInfoContoller {


    private final FetchMemberInfoFlow fetchMemberInfoFlow;
    private final CreateMemberInfoFlow createMemberInfoFlow;
    @Autowired
    public MemberInfoContoller(FetchMemberInfoFlow fetchMemberInfoFlow, CreateMemberInfoFlow createMemberInfoFlow) {
        this.fetchMemberInfoFlow = fetchMemberInfoFlow;
        this.createMemberInfoFlow = createMemberInfoFlow;
    }

    @GetMapping("/all")
        @ApiOperation(value = "Get all configured accounts",notes = "Returns a list of accounts")
        @ApiResponses(value = {
                @ApiResponse(code = 200,message = "Accounts Returned", response = GeneralResponse.class),
                @ApiResponse(code = 400,message = "Bad request", response = GeneralResponse.class),
                @ApiResponse(code = 404,message = "Not Found", response = GeneralResponse.class),
                @ApiResponse(code = 500,message = "Internal Server error", response = GeneralResponse.class)
        })
        public ResponseEntity<GeneralResponse<List<MemberInfoDto>>> getAll()
        {
            List<MemberInfoDto> memberInfos = fetchMemberInfoFlow.getAllMembers();
            GeneralResponse<List<MemberInfoDto>> response = new GeneralResponse<>(true,memberInfos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    @PostMapping("")
    @ApiOperation(value = "Creates a new MemberInfo.", notes = "Creates a new Member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "The Member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400,message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberInfoDto>> create(
            @ApiParam(value = "Request body to create a new memberInfo",required = true)
            @RequestBody MemberInfoDto memberInfo)
    {
        MemberInfoDto memberInfoResponse =  createMemberInfoFlow.createMember(memberInfo);
        GeneralResponse<MemberInfoDto> response = new GeneralResponse<>(true,memberInfoResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
