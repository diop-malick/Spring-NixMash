package com.nixmash.springdata.jsoup.config;

import com.nixmash.springdata.jsoup.dto.PagePreviewDTO;
import com.nixmash.springdata.jsoup.base.JsoupHtmlParser;
import com.nixmash.springdata.jsoup.parsers.PagePreviewParser;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/jsoup-application.properties")
@EnableConfigurationProperties({NixmashJsoupProperties.class})
public class JsoupConfig {

    @Bean
    public JsoupHtmlParser<PagePreviewDTO> pagePreviewParser() {
        return new PagePreviewParser(PagePreviewDTO.class);
    }
}




