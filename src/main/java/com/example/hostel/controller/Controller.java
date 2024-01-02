package com.example.hostel.controller;

import com.example.hostel.ahostelservice.Credentials;
import com.example.hostel.ahostelservice.StudentService;
import com.example.hostel.student.Student;
import com.example.hostel.hostel.Hostel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(
        origins = {
                "http://localhost:3000",
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.DELETE,
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT
        }
)

public class Controller {
    private final StudentService studentService;
    @Autowired
    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public Integer login(@RequestBody Credentials credentials){ return studentService.login(credentials); }
    @PostMapping("/hostel")
    public Hostel getHostelDetails(Student student){return studentService.getHostelDetails(student);

    }

}