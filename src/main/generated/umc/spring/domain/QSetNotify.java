package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSetNotify is a Querydsl query type for SetNotify
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSetNotify extends EntityPathBase<SetNotify> {

    private static final long serialVersionUID = 1519136543L;

    public static final QSetNotify setNotify = new QSetNotify("setNotify");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notifyContent = createString("notifyContent");

    public final ListPath<umc.spring.domain.mapping.SetNotifyHistory, umc.spring.domain.mapping.QSetNotifyHistory> setNotifyHistoryList = this.<umc.spring.domain.mapping.SetNotifyHistory, umc.spring.domain.mapping.QSetNotifyHistory>createList("setNotifyHistoryList", umc.spring.domain.mapping.SetNotifyHistory.class, umc.spring.domain.mapping.QSetNotifyHistory.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSetNotify(String variable) {
        super(SetNotify.class, forVariable(variable));
    }

    public QSetNotify(Path<? extends SetNotify> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSetNotify(PathMetadata metadata) {
        super(SetNotify.class, metadata);
    }

}

