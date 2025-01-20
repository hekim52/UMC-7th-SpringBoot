package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSetNotifyHistory is a Querydsl query type for SetNotifyHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSetNotifyHistory extends EntityPathBase<SetNotifyHistory> {

    private static final long serialVersionUID = 723997077L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSetNotifyHistory setNotifyHistory = new QSetNotifyHistory("setNotifyHistory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final NumberPath<Integer> agreeState = createNumber("agreeState", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QSetNotify setNotify;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSetNotifyHistory(String variable) {
        this(SetNotifyHistory.class, forVariable(variable), INITS);
    }

    public QSetNotifyHistory(Path<? extends SetNotifyHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSetNotifyHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSetNotifyHistory(PathMetadata metadata, PathInits inits) {
        this(SetNotifyHistory.class, metadata, inits);
    }

    public QSetNotifyHistory(Class<? extends SetNotifyHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.setNotify = inits.isInitialized("setNotify") ? new umc.spring.domain.QSetNotify(forProperty("setNotify")) : null;
    }

}

