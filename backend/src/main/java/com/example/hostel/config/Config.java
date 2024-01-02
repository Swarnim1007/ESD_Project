package com.example.hostel.config;

import com.example.hostel.hostel.Hostel;
import com.example.hostel.hostel.Hostelrepo;
import com.example.hostel.student.Student;
import com.example.hostel.student.Studentrepo;
import com.example.hostel.swapApplication.SwapApplication;
import com.example.hostel.swapApplication.SwapApplicationrepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Year;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner commandLineRunner(Studentrepo studentRepo, Hostelrepo hostelRepo, SwapApplicationrepo swapApplicationRepo) {
        return args -> {
            try {
                if (studentRepo.count() == 0) {
                    Student s1 = new Student(1, 29, "Swarnim", "Kukreti", "swarnim@gmail.com", "1234", "", 3.4F, 4, Year.of(2025));
                    Student s2 = new Student(2, 30, "Priya", "Negi", "priya@gmail.com", "1234", "", 3.4F, 4, Year.of(2025));
                    System.out.println(s1);
                    studentRepo.saveAll(List.of(s1, s2));

                    if (hostelRepo.count() == 0) {
                        Hostel h1 = new Hostel(1, "Bhaskara", 4, 230, s1);
                        Hostel h2 = new Hostel(2, "Bhaskara", 2, 233, s2);
                        hostelRepo.saveAll(List.of(h1, h2));

                        if (swapApplicationRepo.count() == 0) {
                            SwapApplication a1 = new SwapApplication(1, s1, s2, "HEyy", "PENDING", "Bye");
                            swapApplicationRepo.saveAll(List.of(a1));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
