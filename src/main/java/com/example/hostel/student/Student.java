package com.example.hostel.student;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.lang.NonNull;

import java.time.Year;

@Entity
@Table
//@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private Integer rollno;

    @Column(nullable = false)
    private String fname;

    private String lname;

    @Column(unique = true, nullable = false)
    private String email;
    private String Password;
    private String photographpath;

    @Column(nullable=false)
    private Float cgpa = 0F;

    @Column(nullable=false)
    private Integer totalcredits;

    private Year graduationyear;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRollno() {
        return rollno;
    }

    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() { return Password; }

    public void setPassword(String password) {
        Password = password;
    }


    public String getPhotographpath() {
        return photographpath;
    }

    public void setPhotographpath(String photographpath) {
        this.photographpath = photographpath;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotalcredits() {
        return totalcredits;
    }

    public void setTotalcredits(Integer totalcredits) {
        this.totalcredits = totalcredits;
    }

    public Year getGraduationyear() {
        return graduationyear;
    }

    public void setGraduationyear(Year graduationyear) {
        this.graduationyear = graduationyear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollno=" + rollno +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + Password + '\'' +
                ", photographpath='" + photographpath + '\'' +
                ", cgpa=" + cgpa +
                ", totalcredits=" + totalcredits +
                ", graduationyear=" + graduationyear +
                '}';
    }

    public Student(Integer id, Integer rollno, String fname, String lname, String email, String password, String photographpath, Float cgpa, Integer totalcredits, Year graduationyear) {
        this.id = id;
        this.rollno = rollno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.Password = password;
        this.photographpath = photographpath;
        this.cgpa = cgpa;
        this.totalcredits = totalcredits;
        this.graduationyear = graduationyear;
    }
}
