package com.example.hostel.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetNotificationResponse {

    private Integer roomNo;
    private String message;
    private String name;
    private Integer swapId;
}
