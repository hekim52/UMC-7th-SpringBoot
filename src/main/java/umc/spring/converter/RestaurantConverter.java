package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import umc.spring.domain.*;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RestaurantConverter {

    // 가게 추가
    public static RestaurantResponseDTO.AddRestaurantResultDTO toRestaurantResultDTO(Restaurant restaurant){

        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDTO request, Region region) {

        return Restaurant.builder()
                .region(region)
                .restaurantName(request.getRestaurantName())
                .restaurantAddress(request.getRestaurantAddress())
                .restaurantStar(0F)
                .reviewList(new ArrayList<>())
                .missionList(new ArrayList<>())
                .build();
    }


    // 리뷰
    public static RestaurantResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){

        return RestaurantResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(RestaurantRequestDTO.ReviewDTO request, Member member, Restaurant restaurant) {

        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .star(request.getStar())
                .content(request.getContent())
                .reviewImageList(new ArrayList<>())
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


    // 미션 추가
    public static RestaurantResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {

        return RestaurantResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(RestaurantRequestDTO.AddMissionDTO request, Restaurant restaurant) {

        return Mission.builder()
                .restaurant(restaurant)
                .moreThanPrice(request.getMoreThanPrice())
                .getPoint(request.getGetPoint())
                .d_Day(request.getD_day())
                .ownerId(request.getOwnerId())
                .missionHistoryList(new ArrayList<>())
                .build();
    }

    // 가게의 리뷰 목록 조회
    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getStar())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .listSize(reviewList.getTotalElements())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    // 특정 가게의 미션 목록 조회
    public static RestaurantResponseDTO.MissionDTO missionDTO(Mission mission){

        return RestaurantResponseDTO.MissionDTO.builder()
                .missionId(mission.getId())
                .moreThanPrice(mission.getMoreThanPrice())
                .getPoint(mission.getGetPoint())
                .d_Day(mission.getD_Day())
                .ownerId(mission.getOwnerId())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static RestaurantResponseDTO.MissionListDTO missionListDTO(Page<Mission> missionList){

        List<RestaurantResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(RestaurantConverter::missionDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .listSize(missionList.getTotalElements())
                .missionList(missionDTOList)
                .build();
    }
}
