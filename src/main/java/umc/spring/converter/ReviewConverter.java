package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequiredArgsConstructor
public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){

        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDto request, Member member, Restaurant restaurant) {

        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .star(request.getStar())
                .content(request.getContent())
                .reviewReplyList(new ArrayList<>())
                .reviewPictureList(new ArrayList<>())
                .build();
    }
}
