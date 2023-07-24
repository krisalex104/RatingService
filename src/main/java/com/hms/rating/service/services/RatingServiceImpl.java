package com.hms.rating.service.services;

import com.hms.rating.service.dto.RatingRequestDto;
import com.hms.rating.service.dto.RatingResponseDto;
import com.hms.rating.service.entities.Rating;
import com.hms.rating.service.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{


    private final RatingRepository ratingRepository;
    private static UUID uid;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingResponseDto saveRatingDetails(RatingRequestDto requestDto) {
        Rating rating=Rating.builder()
                .ratingUid(uid.randomUUID().toString())
                .userUid(requestDto.getUserUid())
                .hotelUid(requestDto.getHotelUid())
                .totalRatings(requestDto.getTotalRatings())
                .feedback(requestDto.getFeedback())
                .build();

        Rating save = ratingRepository.save(rating);
        RatingResponseDto response= RatingResponseDto.builder()
                .ratingId(save.getId())
                .ratingUid(save.getRatingUid())
                .userUid(save.getUserUid())
                .totalRatings(save.getTotalRatings())
                .hotelUid(save.getHotelUid())
                .feedback(save.getFeedback())
                .build();
        return response;
    }

    @Override
    public List<RatingResponseDto> findAllRatings() {
        List<Rating> ratingList = ratingRepository.findAll();
        List<RatingResponseDto> ratingResponseDtoList=new ArrayList<>();
        if(!ratingList.isEmpty()){
            ratingList.forEach(save->{
                RatingResponseDto response= RatingResponseDto.builder()
                        .ratingId(save.getId())
                        .ratingUid(save.getRatingUid())
                        .userUid(save.getUserUid())
                        .totalRatings(save.getTotalRatings())
                        .hotelUid(save.getHotelUid())
                        .feedback(save.getFeedback())
                        .build();
                ratingResponseDtoList.add(response);
            });
        }
        return ratingResponseDtoList;
    }

    @Override
    public RatingResponseDto findByRatingId(Integer id) {
        Optional<Rating> ratingOptional = ratingRepository.findById(id);
        if(!ratingOptional.isPresent()){
            throw new ResolutionException("rating details not found with given id");
        }

        Rating save = ratingOptional.get();
        RatingResponseDto response= RatingResponseDto.builder()
                .ratingId(save.getId())
                .ratingUid(save.getRatingUid())
                .userUid(save.getUserUid())
                .totalRatings(save.getTotalRatings())
                .hotelUid(save.getHotelUid())
                .feedback(save.getFeedback())
                .build();
        return response;
    }

    @Override
    public List<RatingResponseDto> findByUserUid(String userUid) {
        List<Rating> ratingList = ratingRepository.findByUserUid(userUid);
        List<RatingResponseDto> ratingResponseDtoList=new ArrayList<>();
        if(!ratingList.isEmpty()){
            ratingList.forEach(save->{
                RatingResponseDto response= RatingResponseDto.builder()
                        .ratingId(save.getId())
                        .ratingUid(save.getRatingUid())
                        .userUid(save.getUserUid())
                        .totalRatings(save.getTotalRatings())
                        .hotelUid(save.getHotelUid())
                        .feedback(save.getFeedback())
                        .build();
                ratingResponseDtoList.add(response);
            });
        }
        return ratingResponseDtoList;
    }

    @Override
    public List<RatingResponseDto> findByHotelUid(String hotelUid) {
        List<Rating> ratingList = ratingRepository.findByHotelUid(hotelUid);
        List<RatingResponseDto> ratingResponseDtoList=new ArrayList<>();
        if(!ratingList.isEmpty()){
            ratingList.forEach(save->{
                RatingResponseDto response= RatingResponseDto.builder()
                        .ratingId(save.getId())
                        .ratingUid(save.getRatingUid())
                        .userUid(save.getUserUid())
                        .totalRatings(save.getTotalRatings())
                        .hotelUid(save.getHotelUid())
                        .feedback(save.getFeedback())
                        .build();
                ratingResponseDtoList.add(response);
            });
        }
        return ratingResponseDtoList;
    }
}
