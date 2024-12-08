package umc.spring.service.MemberService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionHistoryRepository.MissionHistoryRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.PreferFoodRepository.FoodCategoryRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionHistoryRepository missionHistoryRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public boolean changeMissionToComplete(Long memberId, Long missionId) {

        List<MissionHistory> missionHistoryList = missionHistoryRepository.findAllByMemberIdAndMissionId(memberId, missionId);
        MissionHistory missionHistory;
        if (!missionHistoryList.isEmpty()) {
            missionHistory = missionHistoryList.get(0);
        } else {
            throw new EntityNotFoundException();
        }

        missionHistory.setMissionState(1);

        return true;
    }
}
