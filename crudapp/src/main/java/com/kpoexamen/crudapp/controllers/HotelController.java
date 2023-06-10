package com.kpoexamen.crudapp.controllers;

import com.kpoexamen.crudapp.models.Hotel;
import com.kpoexamen.crudapp.models.Review;
import com.kpoexamen.crudapp.pojo.HotelsResponse;
import com.kpoexamen.crudapp.repositories.HotelRepository;
import com.kpoexamen.crudapp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel hotelObj = hotelRepository.save(hotel);
        return new ResponseEntity<>(hotelObj, HttpStatus.OK);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelsResponse>> getAllHotels() {
        try {
            List<Hotel> hotelList = new ArrayList<>(hotelRepository.findAll());
            List<Review> reviews = new ArrayList<>(reviewRepository.findAll());

            if (hotelList.isEmpty()) { // если список пустой
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<HotelsResponse> response = new ArrayList<>();
            for (int i = 0; i < hotelList.size(); ++i) {
                response.add(new HotelsResponse(
                        hotelList.get(i).getId(),
                        hotelList.get(i).getTitle(),
                        hotelList.get(i).getAddress(),
                        hotelList.get(i).getPrice()));
                Long rating = 0L;
                Long amountOfRatings = 0L;
                for (var review : reviews) {
                    if (review.getHotelId().equals(hotelList.get(i).getId())) {
                        rating += review.getRating();
                        amountOfRatings += 1;
                    }
                }
                if (amountOfRatings > 0L) {
                    rating /= amountOfRatings;
                    response.get(i).setRating(rating);
                }
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);

        if (hotel.isPresent()) { // проверка optional`а
            return new ResponseEntity<>(hotel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
