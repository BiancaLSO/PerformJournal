package com.ensemble.pj;

import com.ensemble.pj.config.PerformJournalServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ PerformJournalServerConfig.class })
public class PerformJournalServer {

  public static void main(String[] args) {
    SpringApplication.run(PerformJournalServer.class, args);
  }
}
