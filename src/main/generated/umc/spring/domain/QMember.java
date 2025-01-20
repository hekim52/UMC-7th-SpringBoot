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

    public final NumberPath<Integer> birthDay = createNumber("birthDay", Integer.class);

    public final NumberPath<Integer> birthMonth = createNumber("birthMonth", Integer.class);

    public final NumberPath<Integer> birthYear = createNumber("birthYear", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveDate = createDateTime("inactiveDate", java.time.LocalDateTime.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.domain.mapping.MemberPrefer.class, umc.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MissionHistory, umc.spring.domain.mapping.QMissionHistory> missionHistoryList = this.<umc.spring.domain.mapping.MissionHistory, umc.spring.domain.mapping.QMissionHistory>createList("missionHistoryList", umc.spring.domain.mapping.MissionHistory.class, umc.spring.domain.mapping.QMissionHistory.class, PathInits.DIRECT2);

    public final NumberPath<Long> myPoint = createNumber("myPoint", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final ListPath<PointHistory, QPointHistory> pointHistoryList = this.<PointHistory, QPointHistory>createList("pointHistoryList", PointHistory.class, QPointHistory.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Role> role = createEnum("role", umc.spring.domain.enums.Role.class);

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

