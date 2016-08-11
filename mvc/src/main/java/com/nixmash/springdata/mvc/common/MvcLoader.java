package com.nixmash.springdata.mvc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Component;

@Component
public class MvcLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MvcLoader.class);

    @Autowired
    Environment environment;

    @Override
    public void run(String... args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String option : args) {
            sb.append(" ").append(option);
        }

        sb = sb.length() == 0 ? sb.append("No Options Specified") : sb;
        logger.info("App launched with following arguments: {}", sb.toString());

        PropertySource<?> ps = new SimpleCommandLinePropertySource(args);
        String appUrl = (String) ps.getProperty("appurl");

        logger.info("Command-line appurl is {}", appUrl);

        String applicationPropertyUrl = environment.getProperty("spring.social.application.url");
        logger.info("Current Spring Social ApplicationUrl is {}", applicationPropertyUrl);

        String applicationVersion = environment.getProperty("web.site.version");
        logger.info("NixMash MVC Application Version: {}", applicationVersion);

    }
}
