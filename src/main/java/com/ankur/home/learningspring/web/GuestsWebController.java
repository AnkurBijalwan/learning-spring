package com.ankur.home.learningspring.web;

import java.util.Date;

import com.ankur.home.learningspring.business.service.GuestService;
import com.ankur.home.learningspring.business.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guests")
public class GuestsWebController {
    private final GuestService guestService;

    @Autowired
    public GuestsWebController(GuestService guestService){
        this.guestService = guestService;
    }


    @GetMapping
    public String getReservations(Model model){
        model.addAttribute("guests",guestService.getAllGuest());
        return "guests";
    }
}
