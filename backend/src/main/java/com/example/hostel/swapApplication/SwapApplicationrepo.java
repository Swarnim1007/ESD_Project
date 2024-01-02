package com.example.hostel.swapApplication;

import com.example.hostel.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwapApplicationrepo extends JpaRepository <SwapApplication,Integer> {
//    List<SwapApplication> findSwapApplicationByStudent(Student applicant);
    List<SwapApplication> findByRecipient_IdAndStatus(Integer recipientId, String status);
//    SwapApplication findById(Integer id);
}
