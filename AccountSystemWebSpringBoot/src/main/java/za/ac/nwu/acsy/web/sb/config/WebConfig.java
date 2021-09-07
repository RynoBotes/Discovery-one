package za.ac.nwu.acsy.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.acsy.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages =
        {
        "za.ac.nwu.acsy.web.sb.controller",
        "za.ac.nwu.acsy.web.sb.exception"
        })
public class WebConfig
{

}