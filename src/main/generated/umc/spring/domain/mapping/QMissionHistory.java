package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionHistory is a Querydsl query type for MissionHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionHistory extends EntityPathBase<MissionHistory> {

    private static final long serialVersionUID = -1950169548L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionHistory missionHistory = new QMissionHistory("missionHistory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QMission mission;

    public final NumberPath<Integer> missionState = createNumber("missionState", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMissionHistory(String variable) {
        this(MissionHistory.class, forVariable(variable), INITS);
    }

    public QMissionHistory(Path<? extends MissionHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionHistory(PathMetadata metadata, PathInits inits) {
        this(MissionHistory.class, metadata, inits);
    }

    public QMissionHistory(Class<? extends MissionHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new umc.spring.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

