package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferFoodPick is a Querydsl query type for PreferFoodPick
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferFoodPick extends EntityPathBase<PreferFoodPick> {

    private static final long serialVersionUID = 1636305051L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferFoodPick preferFoodPick = new QPreferFoodPick("preferFoodPick");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QPreferFood preferFood;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPreferFoodPick(String variable) {
        this(PreferFoodPick.class, forVariable(variable), INITS);
    }

    public QPreferFoodPick(Path<? extends PreferFoodPick> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferFoodPick(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferFoodPick(PathMetadata metadata, PathInits inits) {
        this(PreferFoodPick.class, metadata, inits);
    }

    public QPreferFoodPick(Class<? extends PreferFoodPick> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.preferFood = inits.isInitialized("preferFood") ? new umc.spring.domain.QPreferFood(forProperty("preferFood")) : null;
    }

}

