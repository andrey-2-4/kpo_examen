package com.kpoexamen.crudapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Reviews")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hotelId;
    private Long rating;
    private String review;
}
