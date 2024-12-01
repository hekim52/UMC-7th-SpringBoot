package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;

    // 가게 추가
    @PostMapping("/addRestaurant")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> addRestaurant (
            @RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request) {

        Restaurant restaurant = restaurantCommandService.addRestaurant(request);

        return ApiResponse.onSuccess(RestaurantConverter.toRestaurantResultDTO(restaurant));
    }

    // 리뷰하기
    @PostMapping("/{restaurantId}/review")
    public ApiResponse<RestaurantResponseDTO.ReviewResultDTO> review (
            @ExistRestaurant @PathVariable Long restaurantId,
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

    // 가게의 리뷰 목록 조회
    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @CheckPage @RequestParam(name = "page") Integer page){

        Page<Review> reviewList = restaurantQueryService.getReviewList(restaurantId,page-1);

        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDTO(reviewList));
    }

    // 특정 가게의 미션 목록 조회
    @GetMapping("/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<RestaurantResponseDTO.MissionListDTO> getMissionList(
            @ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId,
            @CheckPage @RequestParam(name = "page") Integer page){

        Page<Mission> missionList = restaurantQueryService.getMissionList(restaurantId, page-1);

        return ApiResponse.onSuccess(RestaurantConverter.missionListDTO(missionList));
    }
}
