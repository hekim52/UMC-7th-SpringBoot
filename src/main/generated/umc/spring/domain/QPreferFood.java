package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferFood is a Querydsl query type for PreferFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferFood extends EntityPathBase<PreferFood> {

    private static final long serialVersionUID = 1874756666L;

    public static final QPreferFood preferFood = new QPreferFood("preferFood");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath food = createString("food");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.PreferFoodPick, umc.spring.domain.mapping.QPreferFoodPick> preferFoodPickList = this.<umc.spring.domain.mapping.PreferFoodPick, umc.spring.domain.mapping.QPreferFoodPick>createList("preferFoodPickList", umc.spring.domain.mapping.PreferFoodPick.class, umc.spring.domain.mapping.QPreferFoodPick.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPreferFood(String variable) {
        super(PreferFood.class, forVariable(variable));
    }

    public QPreferFood(Path<? extends PreferFood> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPreferFood(PathMetadata metadata) {
        super(PreferFood.class, metadata);
    }

}

