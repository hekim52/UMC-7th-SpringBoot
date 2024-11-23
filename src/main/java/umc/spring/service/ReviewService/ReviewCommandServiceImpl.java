package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean ReviewRestaurantExistValidate(Long restaurantId) {
        return restaurantRepository.existsById(restaurantId);
    }

    @Override
    @Transactional
    public Review review(Long restaurantId, ReviewRequestDTO.ReviewDto request) {

        Member member = memberRepository.findById(request.getMemberId()).get();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Review newReview = ReviewConverter.toReview(request, member, restaurant);

        member.setReview(newReview);
        restaurant.setReview(newReview);

        return reviewRepository.save(newReview);
    }
}
