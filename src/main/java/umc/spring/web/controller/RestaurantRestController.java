package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistReviewRestaurant;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{restaurantId}/review")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> review(
            @ExistReviewRestaurant @PathVariable Long restaurantId,
            @RequestBody @Valid ReviewRequestDTO.ReviewDto request) {

        Review review = reviewCommandService.review(restaurantId, request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}
