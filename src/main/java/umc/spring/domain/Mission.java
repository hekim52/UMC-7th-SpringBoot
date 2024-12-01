package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MissionHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private Long moreThanPrice;

    @Column(nullable = false)
    private Long getPoint;

    @Column(nullable = false)
    private LocalDate d_Day;

    @Column(nullable = false)
    private Long ownerId;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MissionHistory> missionHistoryList = new ArrayList<>();

    public void setMissionHistory(MissionHistory missionHistory) {
        this.missionHistoryList.add(missionHistory);
    }
}