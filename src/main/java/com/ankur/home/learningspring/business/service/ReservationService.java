package com.ankur.home.learningspring.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ankur.home.learningspring.business.domain.RoomReservation;
import com.ankur.home.learningspring.data.entity.Guest;
import com.ankur.home.learningspring.data.entity.Reservation;
import com.ankur.home.learningspring.data.entity.Room;
import com.ankur.home.learningspring.data.repository.GuestRepository;
import com.ankur.home.learningspring.data.repository.ReservationRepository;
import com.ankur.home.learningspring.data.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    
    @Autowired
    public ReservationService(RoomRepository roomRepository,GuestRepository guestRepository, ReservationRepository reservationRepository){
                 this.guestRepository=guestRepository;
                 this.reservationRepository=reservationRepository;
                 this.roomRepository= roomRepository;       
    }
    
    public List<RoomReservation> getRoomReservationForDate(Date date){
            Iterable<Room> rooms = roomRepository.findAll();
            Map<Long, RoomReservation> roomReservationMap= new HashMap<>();
            rooms.forEach(room -> {
                RoomReservation roomReservation =new RoomReservation();
                roomReservation.setRoomId(room.getRoomId());
                roomReservation.setRoomName(room.getRoomName());
                roomReservation.setRoomNumber(room.getRoomNumber());
                roomReservationMap.put(room.getRoomId(), roomReservation);
            });

            Iterable<Reservation> reservations = reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
            
            reservations.forEach(reservation -> {
                RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
                roomReservation.setDate(date);
                Guest guest = guestRepository.findById(reservation.getGuestId()).get();
                roomReservation.setGuestId(guest.getGuestId());
                roomReservation.setFirstName(guest.getFirstName());
                roomReservation.setLastName(guest.getLastName());
                
            });


            List<RoomReservation> roomReservations =new ArrayList<>();
            for(long id: roomReservationMap.keySet()){
                roomReservations.add(roomReservationMap.get(id));
            }
            return roomReservations;
    }
}
