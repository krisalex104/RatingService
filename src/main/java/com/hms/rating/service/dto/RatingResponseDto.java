package com.hms.rating.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingResponseDto {

    @JsonProperty("ratingId")
    private Integer ratingId;
    @JsonProperty("ratingUid")
    private String ratingUid;

    @JsonProperty("totalRatings")
    private Integer totalRatings;

    @JsonProperty("userUid")
    private String userUid;

    @JsonProperty("hotelUid")
    private String hotelUid;

    @JsonProperty("feedback")
    private String feedback;

}
