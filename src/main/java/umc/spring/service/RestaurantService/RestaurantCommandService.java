package umc.spring.service.RestaurantService;

import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.web.dto.RestaurantRequestDTO;

import java.util.Map;

public interface RestaurantCommandService {

    // 가게 추가
    Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request);


    // 리뷰하기
    boolean ReviewRestaurantExistValidate(Long restaurantId);

    Review review(Long restaurantId, RestaurantRequestDTO.ReviewDTO request);


    // 미션 도전하기
    boolean MissionChallengeValidate(Map<String, Long> missionMemberIdMap);

    MissionHistory challenge(Long missionId, RestaurantRequestDTO.ChallengeDTO request);


    // 미션 추가
    Mission addMission(Long restaurantId, RestaurantRequestDTO.AddMissionDTO request);
}
