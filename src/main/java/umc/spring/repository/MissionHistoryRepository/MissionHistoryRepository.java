package umc.spring.repository.MissionHistoryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionHistory;

import java.util.List;

public interface MissionHistoryRepository extends JpaRepository<MissionHistory, Long> {

    @Query("select mh.mission from MissionHistory mh where mh.member.id = :memberId and mh.missionState = 0")
    Page<Mission> findNotFinishedMissionByMemberId(@Param("memberId") Long memberId, Pageable pageable);

    @Query("select mh from MissionHistory mh where mh.member.id = :memberId")
    List<MissionHistory> findAllByMemberId(@Param("memberId") Long memberId);

    @Query("select mh from MissionHistory mh where mh.mission.id = :missionId")
    List<MissionHistory> findAllByMissionId(@Param("missionId") Long missionId);
}
