package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.validation.annotation.ExistReviewRestaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    // 가게 추가
    @PostMapping("/add")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> addRestaurant (
            @RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request) {

        Restaurant restaurant = restaurantCommandService.addRestaurant(request);

        return ApiResponse.onSuccess(RestaurantConverter.toRestaurantResultDTO(restaurant));
    }

    // 리뷰하기
    @PostMapping("/{restaurantId}/review")
    public ApiResponse<RestaurantResponseDTO.ReviewResultDTO> review (
            @ExistReviewRestaurant @PathVariable Long restaurantId,
            @RequestBody @Valid RestaurantRequestDTO.ReviewDTO request) {

        Review review = restaurantCommandService.review(restaurantId, request);

        return ApiResponse.onSuccess(RestaurantConverter.toReviewResultDTO(review));
    }

    // 미션 도전하기
    @PostMapping("/{restaurantId}/mission/{missionId}/challenge")
    public ApiResponse<RestaurantResponseDTO.ChallengeResultDTO> challenge (
            @PathVariable Long restaurantId,
            @PathVariable Long missionId,
            @RequestBody @Valid RestaurantRequestDTO.ChallengeDTO request) {

        MissionHistory missionHistory = restaurantCommandService.challenge(missionId, request);

        return ApiResponse.onSuccess(RestaurantConverter.toChallengeResultDTO(missionHistory));
    }

    // 미션 추가
    @PostMapping("/{restaurantId}/addMission")
    public ApiResponse<RestaurantResponseDTO.AddMissionResultDTO> addMission (
            @PathVariable Long restaurantId,
            @RequestBody @Valid RestaurantRequestDTO.AddMissionDTO request) {

        Mission mission = restaurantCommandService.addMission(restaurantId, request);

        return ApiResponse.onSuccess(RestaurantConverter.toAddMissionResultDTO(mission));
    }
}
