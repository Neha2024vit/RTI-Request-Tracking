
package com.example.rti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class OfficerInitializer {

    @Bean
    CommandLineRunner initOfficer(
            AppUserRepository users,
            PasswordEncoder enc,
            @Value("${rti.officer.email:officer@rti.gov.in}") String email,
            @Value("${rti.officer.password:}") String password) {

        return args -> {
            if (password == null || password.isBlank()) {
                System.out.println("Officer setup skipped: password is empty.");
                return;
            }

            String e = email.trim().toLowerCase();

            AppUser officer = users.findByEmailIgnoreCase(e)
                    .orElseGet(() -> {
                        AppUser u = new AppUser();
                        u.setFullName("RTI Officer");
                        u.setEmail(e);
                        u.setRole("OFFICER");
                        return u;
                    });

            officer.setPassword(enc.encode(password));
            officer.setRole("OFFICER");
            users.save(officer);

            System.out.println("Officer account initialized: " + e);
        };
    }
}
