package com.ankur.home.learningspring.data.repository;

import com.ankur.home.learningspring.data.entity.Guest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest,Long>{
    
}
