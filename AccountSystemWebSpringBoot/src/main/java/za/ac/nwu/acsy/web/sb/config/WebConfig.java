package za.ac.nwu.acsy.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages =
        {
        "za.ac.nwu.ac.web.sb.controller",
        "za.ac.nwu.ac.web.sb.exception"
        })
public class WebConfig
{

}