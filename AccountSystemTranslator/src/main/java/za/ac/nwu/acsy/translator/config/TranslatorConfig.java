package za.ac.nwu.acsy.translator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.acsy.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
public class TranslatorConfig {
}
