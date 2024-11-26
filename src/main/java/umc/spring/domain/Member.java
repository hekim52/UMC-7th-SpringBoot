package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.MissionHistory;
import umc.spring.domain.mapping.MemberPrefer;
import umc.spring.domain.mapping.SetNotifyHistory;
import umc.spring.domain.mapping.TermsAgree;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, length = 20)
//    private String myId;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    private Gender gender;

//    @Column(nullable = false)
//    private LocalDate birth;

    @Column(nullable = false)
    private Integer birthYear;

    @Column(nullable = false)
    private Integer birthMonth;

    @Column(nullable = false)
    private Integer birthDay;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDateTime inactiveDate;

    @ColumnDefault("0")
    private Long myPoint;

//    @Enumerated(EnumType.STRING)
//    private SocialType socialType;
//
//    @Column(nullable = false, length = 50)
//    private String email;

//    @Column(nullable = false, length = 20)
//    private String nickname;

//    @Column(nullable = false, length = 30)
//    private String email;

//    @Column(nullable = false, length = 20)
//    private String phoneNum;
//
//    @Column(nullable = false, length = 100)
//    private String picture;
//
//    @Column(nullable = false)
//    private Long clearMission;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<SetNotifyHistory> setNotifyHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<TermsAgree> termsAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PointHistory> pointHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MissionHistory> missionHistoryList = new ArrayList<>();

}
