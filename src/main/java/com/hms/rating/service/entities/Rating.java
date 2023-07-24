package com.hms.rating.service.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel_ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rating_uid")
    private String ratingUid;

    @Column(name="total_ratings")
    private Integer totalRatings;

    @Column(name = "user_uid")
    private String userUid;

    @Column(name = "hotel_uid")
    private String hotelUid;

    @Column(name = "feedback")
    private String feedback;

}
