package com.example.hostel.ahostelservice;

import com.example.hostel.hostel.Hostel;
import com.example.hostel.hostel.Hostelrepo;
import com.example.hostel.student.Student;
import com.example.hostel.student.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final Hostelrepo hostelrepo;
    private final Studentrepo studentrepo;

    @Autowired
    public StudentService(Hostelrepo hostelrepo ,Studentrepo studentrepo)
    {
        this.hostelrepo=hostelrepo ;
        this.studentrepo=studentrepo;

    }
    public Integer login(Credentials credentials){
        Optional<Student> temp = studentrepo.findByEmail(credentials.username);

        if(temp.isPresent() && credentials.password.equals(temp.get().getPassword())) {
            return temp.get().getId();
        }
        return 0;
    }
    public Hostel getHostelDetails(Student student){ return hostelrepo.findHostelByStudent(student); }

}
