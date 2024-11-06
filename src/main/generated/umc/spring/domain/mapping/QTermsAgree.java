package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTermsAgree is a Querydsl query type for TermsAgree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTermsAgree extends EntityPathBase<TermsAgree> {

    private static final long serialVersionUID = 765836337L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTermsAgree termsAgree = new QTermsAgree("termsAgree");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final NumberPath<Integer> agreeState = createNumber("agreeState", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QTerms terms;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTermsAgree(String variable) {
        this(TermsAgree.class, forVariable(variable), INITS);
    }

    public QTermsAgree(Path<? extends TermsAgree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTermsAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTermsAgree(PathMetadata metadata, PathInits inits) {
        this(TermsAgree.class, metadata, inits);
    }

    public QTermsAgree(Class<? extends TermsAgree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.terms = inits.isInitialized("terms") ? new umc.spring.domain.QTerms(forProperty("terms")) : null;
    }

}

