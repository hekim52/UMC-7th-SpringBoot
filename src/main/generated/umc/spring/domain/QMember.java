package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final NumberPath<Long> clearMission = createNumber("clearMission", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveDate = createDateTime("inactiveDate", java.time.LocalDateTime.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MissionHistory, umc.spring.domain.mapping.QMissionHistory> missionHistoryList = this.<umc.spring.domain.mapping.MissionHistory, umc.spring.domain.mapping.QMissionHistory>createList("missionHistoryList", umc.spring.domain.mapping.MissionHistory.class, umc.spring.domain.mapping.QMissionHistory.class, PathInits.DIRECT2);

    public final StringPath myId = createString("myId");

    public final NumberPath<Long> myPoint = createNumber("myPoint", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNum = createString("phoneNum");

    public final StringPath picture = createString("picture");

    public final ListPath<PointHistory, QPointHistory> pointHistoryList = this.<PointHistory, QPointHistory>createList("pointHistoryList", PointHistory.class, QPointHistory.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.PreferFoodPick, umc.spring.domain.mapping.QPreferFoodPick> preferFoodPickList = this.<umc.spring.domain.mapping.PreferFoodPick, umc.spring.domain.mapping.QPreferFoodPick>createList("preferFoodPickList", umc.spring.domain.mapping.PreferFoodPick.class, umc.spring.domain.mapping.QPreferFoodPick.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.SetNotifyHistory, umc.spring.domain.mapping.QSetNotifyHistory> setNotifyHistoryList = this.<umc.spring.domain.mapping.SetNotifyHistory, umc.spring.domain.mapping.QSetNotifyHistory>createList("setNotifyHistoryList", umc.spring.domain.mapping.SetNotifyHistory.class, umc.spring.domain.mapping.QSetNotifyHistory.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring.domain.enums.MemberStatus> status = createEnum("status", umc.spring.domain.enums.MemberStatus.class);

    public final ListPath<umc.spring.domain.mapping.TermsAgree, umc.spring.domain.mapping.QTermsAgree> termsAgreeList = this.<umc.spring.domain.mapping.TermsAgree, umc.spring.domain.mapping.QTermsAgree>createList("termsAgreeList", umc.spring.domain.mapping.TermsAgree.class, umc.spring.domain.mapping.QTermsAgree.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

