package com.kpoexamen.crudapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Hotels")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String address;
    private Double price;
    // допустим, что это будет список всех удобств и подробное описание
    private String description;
}
