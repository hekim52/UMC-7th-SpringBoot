package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionHistoryRepository.MissionHistoryRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionHistoryRepository missionHistoryRepository;

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return MemberPage;
    }

    @Override
    public Page<Mission> getMyMissionList(Long memberId, Integer page) {

        Page<Mission> MissionPage = missionHistoryRepository.findNotFinishedMissionByMemberId(memberId, PageRequest.of(page, 10));

        return MissionPage;
    }
}
