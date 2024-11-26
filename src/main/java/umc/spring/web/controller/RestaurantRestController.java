package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.validation.annotation.ChallengingMission;
import umc.spring.validation.annotation.ExistReviewRestaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    // 리뷰하기
    @PostMapping("/{restaurantId}/review")
    public ApiResponse<RestaurantResponseDTO.ReviewResultDTO> review (
            @ExistReviewRestaurant @PathVariable Long restaurantId,
            @RequestBody @Valid RestaurantRequestDTO.ReviewDto request) {

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
}
