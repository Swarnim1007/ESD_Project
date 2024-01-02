package com.example.hostel.ahostelservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRoomRequest {

    private String message;
    private Integer preferredRoomNo;
    private Integer studentId;
}
