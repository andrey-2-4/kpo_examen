package com.kpoexamen.crudapp.repositories;

import com.kpoexamen.crudapp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
