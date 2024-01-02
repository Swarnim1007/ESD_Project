package com.example.hostel.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Studentrepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
}
