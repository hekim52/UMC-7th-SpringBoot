package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewPicture is a Querydsl query type for ReviewPicture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewPicture extends EntityPathBase<ReviewPicture> {

    private static final long serialVersionUID = 305217882L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewPicture reviewPicture = new QReviewPicture("reviewPicture");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QReviewPicture(String variable) {
        this(ReviewPicture.class, forVariable(variable), INITS);
    }

    public QReviewPicture(Path<? extends ReviewPicture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewPicture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewPicture(PathMetadata metadata, PathInits inits) {
        this(ReviewPicture.class, metadata, inits);
    }

    public QReviewPicture(Class<? extends ReviewPicture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

