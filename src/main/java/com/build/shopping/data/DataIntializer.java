package com.build.shopping.data;

import com.build.shopping.model.Role;
import com.build.shopping.model.User;
import com.build.shopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Component
@RequiredArgsConstructor
public class DataIntializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Set<String> defaultRoles = Set.of("ROLE_ADMIN", "ROLE_USER");
        //createDefaultRoleIfNotExists(defaultRoles);
        createDefaultUserIfNotExists();
        createDefaultAdminIfNotExists();

    }

    private void createDefaultUserIfNotExists() {
        Role userRole = roleRepository.findByName("ROLE_USER").get();

        for (int i = 1; i <= 5; i++) {
            String defaultEmail = "user" + i + "@gamail.com";

            if (userRepository.existsByEmail(defaultEmail))
                continue;


            User newUser = new User();
            newUser.setFirstName("User");
            newUser.setLastName("User" + i);
            newUser.setEmail(defaultEmail);
            newUser.setPassword(passwordEncoder.encode("123456"));
            newUser.setRole(Set.of(userRole));
            userRepository.save(newUser);
            System.out.println("Default user" + i + " created successfully");
        }
    }

    private void createDefaultAdminIfNotExists() {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
        for (int i = 1; i <= 2; i++) {
            String defaultEmail = "admin" + i + "@gamail.com";

            if (userRepository.existsByEmail(defaultEmail))
                continue;

            User newUser = new User();
            newUser.setFirstName("Admin");
            newUser.setLastName("Admin" + i);
            newUser.setEmail(defaultEmail);
            newUser.setPassword(passwordEncoder.encode("123456"));
            newUser.setRole(Set.of(adminRole));
            userRepository.save(newUser);
            System.out.println("Default admin user" + i + " created successfully");
        }
    }


    public void createDefaultRoleIfNotExists(Set<String> defaultRoles) {
        defaultRoles.stream()
                .filter(role -> roleRepository.findByName(role).isEmpty())
                .map(Role::new).forEach(roleRepository::save);

    }
}
