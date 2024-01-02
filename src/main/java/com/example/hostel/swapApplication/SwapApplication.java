package com.example.hostel.swapApplication;

import com.example.hostel.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class SwapApplication {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicant_id")
    private Student applicant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    private Student recipient;

    private String applicant_msg;

    private String status="Pending";

    private String recipient_msg;

    @Override
    public String toString() {
        return "SwapApplication{" +
                "id=" + id +
                ", applicant=" + applicant +
                ", recipient=" + recipient +
                ", applicant_msg='" + applicant_msg + '\'' +
                ", status='" + status + '\'' +
                ", recipient_msg='" + recipient_msg + '\'' +
                '}';
    }
}
