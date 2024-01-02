package com.example.hostel.hostel;

import com.example.hostel.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Hostel {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = false)
    private String name;
    @Column(unique = false)
    private Integer floor;
    @Column(unique = true,nullable = false)
    private Integer roomno;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Student student;

    @Override
    public String toString() {
        return "Hostel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", roomno=" + roomno +
                ", student=" + student +
                '}';
    }
}
