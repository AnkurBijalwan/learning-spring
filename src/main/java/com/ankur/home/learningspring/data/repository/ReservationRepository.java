package com.ankur.home.learningspring.data.repository;

import java.sql.Date;

import com.ankur.home.learningspring.data.entity.Reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long>{
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
