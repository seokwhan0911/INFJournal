package com.um5th.hackerthon.infjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InfJournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfJournalApplication.class, args);
    }

}
