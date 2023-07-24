package com.hms.rating.service.services;

import com.hms.rating.service.dto.RatingRequestDto;
import com.hms.rating.service.dto.RatingResponseDto;

import java.util.List;

public interface RatingService {

    RatingResponseDto saveRatingDetails(RatingRequestDto requestDto);

    List<RatingResponseDto> findAllRatings();

    RatingResponseDto findByRatingId(Integer id);

    List<RatingResponseDto> findByUserUid(String userUid);
    List<RatingResponseDto> findByHotelUid(String hotelUid);

}
