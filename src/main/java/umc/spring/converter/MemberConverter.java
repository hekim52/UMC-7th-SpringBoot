package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewReply;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthDay(request.getBirthDay())
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MyReviewDTO myReviewDTO(Review review){

        String replyContent;
        if (review.getReviewReply() == null) {
            replyContent = null;
        } else {
            replyContent = review.getReviewReply().getContent();
        }

        return MemberResponseDTO.MyReviewDTO.builder()
                .restaurantName(review.getRestaurant().getRestaurantName())
                .star(review.getStar())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .replyContent(replyContent)
                .build();
    }

    public static MemberResponseDTO.MyReviewListDTO myReviewListDTO(Page<Review> reviewList){

        List<MemberResponseDTO.MyReviewDTO> myReviewDTOList = reviewList.stream()
                .map(MemberConverter::myReviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MyReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(myReviewDTOList.size())
                .reviewList(myReviewDTOList)
                .build();
    }

    public static MemberResponseDTO.MyMissionDTO myMissionDTO(Mission mission){

        return MemberResponseDTO.MyMissionDTO.builder()
                .missionId(mission.getId())
                .restaurantName(mission.getRestaurant().getRestaurantName())
                .moreThanPrice(mission.getMoreThanPrice())
                .getPoint(mission.getGetPoint())
                .d_Day(mission.getD_Day())
                .ownerId(mission.getOwnerId())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MyMissionListDTO myMissionListDTO(Page<Mission> missionList){

        List<MemberResponseDTO.MyMissionDTO> myMissionDTOList = missionList.stream()
                .map(MemberConverter::myMissionDTO).collect(Collectors.toList());

        return MemberResponseDTO.MyMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(myMissionDTOList.size())
                .missionList(myMissionDTOList)
                .build();
    }
}
