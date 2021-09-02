package za.ac.nwu.acsy.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.acsy.domain.service.GeneralResponse;

@RestController
public class AccountTypeController
{
    private static final String template = "Hello %s!";

    @GetMapping("/Default")
    public GeneralResponse<String> getPing(@RequestParam(value = "id", defaultValue = "World")String id)
    {


        return new GeneralResponse<String>("success"+id,"ping received");
    }


}
