package com.hms.rating.service.controllers;

import com.hms.rating.service.dto.RatingRequestDto;
import com.hms.rating.service.dto.RatingResponseDto;
import com.hms.rating.service.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    ResponseEntity<RatingResponseDto> saveRatingDetail(@RequestBody RatingRequestDto requestDto){
        RatingResponseDto responseDto = ratingService.saveRatingDetails(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    ResponseEntity<List<RatingResponseDto>> fetchAllRatings(){
        List<RatingResponseDto> allRatings = ratingService.findAllRatings();
        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/{ratingId}")
    ResponseEntity<RatingResponseDto> fetchRatingById(@PathVariable("ratingId") Integer ratingId){
        RatingResponseDto response = ratingService.findByRatingId(ratingId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userUid}")
    ResponseEntity<List<RatingResponseDto>> fetchRatingByUserUid(@PathVariable("userUid") String userUid){
        List<RatingResponseDto> list = ratingService.findByUserUid(userUid);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/hotel/{hotelUid}")
    ResponseEntity<List<RatingResponseDto>> fetchRatingByHotelUid(@PathVariable("hotelUid") String hotelUid){
        List<RatingResponseDto> list = ratingService.findByHotelUid(hotelUid);
        return ResponseEntity.ok(list);
    }
}
