package br.com.storepcs.runner;

import br.com.storepcs.dao.PCDao;
import br.com.storepcs.dto.PCDTO;
import br.com.storepcs.model.RoleEntity;
import br.com.storepcs.model.UserEntity;
import br.com.storepcs.repository.RoleRepository;
import br.com.storepcs.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StartupRunner implements CommandLineRunner {


    private final PCDao pcJpa;

    public StartupRunner(PCDao pc) {
        this.pcJpa = pc;
    }

    @Override
    public void run(String... args) throws Exception {
        pcJpa.save(new PCDTO("i8","RTX 30 / 90", "16"));
        pcJpa.save(new PCDTO("i3", "GTX 960", "4"));
        System.out.println(pcJpa.findAll());
    }

    @Bean
    public CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            if (roleRepo.findByName("ROLE_ADMIN").isEmpty()) {
                roleRepo.save(new RoleEntity(null, "ROLE_ADMIN"));
            }
            if (roleRepo.findByName("ROLE_USER").isEmpty()) {
                roleRepo.save(new RoleEntity(null, "ROLE_USER"));
            }

            if (userRepo.findByUsername("admin").isEmpty()) {
                RoleEntity adminRole = roleRepo.findByName("ROLE_ADMIN").orElseThrow();
                RoleEntity userRole = roleRepo.findByName("ROLE_USER").orElseThrow();

                UserEntity admin = new UserEntity();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin"));
                admin.setRoles(Set.of(adminRole, userRole));

                userRepo.save(admin);
            }

            if (userRepo.findByUsername("user").isEmpty()) {
                RoleEntity userRole = roleRepo.findByName("ROLE_USER").orElseThrow();

                UserEntity user = new UserEntity();
                user.setUsername("user");
                user.setPassword(encoder.encode("user"));
                user.setRoles(Set.of(userRole));

                userRepo.save(user);
            }
        };
    }


}
