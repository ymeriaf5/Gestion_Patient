package com.example.springrev;

import com.example.springrev.entities.Patient;
import com.example.springrev.repositories.PatientRepository;
import com.example.springrev.security.Services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SpringRevApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRevApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRep){
        return args -> {
            patientRep.save(new Patient(null,"Youness",new Date(),false,20));
            patientRep.save(new Patient(null,"Mohemmed",new Date(),true,18));
            patientRep.save(new Patient(null,"Oussama",new Date(),false,30));
            patientRep.save(new Patient(null,"Amine",new Date(),true,10));
            patientRep.save(new Patient(null,"Kaoutar",new Date(),false,40));
            patientRep.save(new Patient(null,"Meriam",new Date(),true,15));

            patientRep.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
    //@Bean
    CommandLineRunner commandLineRunner(AccountService accountService){
        return args -> {
            accountService.addNewRole("USER");
            accountService.addNewRole("ADMIN");
            accountService.addNewUser("user1","1234","user1@gmail.com","1234");
            accountService.addNewUser("user2","1234","user2@gmail.com","1234");
            accountService.addNewUser("admin","1234","admin@gmail.com","1234");
            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");

        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
