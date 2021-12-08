package com.ankur.home.learningspring.web;

import java.util.Date;

import com.ankur.home.learningspring.business.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService){
        this.reservationService = reservationService;
    }


    @GetMapping
    public String getReservations(@RequestParam (value="date", required= false) String dateString, Model model){
        Date date= DateUtils.createDateFromDateString(dateString);
        model.addAttribute("roomReservations",reservationService.getRoomReservationForDate(date));
        return "reservations";
    }
}
