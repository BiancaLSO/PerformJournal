package com.ensemble.pj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
    "com.ensemble.pj.api",
    "com.ensemble.pj.controller",
    "com.ensemble.pj.service",
    "com.ensemble.pj.repository"
})
@Import({DbConfig.class, WebSecurityConfig.class})
public class PerformJournalServerConfig {

}
