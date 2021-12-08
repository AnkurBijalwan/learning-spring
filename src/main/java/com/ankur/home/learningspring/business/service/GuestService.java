package com.ankur.home.learningspring.business.service;

import java.util.ArrayList;
import java.util.List;

import com.ankur.home.learningspring.data.entity.Guest;
import com.ankur.home.learningspring.data.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuest(){
        List<Guest> guestList = new ArrayList<>();
        Iterable<Guest> iterable=  guestRepository.findAll();

        iterable.forEach(guest -> guestList.add(guest));
        return guestList;
    }
}
