package com.kpoexamen.crudapp.controllers;

import com.kpoexamen.crudapp.models.Hotel;
import com.kpoexamen.crudapp.models.Review;
import com.kpoexamen.crudapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @GetMapping("/reviews/{hotelId}")
    public ResponseEntity<List<Review>> getHotelById(@PathVariable Long hotelId) {
        List<Review> reviews = new ArrayList<>(reviewRepository.findAll());
        List<Review> response = new ArrayList<>();

        for (var review : reviews) {
            if (review.getHotelId().equals(hotelId)) {
                response.add(review);
            }
        }

        if (!response.isEmpty()) { // проверка optional`а
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> addBook(@RequestBody Review review) {
        Review reviewObj = reviewRepository.save(review);
        return new ResponseEntity<>(reviewObj, HttpStatus.OK);
    }
}
