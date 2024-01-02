package com.example.hostel.controller;

import com.example.hostel.ahostelservice.ExchangeRoomRequest;
import com.example.hostel.ahostelservice.SwapApplicationService;
import com.example.hostel.swapApplication.SwapApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/swapApplication/")
@RequiredArgsConstructor
public class SwapApplicationController {

    private final SwapApplicationService swapApplicationService;

    @PostMapping("exchange-request")
    public String exchangeRequest(@RequestBody ExchangeRoomRequest exchangeRoomRequest) {
        // Handle the request payload and perform necessary actions
        // You can replace String with a class representing your resource

        swapApplicationService.exchangeRoom(exchangeRoomRequest);
        // For example, just echoing the request payload
        return "Request Successful";
    }

    @GetMapping("getNotification/{studentId}")
    public List<GetNotificationResponse> getNotification(@PathVariable Integer studentId) {
        // Handle the request payload and perform necessary actions
        // You can replace String with a class representing your resource

        return swapApplicationService.getNotification(studentId);
    }

    @PostMapping("exchange-response")
    public String exchangeResponse(@RequestBody ExchangeResponse exchangeResponse) {
        // Handle the request payload and perform necessary actions
        // You can replace String with a class representing your resource

        swapApplicationService.exchangeResponse(exchangeResponse);
        // For example, just echoing the request payload
        return "Request Successful";
    }
}
