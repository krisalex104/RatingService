package com.hms.rating.service.repositories;

import com.hms.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    List<Rating> findByUserUid(String userUid);
    List<Rating> findByHotelUid(String userUid);

}
