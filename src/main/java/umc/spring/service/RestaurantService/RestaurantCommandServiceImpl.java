package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.*;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionHistoryRepository.MissionHistoryRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.web.dto.RestaurantRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    private final MissionHistoryRepository missionHistoryRepository;
    private final MissionRepository missionRepository;
    private final RegionRepository regionRepository;

    // 페이징 값 validation
    @Override
    public boolean PageTooSmallValidate(Integer page) {
        return page > 0;
    }

    // 가게 추가
    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request) {

        Region region = regionRepository.findById(request.getRegionId()).get();

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request, region);
        region.setRestaurant(newRestaurant);

        return restaurantRepository.save(newRestaurant);
    }

    // 리뷰하기
    @Override
    public boolean ReviewRestaurantExistValidate(Long restaurantId) {
        return restaurantRepository.existsById(restaurantId);
    }

    @Override
    @Transactional
    public Review review(Long restaurantId, RestaurantRequestDTO.ReviewDTO request) {

        Member member = memberRepository.findById(request.getMemberId()).get();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Review newReview = RestaurantConverter.toReview(request, member, restaurant);

        member.setReview(newReview);
        restaurant.setReview(newReview);

        return reviewRepository.save(newReview);
    }


    // 미션 도전하기
    @Override
    public boolean MissionChallengeValidate(Map<String, Long> missionMemberIdMap) {

        Long memberId = missionMemberIdMap.get("memberId");
        Long missionId = missionMemberIdMap.get("missionId");

        List<MissionHistory> missionHistoryListByMemberId =  missionHistoryRepository.findAllByMemberId(memberId);

        List<MissionHistory> missionHistoryList = new ArrayList<>();
        for (MissionHistory missionHistory : missionHistoryListByMemberId) {
            if (missionHistory.getMission().getId().equals(missionId)) {
                missionHistoryList.add(missionHistory);
            }
        }

        return missionHistoryList.isEmpty();
    }

    @Override
    @Transactional
    public MissionHistory challenge(Long missionId, RestaurantRequestDTO.ChallengeDTO request) {

        Member member = memberRepository.findById(request.getMemberId()).get();
        Mission mission = missionRepository.findById(missionId).get();

        MissionHistory newMissionHistory = RestaurantConverter.toMissionHistory(member, mission);
        member.setMissionHistory(newMissionHistory);
        mission.setMissionHistory(newMissionHistory);

        return missionHistoryRepository.save(newMissionHistory);
    }


    // 미션 추가
    @Override
    @Transactional
    public Mission addMission(Long restaurantId, RestaurantRequestDTO.AddMissionDTO request) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Mission newMission = RestaurantConverter.toMission(request, restaurant);
        restaurant.setMission(newMission);

        return missionRepository.save(newMission);
    }
}
