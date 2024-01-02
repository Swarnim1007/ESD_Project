package com.example.hostel.ahostelservice;

import com.example.hostel.controller.ExchangeResponse;
import com.example.hostel.controller.GetNotificationResponse;
import com.example.hostel.hostel.Hostel;
import com.example.hostel.hostel.Hostelrepo;
import com.example.hostel.student.Student;
import com.example.hostel.student.Studentrepo;
import com.example.hostel.swapApplication.SwapApplication;
import com.example.hostel.swapApplication.SwapApplicationrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SwapApplicationService {

    private final Hostelrepo hostelrepo;
    private final Studentrepo studentrepo;

    private final SwapApplicationrepo swapApplicationrepo;
    public void exchangeRoom(ExchangeRoomRequest exchangeRoomRequest) {
        Optional<Student> applicant = studentrepo.findById(exchangeRoomRequest.getStudentId());

        if(applicant.isEmpty()) {
            throw new RuntimeException("Applicant Not Found");
        }

        Hostel recHostel = hostelrepo.findHostelByRoomno(exchangeRoomRequest.getPreferredRoomNo());

        Optional<Student> recipient = studentrepo.findById(recHostel.getStudent().getId());


        if(recipient.isEmpty()) {
            throw new RuntimeException("Recipient Not Found");
        }

        SwapApplication swapApplication = SwapApplication.builder()
                .applicant(applicant.orElse(null))
                .recipient(recipient.orElse(null))
                .applicant_msg(exchangeRoomRequest.getMessage())
                .status("PENDING")
                .build();

        swapApplicationrepo.save(swapApplication);
    }

    public List<GetNotificationResponse> getNotification(Integer studentId) {
        List<SwapApplication> swapApplications = swapApplicationrepo.findByRecipient_IdAndStatus(studentId, "PENDING");


        List<GetNotificationResponse> getNotificationResponse = new ArrayList<>();;

                for (int i = 0; i < swapApplications.size(); i++) {
                    Hostel applicant = hostelrepo.findHostelByStudent(swapApplications.get(i).getApplicant());

                    GetNotificationResponse item = GetNotificationResponse.builder()
                            .swapId(swapApplications.get(i).getId())
                            .roomNo(applicant.getRoomno())
                            .name(applicant.getStudent().getFname() + " " + applicant.getStudent().getLname())
                            .message(swapApplications.get(i).getApplicant_msg())
                            .build();

                    getNotificationResponse.add(item);
                }
                return getNotificationResponse;
    }

    public void exchangeResponse(ExchangeResponse exchangeResponse) {
        Optional<SwapApplication> swapApplication = swapApplicationrepo.findById(exchangeResponse.getSwapId());

        if(swapApplication.isEmpty()) {
            throw new RuntimeException();
        }

        Hostel applicant = hostelrepo.findHostelByStudent(swapApplication.get().getApplicant());
        Hostel recipient = hostelrepo.findHostelByStudent(swapApplication.get().getRecipient());

        if(exchangeResponse.getAccept().equals("YES")) {
            swapApplication.get().setStatus("ACCEPTED");
            int appNo = applicant.getRoomno();
            int recNo = recipient.getRoomno();
            recipient.setRoomno(-1);
            applicant.setRoomno(recipient.getRoomno());
            recipient.setRoomno(appNo);
        }
        else {
            swapApplication.get().setStatus("REJECTED");
        }

        hostelrepo.save(applicant);
        hostelrepo.save(recipient);
        swapApplicationrepo.save(swapApplication.get());
    }
}
