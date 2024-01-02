package com.example.hostel.hostel;

import com.example.hostel.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Hostelrepo extends JpaRepository<Hostel,Integer> {
    Hostel findHostelByStudent(Student student);
    Hostel findHostelByRoomno(Integer roomno);



}
