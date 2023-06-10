package com.kpoexamen.crudapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Bookings")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hotelId;
    private LocalDate checkin;
    private LocalDate checkout;
}
