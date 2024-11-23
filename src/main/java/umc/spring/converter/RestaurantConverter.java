package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequiredArgsConstructor
public class RestaurantConverter {

    // 리뷰
    public static RestaurantResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){

        return RestaurantResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(RestaurantRequestDTO.ReviewDto request, Member member, Restaurant restaurant) {

        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .star(request.getStar())
                .content(request.getContent())
                .reviewReplyList(new ArrayList<>())
                .reviewPictureList(new ArrayList<>())
                .build();
    }


    // 미션 도전
    public static RestaurantResponseDTO.ChallengeResultDTO toChallengeResultDTO(MissionHistory missionHistory) {
        return RestaurantResponseDTO.ChallengeResultDTO.builder()
                .missionHistoryId(missionHistory.getId())
                .createdAt(missionHistory.getCreatedAt())
                .build();
    }

    public static MissionHistory toMissionHistory(Member member, Mission mission) {

        return MissionHistory.builder()
                .member(member)
                .mission(mission)
                .missionState(0)
                .build();
    }
}
